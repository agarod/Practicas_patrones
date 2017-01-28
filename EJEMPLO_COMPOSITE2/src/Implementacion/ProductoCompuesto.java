package Implementacion;

import java.util.ArrayList;
import java.util.Iterator;

import Base.IPrecio;
/*
 * Representara un grupo de productos cuya venta se realiza
 * de forma conjunta
 */
public class ProductoCompuesto implements IPrecio {

	private ArrayList<IPrecio> productos;
	
	public ProductoCompuesto(){
		productos = new ArrayList<IPrecio>();
	}
	
	public void addProducto(IPrecio producto){
		productos.add(producto);
	}
	
	public void removeProducto(IPrecio precio){
		productos.remove(precio);
	}
	
	public ArrayList<IPrecio> getProductos(){
		return productos;
	}
	
	@Override
	public double getImporteTotal() {
		// TODO Auto-generated method stub
		double importeTotal = 0;
		for (Iterator<IPrecio> it = productos.iterator();it.hasNext();){
			IPrecio iPrecio = it.next();
			importeTotal += iPrecio.getImporteTotal();
		}
		return importeTotal;
	}

}
