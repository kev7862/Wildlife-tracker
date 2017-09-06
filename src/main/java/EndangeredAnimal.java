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
