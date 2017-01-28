import java.util.ArrayList;


public class Prestamo implements Subject {
   
	private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String type;
    private float interest;
    private String bank;

    
    public Prestamo (String type,float interest,String bank){
		   this.type = type;
           this.interest = interest;
           this.bank = bank;
    }
    public float getInterest(){
    	return interest;
    }
    public void setInterest(float interest){
    	this.interest = interest;
    	notifyObservers();
    }
    public String getBank(){
    	return this.bank;
    }
    public String gettype(){
    	return this.type;
    }

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		  observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		 observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Observer ob : observers) {
			System.out.println("Notificando a los observadores un cambio en el interes del prestamo");
			ob.update(this.interest);
		}

	}

}
