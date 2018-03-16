package com.animalfarm.factory;

import com.animalfarm.classes.Animal;

public abstract class AnimalFactory {
            
	abstract public Animal getAnimal(int id, String name, int age, String type, String subType, String notes,
			String medicalCondition, boolean readyForAdoption, int xval, int yval) ;

}
