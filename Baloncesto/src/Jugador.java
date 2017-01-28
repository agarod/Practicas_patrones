
public class Jugador {
	
	private String nombre = "";
	private SalarioJugador salario;
	private int rebotes = 0;
	private int asistencias = 0;
	private int tiros = 0;
	
	public Jugador(){
		salario = new SalarioJugador();
	}
	
	public void imprimir(){
		System.out.println(getNombre());
		System.out.println(getTiros());
		System.out.println(getAsistencias());
		System.out.println(getRebotes());
	}
	
	public void imprimirJugador(){
		System.out.println(getNombre());
		System.out.println(getSalario());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	float getSalario() {
		return salario.getSalario( this );
	}

	public int getRebotes() {
		return rebotes;
	}

	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}

	public int getTiros() {
		return tiros;
	}

	public void setTiros(int tiros) {
		this.tiros = tiros;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	
	
	
}
