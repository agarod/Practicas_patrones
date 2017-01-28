package Sujeto;

/*Semanalmente Estados Unidos informaron de resúmenes de la temperatura en grados Fahrenheit generada
 * desde el METAR GTS (por hora) y sinóptica observaciones (cada 6 horas) para las ciudades seleccionadas
 * con base en el Semanario Tiempo y lista de emisoras Boletín de Cultivos
*/


import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatosTemperatura  implements IParsear{
	private IParsear Parse;

	public ArrayList<ArrayList<Double>> datos (ArrayList<String> data) {

		ArrayList<ArrayList<Double>> matriz = new ArrayList<ArrayList<Double>>();
		StringTokenizer content, content2, content3;

		String valor, valor2;

		int columna;



		for (int i=0; i<10; i++) {
			matriz.add(new ArrayList<Double>());	
		}


		for (int i=10; i<data.size(); i++) {


			content = new StringTokenizer(data.get(i));
			System.out.println("CONTAR TOKENS !-->"+content.countTokens());
			if (content.countTokens() == 3){
				System.out.println("That's all Folks!!!");
			}
			else{
			int tam = content.countTokens();
			columna = 0;

			while(content.hasMoreElements()) {
			
				
				for( int j=0; j<=content.countTokens(); j++){
					valor = content.nextToken();

					for (int k=0; k<5; k++){
						valor = content.nextToken();
						Pattern p = Pattern.compile("[^A-Z'./-]");
						Matcher m = p.matcher(valor);
						if (m.find()){
							System.out.println("entro"+valor);
							//valor = content.nextToken();
							matriz.get(columna).add(Double.parseDouble(valor));
							break;
						}
					}
					for (int n=0; n<(content.countTokens())-3; n++){
						valor = content.nextToken();
						System.out.println("VALOR->"+ valor);
						matriz.get(columna).add(Double.parseDouble(valor));
					}
				}
				columna ++;

			}
			}
		}
		return matriz;

	}

	public ArrayList<String> Encabezado (ArrayList<String> data) {
		
		ArrayList<String> cabecera = new ArrayList<String>();
		StringTokenizer content;		

		content = new StringTokenizer(data.get(5));

		while(content.hasMoreElements()) {							
			cabecera.add(content.nextToken());			
		}
		
		return cabecera;
		
	}

}
