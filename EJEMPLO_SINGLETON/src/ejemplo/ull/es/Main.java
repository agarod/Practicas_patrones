package ejemplo.ull.es;

public class Main {
	public static void main(String[] args){
		InstitutoEducativo ie = InstitutoEducativo.getInstance();
		ie.setNombreInstituto("Educacion S.A");
		System.out.println("1: "+ie.getNombreInstituto());
		//InstitutoEducativo instituto2 = new InstitutoEducativo(); // Asi no deberia funcionar
	}
}
