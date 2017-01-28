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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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
		
		
//		RepGraf.representacion(datos, "Tabla", "Datos de Lluvia", "mm de Lluvia");
		//Por aqui 
//		System.out.println("Hola");
//		setTitle(Titulo);
//		setSize(ANCHO,ALTO);
//		mypanel = new JPanel();
//		getContentPane().setLayout(new BorderLayout());
//		getContentPane().add(new JButton("NORTH"), BorderLayout.NORTH);
		//Poner en text datos
		
//		String [] aux;
//		for (int i=0; i< datos.size(); i++)
//		aux = datos.get(3);
		
//		
//		
//		getContentPane().add(new JTextArea("texto"), BorderLayout.SOUTH);
//		mypanel.add(new JButton("Boton 1"));
		
		contentPane = new JPanel();
	//	contentPane.setSize(0, 0);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTextArea txtrText = new JTextArea();
		txtrText.setText("TexT");
		contentPane.add(txtrText, BorderLayout.SOUTH);
		
		JTextPane txtpnGrafico = new JTextPane();
		txtpnGrafico.setText("Grafico 1");
		contentPane.add(txtpnGrafico, BorderLayout.WEST);
		
//		
//		ChartPanel chartPanel = new ChartPanel(null); 
//		chartPanel.setPreferredSize(new java.awt.Dimension(640, 480));
//		contentPane.add(chartPanel, BorderLayout.CENTER);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addItem("http://www.metoffice.gov.uk");
		comboBox.addItem("https://d2khazk8e83rdv.cloudfront.net");
		contentPane.add(comboBox, BorderLayout.EAST);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Hay accion"+comboBox.getSelectedItem());
			}
			
		});
		
		//this.add(mypanel);
		//this.add(contentPane);
	}
	

}
