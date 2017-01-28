package cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observer;

import Modelo.Url1;
import Observador.Graficar;
import Sujeto.IParsear;
import Sujeto.DatosClima;
import Sujeto.DatosTemperatura;

public class main {
	
		public static void main(String[] args) throws Exception {
	
			
	BufferedReader in =new BufferedReader(new InputStreamReader(System.in)); 
	int entrada;
	System.out.print("Elige una opcion\n" ); 
	System.out.print("1.- manipular url de estacion climatica de oxford\n" ); 
	System.out.print("2.- manipular url de temperaturas de estados unidos\n" );  
	entrada=Integer.parseInt(in.readLine());
	
	switch (entrada) {
	
     case 1: 
    	 
    	 String url_web = "http://www.metoffice.gov.uk/climate/uk/stationdata/oxforddata.txt";
    	
			
			Url1 url = new Url1();
			IParsear parseo = new DatosClima();
			Graficar visualizar = new Graficar();
			
								
			ArrayList datos;
			ArrayList<String> cabecera;
			ArrayList<ArrayList<Double>> parse_datos;
						
			// Obtenemos la info de la URL
			datos = url.Web(url_web);
			url.addObserver(visualizar);
			url.Web(url_web);
			
			
			
			// Representamos el contenido
			cabecera = parseo.Encabezado(datos);
			
			// Parseamos el contenido
			parse_datos = parseo.datos(datos);
			
			// Visualizamos el contenido
			visualizar.update(url, parse_datos);
			visualizar.GraficoDibujo(visualizar, cabecera, parse_datos);
			

       break; 
       
     case 2: 
    	 String url2 = "ftp://ftp.cpc.ncep.noaa.gov/htdocs/products/analysis_monitoring/cdus/prcp_temp_tables/wctytemp.txt";
    	 
    	 Url1 urls = new Url1();
			IParsear parse = new DatosTemperatura();

			Graficar visualiza = new Graficar();
			
			ArrayList datos1;
			ArrayList<String> cabecera1;
			ArrayList<ArrayList<Double>> parse_datos1;
			
			// Obtenemos la info de la URL
			datos1 = urls.Web(url2);
		
			// Representamos el contenido
			cabecera1 = parse.Encabezado(datos1);
			
			// Parseamos el contenido
			parse_datos1 = parse.datos(datos1);
			
			// Visualizamos el contenido
			visualiza.update(urls, parse);
			visualiza.GraficoDibujo(visualiza, cabecera1, parse_datos1);
        
       	break;
	
     default: System.out.print("\nSeleccion incorrecta" );

			}
		}
	}


