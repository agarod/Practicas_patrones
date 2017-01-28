package Implementacion;

import Base.IPrecio;
/*
 * Clase que define un producto de precio por unidad
 */
public class ProductoUnario implements IPrecio {
	private int cantidad;
	private double precio;
	private String nombre;
	private String categoria;
	
	/*
	 * Constructor parametrizado de los objetos de esta clase
	 */
	public ProductoUnario(int cantidad,double precio,String nombre,
			String categoria){
		this.cantidad = cantidad;
		this.precio = precio;
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	public int getCantidad(){
		return cantidad;
	}
	
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	
	public double getPrecio(){
		return precio;
	}
	
	public void setPrecio(double precio){
		this.precio = precio;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}	
	
	public String getCategoria(){
		return categoria;
	}
	
	public void setCategoria(String categoria){
		this.categoria = categoria;
	}
	
	
	@Override
	public double getImporteTotal() {
		// TODO Auto-generated method stub
		return getCantidad()* getPrecio();
	}

}
