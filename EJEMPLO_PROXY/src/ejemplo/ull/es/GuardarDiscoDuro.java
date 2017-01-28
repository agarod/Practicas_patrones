package ejemplo.ull.es;

import java.util.ArrayList;

public class GuardarDiscoDuro implements IGuardar {

	@Override
	public void save(ArrayList datosAGuardar) {
		System.out.println("Guardamos los datos en el HD...");

	}

}
