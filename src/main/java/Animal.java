import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Animal {
  public String name;
  public int id;

  public Animal(String name) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }
