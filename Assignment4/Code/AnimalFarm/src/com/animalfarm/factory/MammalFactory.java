package com.animalfarm.factory;

import com.animalfarm.classes.Animal;
import com.animalfarm.classes.Cat;
import com.animalfarm.classes.Dalmation;
import com.animalfarm.classes.Poodle;

public class MammalFactory extends AnimalFactory {
    
    private static MammalFactory mammalFactory = null;

    private MammalFactory() {
        
    }       
    
    @Override 
    public Animal getAnimal(int id, String name, int age, String type, String subType, String notes, String medicalCondition,
			boolean readyForAdoption, int xval, int yval){
        Animal newAnimal = null;
        switch(type.toLowerCase()){
            
	        case "dogs" : 
				 if(subType.toLowerCase().equals("dalmation")) {
					 newAnimal = new Dalmation(id, name, age, type, subType, notes, medicalCondition, readyForAdoption, xval, yval, Dalmation.getCount() + 1);
				 } else if(subType.toLowerCase().equals("poodle")) {
					 newAnimal = new Poodle(id, name, age, type, subType, notes, medicalCondition, readyForAdoption, xval, yval, Poodle.getCount() + 1);
				 } else {
					 throw new UnsupportedOperationException("Invalid Type or Breed.");
				 }
				 break;
				 
			 case "cats" : 
				 if(subType.toLowerCase().equals("none")) {
					 newAnimal = new Cat(id, name, age, type, subType, notes, medicalCondition, readyForAdoption, xval, yval, Cat.getCount() + 1);
				 } else {
					 throw new UnsupportedOperationException("Invalid Type or Breed.");
				 }
				 break;
             
        }
        
        return newAnimal;
    }  
    
    public static synchronized MammalFactory getFactory(){
       if(mammalFactory == null) {
    		mammalFactory = new MammalFactory();
       }
       return mammalFactory;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }


}
