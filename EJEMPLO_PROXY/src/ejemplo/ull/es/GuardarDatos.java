package ejemplo.ull.es;

import java.util.ArrayList;

public class GuardarDatos implements IGuardar {

	@Override
	public void save(ArrayList datosAGuardar) {
		// TODO Auto-generated method stub
		if (ConnectionManager.hayConexion())
			new ObjetoRemoto().save(datosAGuardar);
		else
			new GuardarDiscoDuro().save(datosAGuardar);
	}

}
