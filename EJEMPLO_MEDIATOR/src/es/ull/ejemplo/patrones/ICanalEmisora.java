package es.ull.ejemplo.patrones;

public interface ICanalEmisora {
	public abstract void registra(Usuario participante);
	public abstract void envia (String de, String a, String msg);
	

}
