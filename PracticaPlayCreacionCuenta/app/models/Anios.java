package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import views.bootstrap3.formdata.DatosEstudiante;


public class Anios {
  private long id;
  private String name;

  public Anios(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }


  public static Map<String, Boolean> anios(DatosEstudiante estudiante) {
    Map<String, Boolean> canAnios = new TreeMap<String, Boolean>();
    for (Anios anios : todosAnios) {
      canAnios.put(anios.getName(),  (estudiante == null) ? false : (estudiante.gpa != null && estudiante.gpa.equals(anios.getName())));
    }
    return canAnios;
  }


  public static List<String> ListAnios() {
    String[] nameArray = {"0-1", "1-2", "2-3", "3-4", "mas de 4 "};
    return Arrays.asList(nameArray);
  }


  public static Anios encontrarAnio(String cantAnios) {
    for (Anios anio : todosAnios) {
      if (cantAnios.equals(anio.getName())) {
        return anio;
      }
    }
    return null;
  }

  public static Anios DefectoAnio() {
    return encontrarAnio("mas de 4");
  }

  @Override
  public String toString() {
    return String.format("[Años %s]", this.name);
  }


  private static List<Anios> todosAnios = new ArrayList<>();


  static {
    todosAnios.add(new Anios(4L, "> 4 años"));
    todosAnios.add(new Anios(2L, "2 - 4"));
    todosAnios.add(new Anios(3L, "1 - 2"));
    todosAnios.add(new Anios(1L, "0 - 1 año"));

  }


}
