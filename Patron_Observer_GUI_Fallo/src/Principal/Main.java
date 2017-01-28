package Principal;


import java.util.Observable;

import javax.swing.JTextArea;

import GUI.Dibujo;
import GUI.Dibujo.Paneles;


 class  Main extends Observable {
	Paneles ventana;
	JTextArea txtrText;

    Main(){
//    	addWindowListener(new WindowAdapter() {
//        public void windowClosing(WindowEvent e) {
//             System.exit(0);
//   }});
    	
    	Dibujo panel = new Dibujo();

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main programa = new Main();
		
	}

}
