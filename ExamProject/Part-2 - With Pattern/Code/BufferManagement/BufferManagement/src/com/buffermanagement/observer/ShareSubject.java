package com.buffermanagement.observer;

import java.util.ArrayList;
import java.util.List;

public class ShareSubject {
		
	   private int startVal;
	   private List<Observer> observers = new ArrayList<Observer>();
	   
	   public void setStartVal(int startVal) {
	      this.startVal = startVal;
	      
	      // Updation in all
	      notifyAllObservers();
	   }
	
	   public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update(startVal);
	      }
	   } 	

}
