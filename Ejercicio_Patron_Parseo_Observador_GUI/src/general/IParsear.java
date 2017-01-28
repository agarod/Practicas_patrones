package general;
import java.util.ArrayList;
import java.util.Observer;




public interface IParsear extends Observer {
	void lectura(String linea);
	ArrayList<String[]> getDatos();
}
