package ejemplo.ull.es;

import java.util.ArrayList;

public class ObjetoRemoto implements IGuardar {

	@Override
	public void save(ArrayList datosAGuardar) {
		System.out.println("Guardamos en obj remoto");
	}

}
