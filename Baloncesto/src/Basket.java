import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class Basket {

	ArrayList<Jugador> J = null;
	
	public void ImprimirDatos(){
		int longitud = J.size();
		for( int i = 0 ; i < longitud ; i++ ){
			J.get(i).imprimir();
		}
	}
	
	public void ImprimiJugadores(){
			
		int longitud = J.size();
		for( int i = 0 ; i < longitud ; i++ ){
			J.get(i).imprimirJugador();
		}
		
	}
	
	public Basket( String arg ) throws IOException{
	
		RandomAccessFile fichero = new RandomAccessFile( arg , "r" );
		J = new ArrayList<Jugador>();
		
		String line;
		
		do {

			Jugador AuxJugador = new Jugador();
			
			line = fichero.readLine();	
			
			if( line == null )
				break;
			
			AuxJugador.setNombre( line );
			line = fichero.readLine();
			AuxJugador.setTiros( Integer.parseInt( line ) );
			line = fichero.readLine();
			AuxJugador.setAsistencias( Integer.parseInt( line ) );
			line = fichero.readLine();
			AuxJugador.setRebotes( Integer.parseInt( line ) );
			J.add( AuxJugador );
			
		}while( line != null );
		
		fichero.close();
		
		ImprimirDatos();
		System.out.println("--------------");
	}
		

	public static void main(String[] args) throws IOException {
		new Basket( args[0] ).ImprimiJugadores();
	}

}

