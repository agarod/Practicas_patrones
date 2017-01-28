package views.bootstrap3.formdata;

import models.Curso;
import models.Anios;
import models.Acceso;
import models.Titulacion;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

public class DatosEstudiante {

  public String name = "";
  public String password = "";
  public List<String> Accesos = new ArrayList<>(); 
  public String Cursos = "";
  public String Anios = "";
  public List<String> Titulacions = new ArrayList<>(); 

  
  public DatosEstudiante() {
  }

  public DatosEstudiante(String name, String password, Curso curso, Anios anios, List<Acceso> acceso, List<Titulacion> titulaciones) {
    this.name = name;
    this.password = password;
    this.Cursos = curso.getName();
    this.Anios = anios.getName();
    for(Acceso access : acceso) {
      this.Accesos.add(access.getName());
    }
    for(Titulacion titulacion : titulaciones) {
      this.Titulacions.add(titulacion.getName());
    }
  }


  public List<ValidationError> validate() {

    List<ValidationError> errores = new ArrayList<>();

    if (name == null || name.length() == 0) {
      errores.add(new ValidationError("name", "No se ha puesto nombre"));
    }

    if (password == null || password.length() == 0) {
      errores.add(new ValidationError("password", "No se puesto password."));
    } else if (password.length() < 5) {
      errores.add(new ValidationError("password", "El password dado es mas pequeño de 5 caracteres"));
    }

    if (Accesos.size() > 0) {
      for (String access : Accesos) {
        if (Acceso.EncontrarAcceso(access) == null) {
          errores.add(new ValidationError("Transporte", "Transporte desconocido: " + access + "."));
        }
      }
    }

  
    if (Cursos == null || Cursos.length() == 0) {
      errores.add(new ValidationError("Curso", "No se ha dado ningun curso"));
    } else if (Curso.EncontrarCurso(Cursos) == null) {
      errores.add(new ValidationError("Curso", "curso erroneo: " + Cursos + "."));
    }

    if (Anios == null || Anios.length() == 0) {
      errores.add(new ValidationError("años", "no añadido año."));
    } else if (Anios.encontrarAnio(Anios) == null) {
      errores.add(new ValidationError("años", "año invalido " + Anios + "."));
    }

    if (Titulacions.size() > 0) {
      for (String titulacion : Titulacions) {
        if (Titulacion.EncontrarTitulacion(titulacion) == null) {
          errores.add(new ValidationError("Titulacion", "Titulacion desconocida: " + titulacion + "."));
        }
      }
    }

    if(errores.size() > 0)
      return errores;

    return null;
  }
}
