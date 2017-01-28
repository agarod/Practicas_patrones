package es.ull.patrones.builder;

public class Hamburguesa {
	private int LonchasDeCarne;
	private String TipoDeCarne;
	private String TipoDeQueso;
	private String TipoDePan;
	private String Salsa;
	private boolean Cebolla;
	private boolean Tomate;
	
	public int getNumeroLonchasDeCarne(){
		return LonchasDeCarne;
	}
	
	public void setNumeroLonchasDeCarne(int lonchas ){
		this.LonchasDeCarne = lonchas;
	}
	
	public boolean getCebolla(){
		return Cebolla;
	}
	
	public void setCebolla(boolean cebolla_){
		this.Cebolla = cebolla_;
	}
	
	public boolean getTomate(){
		return Tomate;
	}
	
	public void setTomate(boolean tomate_){
		this.Tomate = tomate_;
	}
	
	public String getTipoDeCarne(){
		return TipoDeCarne;
	}
	
	public void setTipoDeCarne(String carne_ ){
		this.TipoDeCarne = carne_;
	}
	
	public String getTipoDeQueso(){
		return TipoDeQueso;
	}
	
	public void setTipoDeQueso(String queso_ ){
		this.TipoDeQueso = queso_;
	}
	
	public String getTipoDePan(){
		return TipoDePan;
	}
	
	public void setTipoDePan(String pan_ ){
		this.TipoDePan = pan_;
	}
	
	public String getTipoDeSalsa(){
		return Salsa;
	}
	
	public void setTipoDeSalsa(String salsa_){
		this.Salsa = salsa_;
	}

}

	