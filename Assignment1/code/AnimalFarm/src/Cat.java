import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Cat extends Mammal {

	private int xval;
	private int yval;
	
	private static int count;
	
	public Cat(int id, String name, int age, String type, String subType, String notes, String medicalCondition,
			boolean readyForAdoption, int xval, int yval, int count) {
		super(id, name, age, type, subType, notes, medicalCondition, readyForAdoption);
		this.xval = xval;
		this.yval = yval;
		Cat.count = count;
	}

	@Override
	public String toString() {
		
		return super.toString() + "\n count= " + count ;
	}

	@Override
	public void draw(Graphics g, ImagePanel imagePanel) {
		BufferedImage image = null;
		try {                
	          image = ImageIO.read(new File("images/cat.jpg"));
	       } catch (IOException ex) {
	            System.out.println("ERROR: Image access error.");
	       }
		g.drawImage(image, getXval(), getYval(), imagePanel);
		int i = 0;
		for (String line : toString().split("\n")) {
	        g.drawString(line, getXval() + 300, getYval() + i*20);
	        i++;
		}
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

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Cat.count = count;
	}
}
