package com.animalfarm.observer;

import java.util.ArrayList;
import java.util.List;

import com.animalfarm.classes.Animal;

public class ShareSubject {
		
	   private List<Observer> observers = new ArrayList<Observer>();
	   private List<Animal> animalList;
	   private int runCount;
	   

	   public void setAnimalListWithRunCount(List<Animal> list, int runCount) {
	      this.animalList = list;
	      this.runCount = runCount;
	      notifyAllObservers();
	   }

	   public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update(animalList, this.runCount);
	      }
	   } 	

}
