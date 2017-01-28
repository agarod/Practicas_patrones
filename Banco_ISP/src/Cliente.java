
public class Cliente extends persona implements consultar_saldo,solicitud_crear_cuenta {

	@Override
	public void Imprimir_saldo() {
		System.out.println("Extracto del banco");
	}
	@Override
	public void SolicitudCrearCuenta(){
		System.out.println("El cliente solicuta crear cuenta");
	}
}
