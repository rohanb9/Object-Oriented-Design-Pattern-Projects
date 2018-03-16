package com.animalfarm.decorator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Timer;

import com.animalfarm.classes.Animal;
import com.animalfarm.main.ImagePanel;
import com.animalfarm.strategy.FeedingBehavior;

public class BackgroundDecorator extends AnimalDecorator {

	private int xval;
	private int yval;
	private boolean blink = false;
	
	
	public BackgroundDecorator(Animal animal) {
		super(animal);
	}


	@Override
	public void draw(Graphics g, ImagePanel imagePanel) {
		super.draw(g, imagePanel);
		System.out.println("Background blink");
		
		
		Timer timer = new Timer(550, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blink = !blink;
                if (blink) {
                	imagePanel.setBackground(Color.orange);
                } else {

                	imagePanel.setBackground(Color.GRAY);
                }
                imagePanel.setOpaque(blink);
                //repaint();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
	}

	public int getXval() {
		return xval;
	}

	public void setXval(int xval) {
		this.xval = xval;
	}

	public int getYval() {
		return yval;
	}

	public void setYval(int yval) {
		this.yval = yval;
	}
		
	@Override
	public void setXY(int x, int y) {
		this.setXval(x);
		this.setYval(y);
	}

}
