package GUI;

import java.util.Observable;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Parseo.IParsear;
import Parseo.Web1;
import Parseo.Web2;
import Principal.Acceder;
import Representacion.IRepresentacion;
import Representacion.RepresentacionGrafica;
import Representacion.RepresentacionTexto;



public class Dibujo extends Observable {
	
	
	
	public Paneles ventana = new Paneles();
	
	public Dibujo(){
		String texto2 = "https://d2khazk8e83rdv.cloudfront.net/opendata/enorlment_by_gender_2012-2013_en_0.txt";
		String texto1 = "http://www.metoffice.gov.uk/climate/uk/stationdata/oxforddata.txt";
		
		ventana.pack();
		ventana.setVisible(true);
		
		
		IParsear DatosWeb1 = new Web1(Acceder.conexion(texto1));
		IParsear DatosWeb2 = new Web2(Acceder.conexion(texto2));
		
		this.addObserver(DatosWeb1);
		this.addObserver(DatosWeb2);
		
		
		
		ventana.comboBox.addActionListener( new ActionListener() {
			
			@SuppressWarnings("rawtypes")
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				setChanged();
				JComboBox comboBoxx = new JComboBox();
				comboBoxx = (JComboBox) arg0.getSource();
				notifyObservers( comboBoxx.getSelectedItem() );
				
			}
		});
		
	}

	public void dibujargrafica(ChartPanel grafico){
		
		ventana.cp.add(grafico,BorderLayout.WEST);

	}
	
	public void escribirtexto(String texti){
		JTextArea txtrText = new JTextArea();
		txtrText.setText(texti);
		ventana.cp.add(txtrText,BorderLayout.SOUTH);
	}


	public class Paneles extends JFrame implements ActionListener {
		
		JPanel mypanel;
		final int ALTO = 700;
		final int ANCHO = 1366;
		private JPanel contentPane;
			
		public JComboBox comboBox = new JComboBox();
		public JTextArea txtrText = new JTextArea();
		JScrollPane sp = new JScrollPane(txtrText);
		
		public Container cp;
		
		public Paneles(){
			ArrayList<String[]> datos;
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cp = getContentPane();
			cp.add(sp);
			cp.setLayout(new BorderLayout());
			
			final JTextArea txtrText = new JTextArea();
			//txtrText.setText("TexT");
			
			cp.add(txtrText, BorderLayout.SOUTH);

			comboBox.addItem("http://www.metoffice.gov.uk");
			comboBox.addItem("https://d2khazk8e83rdv.cloudfront.net");
			cp.add(comboBox, BorderLayout.EAST);
						
		}
		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
	}


}
