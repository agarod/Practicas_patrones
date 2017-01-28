package es.ull.patrones.builder;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Establecimiento establecimiento = new Establecimiento();
		establecimiento.setCocinero(new SuperChoco());
		establecimiento.crearpedido();
		
		Hamburgueseria hamburgueseria = establecimiento.getHamburgueseria();
		
		System.out.println(hamburgueseria.getNombre());
		System.out.println(hamburgueseria.getCantidad());		

	}

}
