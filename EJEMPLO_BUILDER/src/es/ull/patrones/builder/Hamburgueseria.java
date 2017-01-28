package es.ull.patrones.builder;

public class Hamburgueseria {
	
	private String Nombre;
	private int Cantidad;
	private Hamburguesa hamburguesa;
	
	public int getCantidad(){
		return Cantidad;
	}
	
	public void setCantidad(int cantidad_ ){
		this.Cantidad = cantidad_;
	}
	
	public String getNombre(){
		return Nombre;
	}
	
	public void setNombre(String nombre_){
		this.Nombre = nombre_;
	}
	
	public Hamburguesa getHamburguesa(){
		return hamburguesa;
	}
	
	public void setHamburguesa(){
		this.hamburguesa = new Hamburguesa();
	}

}
