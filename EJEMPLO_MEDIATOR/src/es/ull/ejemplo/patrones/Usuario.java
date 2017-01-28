package es.ull.ejemplo.patrones;

public class Usuario implements IUsuario {

	private String nombre;
	private CanalEmisora salon;
	
	public Usuario(CanalEmisora salonDeChat){
		salon = salonDeChat;
	}
	
	@Override
	public void recibe(String de, String msg) {
		// TODO Auto-generated method stub
		String s =/* de +*/ "dice: " + msg;
		System.out.println(nombre+ " " +s);
	}

	@Override
	public void envia(String a, String msg) {
		// TODO Auto-generated method stub
		salon.envia(nombre, a ,msg);
	}
	
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
}
