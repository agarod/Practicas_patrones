package es.ull.patrones.builder;

public class MiniChoco extends Cocinero {

	@Override
	public void MonatajeHamburguesa() {
		// TODO Auto-generated method stub
		Hamburguesa hamburguesa = new Hamburguesa();
		
		hamburguesa.setNumeroLonchasDeCarne(1);
		hamburguesa.setTipoDeCarne("Vacuno");
		hamburguesa.setTipoDePan("Blanco");
		hamburguesa.setTipoDeQueso("Cheddar");
		hamburguesa.setTipoDeSalsa("Catsup");
		hamburguesa.setTomate(false);
		hamburguesa.setCebolla(true);
	}

	@Override
	public void MontajeNombre() {
		// TODO Auto-generated method stub
		hamburgueseria.setNombre("MiniChoco");
	}

	@Override
	public void MontajeCantidad() {
		// TODO Auto-generated method stub
		hamburgueseria.setCantidad(1);
	}
	

}