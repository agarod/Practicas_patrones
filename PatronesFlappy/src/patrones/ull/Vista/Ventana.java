package patrones.ull.Vista;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import patrones.Escenario.*;
import patrones.Personajes.IPajaro;
import patrones.Personajes.Pajaro;
import patrones.Personajes.Pajaro2;



public class Ventana extends JDialog{

	JPanel mypanel;
	final int ALTO = 700;
	final int ANCHO = 1366;
	private JPanel contentPane;

	public JComboBox comboBox = new JComboBox();
	public Container cp;
	IEscenario escenario;
	public Ventana(){

		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		comboBox.addItem("Nivel Facil");
		comboBox.addItem("Nivel Infernal");
		cp.add(comboBox, BorderLayout.EAST);

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Hay accion"+comboBox.getSelectedItem());
				if (comboBox.getSelectedItem() == "Nivel Facil"){
					escenario = new EscenarioFacil("Escenario Facil");
					try {
					Process p = Runtime.getRuntime().exec("taskkill.exe /F javaw.exe");
					
		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
					escenario.ejecutar();
					
				}
				
				if (comboBox.getSelectedItem() == "Nivel Infernal"){
					System.out.println("Escenaroi Dificil");
					escenario = new EscenarioDificil("Escenario Dificil");
					escenario.ejecutar();
				}
				
			}
			
		});
	}
	
}	