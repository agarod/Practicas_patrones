package principal;

import Implementacion.Pedido;
import Implementacion.ProductoCompuesto;
import Implementacion.ProductoPeso;
import Implementacion.ProductoUnario;

public class CompositePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pedido pedido = new Pedido("Lo que sea");
		ProductoPeso jamon =
				new ProductoPeso(5.0,10.0, "Jamon", "Embutidos");
		ProductoPeso lomo =
				new ProductoPeso (0.8,5.0,"Lomo Iberico","Embutidos");
		ProductoUnario paqueteDeEspaguetis = 
				new ProductoUnario (3,1.50,"Paq de Espaguetis", "Pasta");
		ProductoCompuesto cestaDeNavidad = new ProductoCompuesto();
		cestaDeNavidad.addProducto(jamon);
		cestaDeNavidad.addProducto(lomo);
		System.out.println("El importe total es : "+pedido.getImporteTotal());
		pedido.addProducto(cestaDeNavidad);
		System.out.println("El importe total es :");
		
	}

}
