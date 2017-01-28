import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

class Salario{
	private double sueldo_base = 650;
	private double Seg_social = 0.05;
	static ArrayList<String> almacen = new ArrayList<String>();
	
	public void Calc_Salario(){
		
	}
	
	private ArrayList<String> buffer;
	
	
	public Salario( ArrayList<String> buffer ){
		this.buffer = buffer;
	}


	
	
	
}

class Baloncesto {
	
	String variable_;
	static RandomAccessFile fichero_;
    static ArrayList<String> buffer = new ArrayList<String>();
    
    public Baloncesto (String arg) throws FileNotFoundException {
		variable_ = arg;
		fichero_ = new RandomAccessFile(variable_, "rw");
	}
    

	public void FileDump() throws IOException{
		String line;
		line = fichero_.readLine();
		while( line != null )
		{
			System.out.println(line);
			System.out.println("----------");
			buffer.add(line);
			line = fichero_.readLine();
		}
	}
    
	public void ReadDump() throws IOException{
		int line_value;
		String line, line2;
		String cadena = new String();
		fichero_.seek(0);
		int cont = 0;
		int j = 0;
		int numero = buffer.size();
		System.out.println(numero + "el numero de filas que tiene el buffer");
		while (j< buffer.size()){
			line= buffer.get(j);
			switch (cont){
		 	case 0: System.out.println("Nombre");
		 	        System.out.println(line);
		 	        break;
		 	case 1: System.out.println("Tiros");
		            System.out.println(line);
		            break;
		 	case 2: System.out.println("Asistencias");
		     		System.out.println(line);
		     		break;
		 	case 3: System.out.println("Rebotes");
		     		System.out.println(line);
		     		break;
		 	}
			
			cont++;
			j++;
		 	if (cont == 3){
		 		cont = 0;
		 	}
		 	else {
		 		cont= cont++;
		 	}		
		}
	}
	
public class 
    public static void main( String[] args ) throws FileNotFoundException {
		String argue;
		argue = args[0];
		Baloncesto Eraser = new Baloncesto(args[0]);
		try{
		//		System.out.println("el valor de i ->"+i);
			Eraser.FileDump();
			Eraser.ReadDump();

			}
		
			catch (IOException e){
				System.out.println("Error con el fichero");
				return;
			}
			try{
				fichero_.close();
			}
			
			catch (IOException e){
				System.out.println("No se puede cerrar el fichero");
				return;
			}
    }
}
    