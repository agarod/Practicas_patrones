package entragble.patrones.es;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Poligono poligono1 = new Poligono();
		
		RegularPolygon regpol = new RegularPolygon();
		regpol.dibuja(poligono1);
		regpol.rectangulo();
		regpol.dibuja(poligono1);

		

	}

}
