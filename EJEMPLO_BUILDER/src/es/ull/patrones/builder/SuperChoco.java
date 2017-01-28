package es.ull.patrones.builder;

public class SuperChoco extends Cocinero {

	@Override
	public void MonatajeHamburguesa() {
		// TODO Auto-generated method stub
		Hamburguesa hamburguesa = new Hamburguesa();
		
		hamburguesa.setNumeroLonchasDeCarne(2);
		hamburguesa.setTipoDeCarne("Vacuno");
		hamburguesa.setTipoDePan("Blanco");
		hamburguesa.setTipoDeQueso("Cheddar");
		hamburguesa.setTipoDeSalsa("Especial");
		hamburguesa.setTomate(true);
		hamburguesa.setCebolla(false);
	}

	@Override
	public void MontajeNombre() {
		// TODO Auto-generated method stub
		hamburgueseria.setNombre("SuperChoco");
	}

	@Override
	public void MontajeCantidad() {
		// TODO Auto-generated method stub
		hamburgueseria.setCantidad(1);
	}
	

}
