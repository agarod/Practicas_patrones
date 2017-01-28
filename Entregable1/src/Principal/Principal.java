package Principal;


import Compresor.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("¿Que a que tipo de fichero deseas comprimir? ");
		//se le pasa la extension por linea de comandos
		String tipo = args[0];
		String ruta = "C:/entregable1.jar";
		ICompresor compr;
		switch (tipo) {
		case "rar":
			compr = new Rar();
			compr.comprime(ruta);
			break;

		case "zip":
			compr = new Zip();
			compr.comprime(ruta);
			break;
			
		default:
			break;
		}

	}

}
