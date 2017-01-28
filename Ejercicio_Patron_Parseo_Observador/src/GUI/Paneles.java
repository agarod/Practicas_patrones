package GUI;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import general.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import general.Irepresentacion;

public class Paneles extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mypanel;
	final int ALTO = 700;
	final int ANCHO = 1366;
	private JPanel contentPane;
	public Paneles(String titulo){

	}
	//public void add(ArrayList<String[]> datos,String Titulo,IParsear tabla) {
	public void add(String Titulo) {
		// TODO Auto-generated method stub
		
		contentPane = new JPanel();
		contentPane.setSize(ANCHO, ALTO);
		contentPane.setBorder(new EmptyBorder(555, 555, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(ANCHO, ALTO));
		
		JTextArea txtrText = new JTextArea();
		txtrText.setText("TexT");
		contentPane.add(txtrText, BorderLayout.SOUTH);
		
		JTextPane txtpnGrafico = new JTextPane();
		txtpnGrafico.setText("Grafico 1");
		contentPane.add(txtpnGrafico, BorderLayout.WEST);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addItem("Direccion 1");
		comboBox.addItem("Direccion 2 ");
		contentPane.add(comboBox, BorderLayout.EAST);
		
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Registra accion"+comboBox.getSelectedItem());
			}
			
		});
		
	}
	

}
