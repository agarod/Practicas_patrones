package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.bootstrap3.formdata.DatosEstudiante;


public class Titulacion {
  private long id;
  private String name;

  public Titulacion(long id, String name) {
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

  public static Map<String, Boolean> TipTitulacion(DatosEstudiante estudiante) {
    Map<String, Boolean> mapTitulacion = new HashMap<String, Boolean>();
    for (Titulacion titulacion : todasTitulaciones) {
      mapTitulacion.put(titulacion.getName(),  (estudiante == null) ? false : estudiante.Titulacions.contains(titulacion.getName()));
    }
    return mapTitulacion;
  }

  public static Titulacion EncontrarTitulacion(String TipoTitulacion) {
    for (Titulacion titulacion : todasTitulaciones) {
      if (TipoTitulacion.equals(titulacion.getName())) {
        return titulacion;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return String.format("[Titulacion %s]", this.name);
  }


  private static List<Titulacion> todasTitulaciones = new ArrayList<>();

  static {
    todasTitulaciones.add(new Titulacion(1L, "Grado en Ingenieria Quimica"));
    todasTitulaciones.add(new Titulacion(2L, "Grado en Ingenieria Industrial"));
    todasTitulaciones.add(new Titulacion(3L, "Grado en Medicina"));
    todasTitulaciones.add(new Titulacion(4L, "Grado en Ingenieria Informatica"));
  }


}
