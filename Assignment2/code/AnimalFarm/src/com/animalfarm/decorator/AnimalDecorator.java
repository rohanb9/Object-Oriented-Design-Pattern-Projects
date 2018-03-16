package com.animalfarm.decorator;
import java.awt.Graphics;

import com.animalfarm.classes.Animal;
import com.animalfarm.main.ImagePanel;

public abstract class AnimalDecorator implements Animal {
	protected Animal animal;
	
	AnimalDecorator(Animal animal) {
		this.animal = animal;
	}
	
	public void draw(Graphics g, ImagePanel ip){
		animal.draw(g, ip);
	}	
	
}
