import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimal {
  public String name;
  public int id;
  public boolean endangered;
  private String health;
  private String age;

  public EndangeredAnimal(String name, String health, String age) {
    this.name = name;
    this.id = id;
    this.health = health;
    this.age = age;
  }

  public String getHealth() {
    return health;
  }

  public String getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  @Override
public boolean equals(Object otherEndangeredAnimal) {
  if(!(otherEndangeredAnimal instanceof EndangeredAnimal)) {
    return false;
  } else {
    EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherEndangeredAnimal;
    return this.getName().equals(newEndangeredAnimal.getName()) && this.getHealth().equals(newEndangeredAnimal.getHealth()) && this.getAge().equals(newEndangeredAnimal.getAge());
  }
}

public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO endangered_animals (name, health, age) VALUES (:name, :health, :age);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("health", this.health)
        .addParameter("age", this.age)
        .executeUpdate()
        .getKey();
    }
  }
//Creating a connection to the DB endagered _animals table and return everything in a List called EndangeredAnimals"
  public static List<EndangeredAnimal> all() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM endangered_animals;";
    return con.createQuery(sql)
      .executeAndFetch(EndangeredAnimal.class);
  }
}
// trying a connection to the DB endagered_animals table and updating each animal's health by its id
public void updateHealth(String health) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE endangered_animals SET health=:health WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .addParameter("health", health)
        .executeUpdate();
    }
  }
