
public class persona {
	private String nombre;
	private String apellidos;
	private int minutos;
	private int asistencias;
	private int rebotes;
	private int tiros;
	public persona(){
		nombre = ""; apellidos = ""; minutos = 0;
	}
	public persona(String nombre,String apellidos,int minutos,int asistencias, int rebotes, int tiros) {
		this.nombre= nombre;
		this.apellidos= apellidos;
		this.minutos = minutos;
		this.asistencias = asistencias;
		this.rebotes = rebotes;
		this.tiros = tiros;
	}
	public String getNombre(){
		return nombre;
	}
	public String getApellidos(){
		return apellidos;
	}
	
	public int getMinutos(){
		return minutos;
	}
	public int getAsistencias(){
		return asistencias;
	}
	public int getRebotes(){
		return rebotes;
	}
	public int getTiros(){
		return tiros;
	}
	public String toString(){
		Integer MinutosJugados = minutos;
		Integer Asistencias = asistencias;
		return "Nombre: ".concat(nombre).concat(" Apellidos: ").concat(apellidos).concat(" Minutos jugados: ").concat(MinutosJugados.toString().concat( " Asis ").concat(Asistencias.toString()));
	}

}
