package es.ull.entregable2;

import java.util.ArrayList;


public class Socket {
	private ArrayList<ISocket> socket = new ArrayList<ISocket>();
	public void crearsocket(ISocket socket) {
		this.socket.add(socket);
	}

}
