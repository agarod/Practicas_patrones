package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import general.*;
import javax.swing.JComboBox;

public class Ventana1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
	//Estas dos lineas añadidas
	private static final long serialVersionUID = 1L;
//	public Ventana1(String titulo){
//
//	
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ventana1 frame = new Ventana1(null, title, title, title);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Ventana1(ArrayList<String[]> datos,String Title, String SubTitle,String RedLine) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTextArea txtrText = new JTextArea();
		txtrText.setText("TexT");
		contentPane.add(txtrText, BorderLayout.SOUTH);
		
		JTextPane txtpnGrafico = new JTextPane();
		txtpnGrafico.setText("Grafico 1");
		contentPane.add(txtpnGrafico, BorderLayout.WEST);
		txtpnGrafico.add(new JFreeChartXY(Title, SubTitle,datos,RedLine));
		
//		JFreeChartXY chart = new JFreeChartXY(Title, SubTitle,datos,RedLine);
//	    chart.pack();
//	    chart.setVisible(true);
		
		JTextPane txtpnGrafico_1 = new JTextPane();
		txtpnGrafico_1.setText("Grafico 2");
		contentPane.add(txtpnGrafico_1, BorderLayout.EAST);
		
		JComboBox comboBox = new JComboBox();
		contentPane.add(comboBox, BorderLayout.NORTH);
	}

}
