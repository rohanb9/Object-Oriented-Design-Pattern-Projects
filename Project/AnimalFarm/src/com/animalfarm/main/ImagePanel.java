package com.animalfarm.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.animalfarm.classes.Animal;

public class ImagePanel extends JPanel{

	List<Animal> list;

    public ImagePanel(List<Animal> list) {
    	this.list = list; 
    }
    
    public ImagePanel(Animal animal) {
    	list = new ArrayList<Animal>();
    	list.add(animal); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for(Animal l: list) {
        	l.draw(g, this);
        }
    }

}