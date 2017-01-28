package es.Inyeccion_Interfaces.ull.es;

import es.patron_inyeccion_dependencias.ull.es.Empleado;
import es.patron_inyeccion_dependencias.ull.es.*;

public class MensajeriaInjector implements IServicioMensajeriaInyector {

	@Override
	public Empleado getEmpleado() {
		// TODO Auto-generated method stub
		return new Empleado(new MensajeriaEmail());
	}

}
