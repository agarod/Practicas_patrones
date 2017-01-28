package Sujeto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import Modelo.Url1;

public class ClaseObservador extends Observable{
	
	
	     IParsear parsea;
	     Url1 url = new Url1();
	     private ArrayList<Observable> observers;
	     
	     
		 public ClaseObservador(IParsear parsea, Url1 url) {
		 this.parsea = parsea;
		 this.url = url;
		 this.observers = new ArrayList <Observable>();
		 
		 System.out.println("sujeto: " + parsea + "" + url);
		 }
			
			public ClaseObservador(){
				
			}
				
			public void setParsea( IParsear parsea) {
				this.parsea = parsea;
				setChanged();
			    notifyObservers();
			}

			public void setUrl( Url1 url) {
				this.url = url;
				setChanged();
			    notifyObservers();
			}
			public IParsear 
			getParsea() {
				return (parsea);
			}
			
			public Url1 getUrl(){
				return (url);
			}

    public void addObserver (Observable observer){
    	observers.add(observer);
    }
    	public void removeObserver(Observable observer){
    		
    	}
    	
    	private void notificar(){
    	for (Iterator<Observable> it = observers.iterator(); it.hasNext();){
    		Observable iobserver = it.next();
    		iobserver.notify();
    	}
    	}

    }

		


