package com.animalfarm.classes;
import java.awt.Graphics;

import com.animalfarm.main.ImagePanel;
import com.animalfarm.strategy.FeedingBehavior;

public interface Animal {

	void draw(Graphics g, ImagePanel imagePanel);

	String getName();
	
	void setXY(int x, int y);
	
	void setFeedingBehavior(FeedingBehavior fb);
	
	FeedingBehavior getFeedingBehavior();
}
