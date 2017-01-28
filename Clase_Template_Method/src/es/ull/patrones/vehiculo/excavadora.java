package es.ull.patrones.vehiculo;

public abstract class excavadora {
	 public void desplazar()
	    {
	        acelerar();
	        frenar();
	        girar_cabina();
	        brazo();
	        
	    }
	 
	    private void acelerar()
	    {
	        System.out.println("Acelerando...");
	    }
	 
	    private void frenar()
	    {
	        System.out.println("Frenando...");
	    }
	    
	    private void girar_cabina()
	    {
	    	System.out.println("Gira la cabina...");
	    }
	 
	    protected abstract void brazo();
}
