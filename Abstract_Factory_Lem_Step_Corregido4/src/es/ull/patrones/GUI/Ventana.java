package es.ull.patrones.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import es.ull.patrones.Laberinto.FabricaAbstractaLaberintos;
import es.ull.patrones.Laberinto.JuegoDelLaberintoConBombas;
import es.ull.patrones.Laberinto.JuegoDelLaberintoNormal;
import es.ull.patrones.Laberinto.JuegoDelLaberinoConPuertasBomba;



public class Ventana extends JDialog{
	// load background layer
	JPanel mypanel;
	final int ALTO = 700;
	final int ANCHO = 1366;
	private JPanel contentPane;

	public JComboBox comboBox = new JComboBox();
	public Container cp;
	FabricaAbstractaLaberintos labe;
	public Ventana(){

		cp = getContentPane();
		//cp.add(sp);
		cp.setLayout(new BorderLayout());
		
		comboBox.addItem("Escenario 1");
		comboBox.addItem("Escenario 2");
		cp.add(comboBox, BorderLayout.EAST);

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Hay accion"+comboBox.getSelectedItem());
				if (comboBox.getSelectedItem() == "Escenario 1"){
					labe = new JuegoDelLaberintoNormal();
					labe.accion();
//					 try
//				        {
//				            AppGameContainer app = new AppGameContainer(new WizardGame());
//				            app.setForceExit(false);
//				            app.setDisplayMode(500, 400, false);
//				            app.start();
//				        }
//				        catch (SlickException e)
//				        {
//				            e.printStackTrace();
//				        }
					
				}
				if (comboBox.getSelectedItem() == "Escenario 2"){
					System.out.println("Escenario 2");
					labe = new JuegoDelLaberinoConPuertasBomba();
					labe.accion();
				}
			}
		});
	}
}	