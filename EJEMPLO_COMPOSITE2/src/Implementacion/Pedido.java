package Implementacion;

import Base.IPrecio;

/*
 * Es una especializacion de la clase Producto Compuesto
 * que añade una serie de propiedades
 */
public class Pedido extends ProductoCompuesto {
	private String cliente;
	
	public Pedido(String cliente){
		super();
		this.cliente = cliente;
	}
	
	public String getCliente(){
		return cliente;
	}
	
	public void setCliente(String cliente){
		this.cliente = cliente;
	}
	@Override
	public void  addProducto(IPrecio producto){
		super.addProducto(producto);
	}
	
	@Override
	public void removeProducto(IPrecio producto) {
		super.removeProducto(producto);
	}
	
	public void estableceCantidad (IPrecio producto, int cantidadFinal){
		if (producto instanceof ProductoUnario){
			((ProductoUnario) super.getProductos().
					get(super.getProductos().indexOf(producto))).
					setCantidad(cantidadFinal);
			
		}
	}
	
	public void establecePeso(IPrecio producto, double pesoFinal) {
		if (producto instanceof ProductoPeso){
			((ProductoPeso) super.getProductos().
					get(super.getProductos().indexOf(producto))).
					setPeso(pesoFinal);
		}
	}

}
