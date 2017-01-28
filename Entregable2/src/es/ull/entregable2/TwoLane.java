package es.ull.entregable2;

public class TwoLane {
	
	public Pipe crearPipe(){
		Pipe twolane = new Pipe();
		IPipe Unix = new UnixPipe();
		IPipe Vms = new VmsPipe();
		IPipe Nt = new NtPipe();
		twolane.crearsocket(Unix);
		twolane.crearsocket(Vms);
		twolane.crearsocket(Nt);
		return twolane;
	}

	
}
