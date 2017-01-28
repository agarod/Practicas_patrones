package ejemplo.ull.es;

public class InstitutoEducativo {
	private static InstitutoEducativo instance;
	private String nombreInstituto;
	private InstitutoEducativo(){
		
	}
	
	public static InstitutoEducativo getInstance(){
		if (instance == null) {
			instance = new InstitutoEducativo();
		}
		return instance;
	}
	
	public String getNombreInstituto(){
		return nombreInstituto;
	}
	
	public void setNombreInstituto(String nombreINstituto){
		this.nombreInstituto = nombreInstituto;
	}
	
}
