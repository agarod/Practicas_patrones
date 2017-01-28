package es.ull.entregable2;

public class Paralell {
	
	public Thread crearThread(){
		Thread twolane = new Thread();
		IThread Unix = new UnixThread();
		IThread Vms = new VmsThread();
		IThread Nt = new NtThread();
		twolane.crearsocket(Unix);
		twolane.crearsocket(Vms);
		twolane.crearsocket(Nt);
		return twolane;
	}

	
}
