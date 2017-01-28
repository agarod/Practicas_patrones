package es.ull.ejemplo.patrones;

public class Principal {
	public static void main(String[] args){
		CanalEmisora salon = new CanalEmisora(1);
		
		Usuario usu = new Usuario(salon);
		usu.setNombre("Centralita");
		salon.registra(usu);
		
		Usuario usu1 = new Usuario(salon);
		usu1.setNombre("Taxi LC:4506");
		salon.registra(usu1);
		
		Usuario usu2 = new Usuario(salon);
		usu2.setNombre("Cliente");
		salon.registra(usu2);
		
		usu2.envia("Cliente", "Solicito un taxi para Avda Astrofisico");
		usu.envia("Centralita", "Solicitan servicio en Avda Astrofisico");
		usu1.envia("Taxi LC:4506", "Recibido");
	}
		

}
