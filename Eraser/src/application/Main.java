package application;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

class Sec_Eraser {
	final static int MAX = 122;
	final static int MIN = 48;
	
	String variable_;
	static RandomAccessFile fichero_;
    static ArrayList<String> buffer = new ArrayList<String>();
    
	public Sec_Eraser(String arg) throws FileNotFoundException {
		variable_ = arg;
		fichero_ = new RandomAccessFile(variable_, "rw");
	}
	
	public void OpenFile() throws IOException{
		try{
			
			do {
				System.out.println(fichero_.readLine());
			}	while ((fichero_.readLine()) !=null);
		}
		catch(IOException e){
			System.out.println("Error con el fichero");
			return;
		}
	}
}


public class Main extends Application {
	Sec_Eraser Lala;

	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			String value;
			value = "Security Eraser";
			primaryStage.setTitle(value);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
