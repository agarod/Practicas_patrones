import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class Basket {

	String variable_;
	static RandomAccessFile fichero_;
    static ArrayList<String> buffer = new ArrayList<String>();
    
    public Basket (String arg) throws FileNotFoundException {
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
		float mult_tiros = (float) 200.75;
		float mult_rebotes = (float) 148.35;
		float mult_asistencias = (float) 100.98;
		int sal_base =  675;
		int line_value;
		int tiros = 0;
		int rebotes=0;
		int asistencias = 0;
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
		            tiros = Integer.parseInt(line);
		            break;
		 	case 2: System.out.println("Asistencias");
		     		System.out.println(line);
		     		asistencias = Integer.parseInt(line);
		     		break;
		 	case 3: System.out.println("Rebotes");
		     		System.out.println(line);
		     		rebotes = Integer.parseInt(line);
		     		break;
		 	}
			
			cont++;
			j++;
		 	if (cont == 4){
		 		System.out.println(sal_base+(rebotes*mult_rebotes)+(tiros*mult_tiros)+(asistencias*mult_asistencias));
		 		System.out.println("-----");
		 		cont = 0;
		 	}
		 	else {
		 		cont= cont++;
		 	}		
		}
	}
		

	public static void main(String[] args) throws IOException {
		String argue;
		argue = args[0];
		Basket Eraser = new Basket(args[0]);
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