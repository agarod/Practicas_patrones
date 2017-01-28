package es.ull.entregable2;

public class OneLane  implements FASocket{
	


	@Override
	public ISocket createSocket() {
		// TODO Auto-generated method stub
		Socket onepanel = new Socket();
		ISocket Unix = new UnixSocket();
		ISocket Vms = new VmsSocket();
		ISocket Nt = new NtSocket();
		onepanel.crearsocket(Unix);
		onepanel.crearsocket(Vms);
		onepanel.crearsocket(Nt);
		return null;

	}

	

	
}
