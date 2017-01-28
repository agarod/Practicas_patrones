public class SalarioJugador {

	private float mult_tiros = (float) 200.75;
	private float mult_rebotes = (float) 148.35;
	private float mult_asistencias = (float) 100.98;
	private int sal_base =  675;
	
	float getSalario( Jugador jugador ){
		return sal_base+(jugador.getRebotes()*mult_rebotes)+(jugador.getTiros()*mult_tiros)+(jugador.getAsistencias()*mult_asistencias);
	}
	
}
