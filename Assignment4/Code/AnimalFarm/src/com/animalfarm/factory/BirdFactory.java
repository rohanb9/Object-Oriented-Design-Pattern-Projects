package com.animalfarm.factory;

import com.animalfarm.classes.Animal;
import com.animalfarm.classes.Chicken;
import com.animalfarm.classes.Sparrow;

public class BirdFactory extends AnimalFactory{
    
    private static BirdFactory birdFactory = null;

    private BirdFactory() {
        
    }       
    
    @Override 
    public Animal getAnimal(int id, String name, int age, String type, String subType, String notes, String medicalCondition,
			boolean readyForAdoption, int xval, int yval){
        Animal newAnimal = null;
        switch(type.toLowerCase()){            
        	case "birds" : 
				 if(subType.toLowerCase().equals("sparrow")) {
					 newAnimal = new Sparrow(id, name, age, type, subType, notes, medicalCondition, readyForAdoption, xval, yval, Sparrow.getCount() + 1);
				 } else if(subType.toLowerCase().equals("chicken")) {
					 newAnimal = new Chicken(id, name, age, type, subType, notes, medicalCondition, readyForAdoption, xval, yval, Chicken.getCount() + 1);
				 } else {
					 throw new UnsupportedOperationException("Invalid Type or Breed.");
				 }
				 break;
             
        }
        
        return newAnimal;
    }  

    public static synchronized BirdFactory getFactory(){
    	 if(birdFactory == null) {
    		 birdFactory = new BirdFactory();
          }
        return birdFactory;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }    

}
