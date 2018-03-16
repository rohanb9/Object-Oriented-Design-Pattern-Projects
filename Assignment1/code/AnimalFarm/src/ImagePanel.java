
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	List<Animal> list;
    private BufferedImage image;

    public ImagePanel(List<Animal> list) {
    	this.list = list; 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for(Animal l: list) {
        	l.draw(g, this);
        }
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters      
        
        g.drawImage(image, 0, 40, this);
    }

}