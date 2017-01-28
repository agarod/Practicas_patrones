package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.StudentFormData;


public class Estudiante {
  private long id;
  private String name;
  private String password;
  private List<Acceso> Accesos = new ArrayList<>(); 
  private Curso Cursos;
  private Anios anios;
  private List<Titulacion> titulacions = new ArrayList<>(); 

 
  public Estudiante() {
  }

  public Estudiante(long id, String name, String password, Curso curso, Anios anio) {
    this.setId(id);
    this.name = name;
    this.password = password;
    this.Cursos = curso;
    this.anios = anio;
  }
  

  private long getId() {
    return id;
  }


  private void setId(long id) {
    this.id = id;
  }

  public boolean hasAnio(String contAnio) {
    for (Acceso anio : this.Accesos) {
      if (contAnio.equals(anio.getName()))
        return true;
    }
    return false;
  }

  public void anadirAnio(Acceso acceso) {
    this.Accesos.add(acceso);
  }

  public boolean hasTitulacion(String tipoTitulacion) {
    for (Titulacion titulacion : this.getTitulacion()) {
      if (tipoTitulacion.equals(titulacion.getName()))
        return true;
    }
    return false;
  }

  public String toString() {
    return String.format("[Nombre del estudiante: '%s' Password: '%s' Acceso: %s Curso: %s Años: %s Titulacion: %s]", this.getName(),
        this.getPassword(), this.Accesos, this.Cursos, this.anios, this.getTitulacion());
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public Curso getCurso() {
    return Cursos;
  }


  public void setCurso(Curso curso) {
    this.Cursos = curso;
  }


  public Anios getAnio() {
    return anios;
  }


  public void setAnios(Anios anios) {
    this.anios = anios;
  }


  public List<Titulacion> getTitulacion() {
    return titulacions;
  }


  public void setTitulacion(List<Titulacion> titulacion) {
    this.titulacions = titulacion;
  }

  public void anadirTitulacion(Titulacion titulacion) {
    this.titulacions.add(titulacion);
  }


  public static DatosEstudiante DatosEstudiantesForm(long id) {
    for (Estudiante estudiante : todosEstudiantes) {
      if (estudiante.getId() == id) {
        return new DatosEstudiante(estudiante.name, estudiante.password, estudiante.Cursos, estudiante.anios, estudiante.Accesos, estudiante.titulacions);
      }
    }
    throw new RuntimeException("No se ha podido encontrar al estudiante");
  }
  


  public static Estudiante makeInstance(DatosEstudiante formData) {
    Estudiante estudiante = new Estudiante();
    estudiante.name = formData.name;
    estudiante.password = formData.password;
    for (String anios : formData.hobbies) {
      estudiante.Accesos.add(Acceso.EncontrarAcceso(anios));
    }
    estudiante.Cursos = Curso.EncontrarCurso(formData.level);
    estudiante.anios = Anios.encontrarAnio(formData.gpa);
    for (String titulacion : formData.majors) {
      estudiante.titulacions.add(Titulacion.EncontrarTitulacion(titulacion));
    }
    return estudiante;
  }
  
 
  private static List<Estudiante> todosEstudiantes = new ArrayList<>();


}
