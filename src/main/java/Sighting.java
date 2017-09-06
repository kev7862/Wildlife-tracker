import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Sighting {
  private int animal_id;
  private String location;
  private String ranger_name;
  private int id;

  public Sighting(int animal_id, String location, String ranger_name) {
    this.animal_id = animal_id;
    this.location = location;
    this.ranger_name = ranger_name;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public int getAnimalId() {
    return animal_id;
  }

  public String getLocation() {
    return location;
  }

  public String getRangerName() {
    return ranger_name;
  }
//Created an override function that checks two instances of the Sighting class and fetch the Aniimal id,  location, and RangerName
  @Override
  public boolean equals(Object otherSighting) {
    if(!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getAnimalId() == (newSighting.getAnimalId()) && this.getLocation().equals(newSighting.getLocation()) && this.getRangerName().equals(newSighting.getRangerName());
    }
  }
// Attempting connection to DB sightings table save the: animal id, location and ranger_name by their appropriate id
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (animal_id, location, ranger_name) VALUES (:animal_id, :location, :ranger_name);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("animal_id", this.animal_id)
        .addParameter("location", this.location)
        .addParameter("ranger_name", this.ranger_name)
        .throwOnMappingFailure(false)
        .executeUpdate()
        .getKey();
    }
  }
//Creating a Sighting List then attemting connection to the DB and return everything with with an id
  public static List<Sighting> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings;";
      return con.createQuery(sql)
        .throwOnMappingFailure(false)
        .executeAndFetch(Sighting.class);
    }
  }

  // Trying connection to DB sightings table, find and Return everything with an id. And also try to catch any error that might occur. 
  public static Sighting find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM sightings WHERE id=:id;";
    Sighting sighting = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Sighting.class);
    return sighting;
  } catch (IndexOutOfBoundsException exception) {
    return null;
  }
}

}
