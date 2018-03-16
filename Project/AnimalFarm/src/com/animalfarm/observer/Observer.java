package com.animalfarm.observer;

import java.util.List;

import javax.swing.JFrame;

import com.animalfarm.classes.Animal;

public abstract class Observer {
	   protected List<Animal> list;
	   protected int runCount;

	   public abstract void update(List<Animal> list, int runCount);

}