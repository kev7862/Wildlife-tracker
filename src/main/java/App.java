import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("animals", Animal.all());
      model.put("endangeredAnimals", EndangeredAnimal.all());
      model.put("sightings", Sighting.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    


    post("/sighting", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  String rangerName = request.queryParams("rangerName");
  int animalIdSelected = Integer.parseInt(request.queryParams("animalSelected"));
  String latLong = request.queryParams("latLong");
  Sighting sighting = new Sighting(animalIdSelected, latLong, rangerName);
  sighting.save();
  model.put("sighting", sighting);
  model.put("animals", Animal.all());
  String animal = Animal.find(animalIdSelected).getName();
  model.put("animal", animal);
  model.put("template", "templates/success.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
}
}
