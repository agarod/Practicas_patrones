package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Curso {
  private long id;
  private String name;

  public Curso(long id, String name) {
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

  public static List<String> getListCursos() {
    String[] nameArray = {"Primero", "Segundo", "Tercero", "Cuarto"};
    return Arrays.asList(nameArray);
  }


  public static Curso EncontrarCurso(String tipoCurso) {
    for (Curso curso : todosCursos) {
      if (tipoCurso.equals(curso.getName())) {
        return curso;
      }
    }
    return null;
  }


  public static Curso getDefectoCurso() {
    return EncontrarCurso("Primero");
  }

  @Override
  public String toString() {
    return String.format("[Curso %s]", this.name);
  }


  private static List<Curso> todosCursos = new ArrayList<>();

 
  static {
    todosCursos.add(new Curso(1L, "Primero"));
    todosCursos.add(new Curso(2L, "Segundo"));
    todosCursos.add(new Curso(3L, "Tercero"));
    todosCursos.add(new Curso(4L, "Cuarto"));
  }


}
