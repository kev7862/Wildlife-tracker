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
