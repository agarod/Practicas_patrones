package es.patron_inyeccion_dependencias.ull.es;

public class Empleado implements Iempleado {
	private Imensajeria servicio;
	
	public Empleado(Imensajeria svc){
		this.servicio=svc;
	}
	@Override
	public void procesoMensajeria(String msj, String nom) {
		// TODO Auto-generated method stub
		this.servicio.enviarMensaje(msj, nom);
	}

}
