package ejemplo.patrones;

import ejemplo.patrones.Persona.Cliente;
import ejemplo.patrones.Persona.Interesado;
import ejemplo.patrones.Persona.Propietario;

public class Inmobiliaria {
	private MuestraPropiedad muestraPropiedad;
	private VentaInmueble venta;
	private CuentasAPagar cuentasAPagar;
	private AdministracionAlquiler alquiler;
	
	public Inmobiliaria(){
		muestraPropiedad = new MuestraPropiedad();
		venta = new VentaInmueble();
		cuentasAPagar = new CuentasAPagar();
		alquiler = new AdministracionAlquiler();
	}
	
	public void atencionCliente(Cliente c){
		System.out.println("Atendiendo a un cliente");
	}
	public void atencionPropietario(Propietario p){
		System.out.println("Atendiendo a un propietario");
	}
	public void atencion(Persona p){
		if (p instanceof Cliente){
			atencionCliente((Cliente)p);
		}else if (p instanceof Propietario){
			atencionPropietario((Propietario)p); //Seguir con Interesado
			
		}
	}
	
	public static void main (String[] args){
		Cliente V = new Cliente();
		Interesado i = new Interesado();
		
		
		Inmobiliaria inmo2 = new Inmobiliaria();
		inmo2.atencion(i);
		inmo2.atencion(v);
		inmo2.mostraPropiedad(123);
		inmo2.gestionVenta();
		inmo2.cobraAlquiler(1200);
		inmo2.paga(1100);
		
	}
}
