package com.animalfarm.factory;


public class AnimalFactoryCreator {   

    private static AnimalFactory animalFactory;
    
    private AnimalFactoryCreator() {}
    
       
    public static synchronized AnimalFactory getAnimalFactory(String animalType){
       if(animalType.equalsIgnoreCase("mammal")){
            return MammalFactory.getFactory();
        }
        else if(animalType.equalsIgnoreCase("bird")){
            return BirdFactory.getFactory();
        }
        else{
            throw new InstantiationError();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
}
