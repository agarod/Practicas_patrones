
public class Principal {
	public static void main(String args[]) {
		
		
		Internet ImprimirOnline = new Internet();
		
		System.out.println("BANKIA, tu banco de confianza");
		System.out.println("");
		Prestamo prestamoPersonal = new Prestamo("Prestamo personal", 12.5f , "Bankia");
		System.out.println("Banco->"+prestamoPersonal.getBank());
		System.out.println("Tasa de interes->"+prestamoPersonal.getInterest());

		prestamoPersonal.registerObserver(ImprimirOnline);
		prestamoPersonal.setInterest(0.1f);
		
		System.out.println("Tasa de interes->"+prestamoPersonal.getInterest());

	}
}
