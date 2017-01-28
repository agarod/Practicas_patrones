package es.ull.ejemplo.patrones;

import java.util.HashMap;

public class CanalEmisora implements ICanalEmisora {
	private HashMap <String, Usuario> participantes = new HashMap<String,Usuario>();
	
	private int numero_canal;
	
	public CanalEmisora(int numero_canal){
		this.numero_canal=numero_canal;
	}
	
	@Override
	public void registra(Usuario participante) {
		// TODO Auto-generated method stub
		participantes.put(participante.getNombre(), participante);
	}

	@Override
	public void envia(String de, String a, String msg) {
		// TODO Auto-generated method stub
		if (participantes.containsKey(de) && participantes.containsKey(a)){
			Usuario u = participantes.get(a);
			u.recibe(de, msg);
		} else{
			System.out.println("Usuario inexistente");
		}
	}

}
