package Implementacion;

import Base.IPrecio;

/*
 * Representara productos cuya venta depende del peso del 
 * mismo, como el anterior tendra un forma distinta de calcular el precio
 */
public class ProductoPeso implements IPrecio {

	private double peso;
	private double precioPorPeso;
	private String nombre;
	private String categoria;
	
	public ProductoPeso(double peso, double precioPorPeso, String nombre, String categoria){
		this.peso = peso;
		this.precioPorPeso = precioPorPeso;
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	public double getPeso(){
		return peso;
	}
	
	public void setPeso(double peso){
		this.peso= peso;
	}
	
	public double getPrecioPorPeso(){
		return precioPorPeso;
	}
	
	public void setPrecioPorPeso(double precioPorPeso){
		this.precioPorPeso = precioPorPeso;
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
		return getPrecioPorPeso() * getPeso();
	}

}
