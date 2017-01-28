package es.ull.patrones.builder;

public abstract class Cocinero {
	
	protected Hamburgueseria hamburgueseria;
	
	public Hamburgueseria getPedido(){
		return hamburgueseria;
	}
	
	public void crearPedido(){
		hamburgueseria = new Hamburgueseria();
	}
	
	public abstract void MonatajeHamburguesa();
	
	public abstract void MontajeNombre();
	
	public abstract void MontajeCantidad();

}
