
public class Partida {
	
	private String Nombre;
	private int puntaje;
	private String Tipo;
	private String Juego;
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getJuego() {
		return Juego;
	}
	public void setJuego(String juego) {
		Juego = juego;
	}
	
	private GuardarPartida p = new GuardarPartida();
	
	public void guardar(){
		p.guardar(this);
	}
	

}
