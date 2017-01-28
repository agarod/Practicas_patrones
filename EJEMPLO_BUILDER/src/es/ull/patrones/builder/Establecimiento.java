package es.ull.patrones.builder;

public class Establecimiento {
	
	private Cocinero cocinero;
	
	public void crearpedido(){
		cocinero.crearPedido();
		cocinero.MontajeNombre();
		cocinero.MontajeCantidad();
		cocinero.MonatajeHamburguesa();		
	}
	
	public void setCocinero(Cocinero cocinero_){
		cocinero = cocinero_;
	}
	
	public Hamburgueseria getHamburgueseria(){
		return cocinero.getPedido();
	}

}
