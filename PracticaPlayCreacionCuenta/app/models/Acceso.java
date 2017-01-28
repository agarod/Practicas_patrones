package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import views.bootstrap3.formdata.DatosEstudiante;


public class Acceso {
  private long id;
  private String name;

  public Acceso(long id, String name) {
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


  public static Map<String, Boolean> TiposAcceso(DatosEstudiante estudiante) {
    Map<String, Boolean> Acceso = new HashMap<String, Boolean>();
    for (Acceso acceso : todosAccesos) {
      Acceso.put(acceso.getName(), (estudiante != null && estudiante.Accesos.contains(acceso.getName())));
    }
    return Acceso;
  }


  public static Acceso EncontrarAcceso(String tipAcceso) {
    for (Acceso acceso : todosAccesos) {
      if (tipAcceso.equals(acceso.getName())) {
        return acceso;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return String.format("[Tipo de acceso %s]", this.name);
  }

  private static List<Acceso> todosAccesos = new ArrayList<>();


  static {
    todosAccesos.add(new Acceso(1L, "PAU"));
    todosAccesos.add(new Acceso(2L, "Ciclo Superior"));
    todosAccesos.add(new Acceso(3L, "Mayores de 25"));
    
  }


}
