package controllers;

import models.Curso;
import models.Anios;
import models.Acceso;
import models.Titulacion;
import models.Estudiante;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.bootstrap3.formdata.DatosEstudiante;
import views.html.index;


public class Application extends Controller {


  public static Result getIndex(long id) {
    DatosEstudiante DatosEstudiante = (id == 0) ? new DatosEstudiante() : models.Estudiante.DatosEstudiantesForm(id);
    Form<DatosEstudiante> DatosForm = Form.form(DatosEstudiante.class).fill(DatosEstudiante);
    return ok(index.render(
      DatosForm,
      Acceso.TiposAcceso(DatosEstudiante),
      Curso.getListCursos(),
      Anios.anios(DatosEstudiante),
      Titulacion.TipTitulacion(DatosEstudiante)
    ));
  }


  public static Result postIndex() {


    Form<DatosEstudiante> Datosform = Form.form(DatosEstudiante.class).bindFromRequest();

    if (Datosform.hasErrors()) {
 
      flash("error", "Corrija los errores.");
      return badRequest(index.render(Datosform,
        Acceso.TiposAcceso(null), 
        Curso.getListCursos(),
        Anios.anios(null), 
        Titulacion.TipTitulacion(null) 
      ));
    }
    else {

      Estudiante estudiante = Estudiante.makeInstance(Datosform.get());
      flash("Perfecto", "Estudiante creado: " + estudiante);
      return ok(index.render(Datosform,
        Acceso.TiposAcceso(Datosform.get()),
        Curso.getListCursos(),
        Anios.anios(Datosform.get()),
        Titulacion.TipTitulacion(Datosform.get())
      ));
    }
  }
}
