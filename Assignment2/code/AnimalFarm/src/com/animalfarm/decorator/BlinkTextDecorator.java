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

public class BlinkTextDecorator extends AnimalDecorator {

	private int xval;
	private int yval;
	private boolean blink = false;
	
	
	public BlinkTextDecorator(Animal animal) {
		super(animal);
	}


	@Override
	public void draw(Graphics g, ImagePanel imagePanel) {
		super.draw(g, imagePanel);
		System.out.println("Blink Text");
		
		
		Timer timer = new Timer(750, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blink = !blink;
                if (blink) {
                	imagePanel.setForeground(Color.RED);
                } else {
                	imagePanel.setForeground(Color.BLACK);
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
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setXY(int x, int y) {
		this.setXval(x);
		this.setYval(y);
	}
}
