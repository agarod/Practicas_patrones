package entragble.patrones.es;



public class RegularPolygon {
	private String dimension1;
	private String dimension2; 
	private EstadoPoligono estado;
	
	public RegularPolygon(){
		estado = new Rectangulo();
	}
	
	public void cuadrado(){
		estado = new Cuadrado();
	}
	
	public void rombo() {
		estado = new Rombo();
	}
	public void rectangulo() {
		estado = new Rectangulo();
	}
	

	
	public void dibuja(Poligono poligono){
		System.out.println("Vamos a dibujar");
		poligono.dibuja(poligono);
	}
	public String getdimension1() {
		return dimension1;
	}
	public String getdimension2(){
		return dimension2;
	}
}
