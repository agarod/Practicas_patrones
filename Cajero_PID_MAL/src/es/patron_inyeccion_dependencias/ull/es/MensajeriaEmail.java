package es.patron_inyeccion_dependencias.ull.es;

public class MensajeriaEmail implements Imensajeria {

	@Override
	public void enviarMensaje(String msj, String nom) {
		System.out.println("Email enviado a "+nom+ " a nombre del usuario: "+msj);

	}

}
