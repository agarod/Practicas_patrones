package patrones.model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/*
 * Abre, elimina y lee el fichero
 */

public class GestionFichero {
	
	String path_;

	static RandomAccessFile fichero_;
	static ArrayList<String> buffer = new ArrayList<String>();
	static ArrayList<String> buffer2 = new ArrayList<String>();
	
	
	public GestionFichero(){}
	
	public ArrayList<String> abrirFichero(ArrayList<String> listaPath) throws IOException {
		String line = "";
		path_ = listaPath.get(0);
		System.out.println("EL VALOR DE VARIABLE_ es --> "+path_);
		fichero_ = new RandomAccessFile(path_, "rw");

		while( line != null ){

			line = fichero_.readLine();
			buffer.add(line);
			System.out.println(line);
			System.out.println("----------");

		}

		buffer.remove(buffer.size()-1);
		return buffer;

	}
	
	public void eliminarFichero(){
		
		System.out.println("Ahora elimino fichero");
		System.out.println(path_);
		

		try {
		
			fichero_.close();
		
		} catch (IOException e) {

			e.printStackTrace();
		}
		/*
		 * Fragmento comentado para poder mostrar que efectivamente se modifica el fichero antes de ser eliminado
		 */
//		File file = new File(path_);  
//		file.delete();  

	}
	
	
	public void escribirFichero( ArrayList<String> buffer ){
		
		String line= "";
		Integer line_length = 0;
		String cadena = "";
		String line2;
		
		try {
			fichero_.seek(0);
			
			for (int i = 0; i < buffer.size(); i++){
				
				cadena = buffer.get(i);
				fichero_.writeBytes(cadena);
				cadena = "";
				
			}
//			fichero_.close();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> OpenFile(RandomAccessFile fichero_) throws IOException{
		
		String line;
		line = fichero_.readLine();
		
		while( line != null )
		{
			System.out.println(line);
			System.out.println("----------");
			buffer.add(line);
			line = fichero_.readLine();
		}
		
		for(int i = 0; i < buffer.size(); i++){
			System.out.println("--->");
			System.out.println(buffer.get(i));
		}
		
		return buffer;
	
	}
	
}
