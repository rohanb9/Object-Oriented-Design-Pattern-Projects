package com.animalfarm.decorator;
import java.awt.Graphics;

import com.animalfarm.classes.Animal;
import com.animalfarm.main.ImagePanel;
import com.animalfarm.strategy.FeedingBehavior;

public abstract class AnimalDecorator implements Animal {
	protected Animal animal;
	
	AnimalDecorator(Animal animal) {
		this.animal = animal;
	}
	
	public void draw(Graphics g, ImagePanel ip){
		animal.draw(g, ip);
	}	
	

	@Override
	public void setFeedingBehavior(FeedingBehavior fb) {
		 throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public String getName() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public FeedingBehavior getFeedingBehavior() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
