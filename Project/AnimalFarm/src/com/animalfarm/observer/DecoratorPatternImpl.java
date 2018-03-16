package com.animalfarm.observer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.animalfarm.classes.Animal;
import com.animalfarm.classes.Cat;
import com.animalfarm.classes.Chicken;
import com.animalfarm.classes.Dalmation;
import com.animalfarm.classes.Poodle;
import com.animalfarm.classes.Sparrow;
import com.animalfarm.decorator.BackgroundDecorator;
import com.animalfarm.decorator.BlinkTextDecorator;
import com.animalfarm.decorator.BorderDecorator;
import com.animalfarm.main.ImagePanel;

public class DecoratorPatternImpl extends Observer {
	
    static JCheckBox checkbox1;
    static JCheckBox checkbox2;
    static JCheckBox checkbox3;
    
	static JFrame animalDecorationFrame;
	static JFrame showAnimalFrame;
	

    static JComboBox<String> namesText;

	@Override
	public void update(List<Animal> list, int runCount) {
		this.list = list;
		this.runCount = runCount;
	}
	
    public void showAnimalDecorationForm(JFrame animalDecorationFrame) {

    	animalDecorationFrame.setTitle("[RUNCOUNT "+runCount+"] Animal Details And Decorations");

		animalDecorationFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension minDim = new Dimension(600,1000);
        animalDecorationFrame.setMinimumSize(minDim);

        
        JPanel panel = new JPanel();    
        // adding panel to frame
        animalDecorationFrame.add(panel);
        // calling user defined method for adding components
         // to the panel.
        placeDecoratorComponents(panel);
        animalDecorationFrame.setVisible(true);
	}
    
    private void placeDecoratorComponents(JPanel panel) {
    	Cat a1;
		Chicken a2;
		Sparrow a3;
		Poodle a4;
		Dalmation a5;
			
    	 panel.setLayout(null);
        int j = 0;
        int labelx1 = 10;
        int labely1 = 20;
        int labelx2 = 150;
        int labely3 = 25;
        int labelInc = 30;
        
        int fieldx1 = 200;
        int fieldy1 = 20;
        int fieldx2 = 165;
        int fieldy3 = 25;
        int fieldInc = 30;
        
        /*
         *  Name: Creating JLabel
         */
        j = j+1;
        String[] names = new String[list.size()];
        int x = 0;
        for(Animal a: list) {
        	names[x] = a.getName();
        	x++;
        }
		   
        JLabel namesLabel = new JLabel("Animal Name");
        namesLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
        panel.add(namesLabel);
        
        // Creating text field 
        namesText = new JComboBox<String>(names);
        namesText.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
        panel.add(namesText);
        
        /*
         *  Name: Creating JLabel
         */
        j = j+1;
        
        JLabel decLabel = new JLabel("Decoration");
        decLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
        panel.add(decLabel);
        
        // Create checkbox with different constructors
		checkbox1 = new JCheckBox("Blink Text", true);
		checkbox1.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	    panel.add(checkbox1);
	    
	    j = j+1;
		checkbox2 = new JCheckBox("Blink Border");
		checkbox2.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	    panel.add(checkbox2);
	    
	    j = j+1;
		checkbox3 = new JCheckBox("Blink Background");
		checkbox3.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	    panel.add(checkbox3);
					
		// Add the checkbox into the panels 
		panel.add(checkbox1);
		panel.add(checkbox2);
		panel.add(checkbox3);
		
		 // BUTTON
        j = j+1;
        // Creating add animal button
        JButton showButton = new JButton("Show");
        showButton.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
        panel.add(showButton);
        
        showButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{			
				
				
				String animalName = namesText.getSelectedItem().toString();
				Animal selectedAnimal = null;
				for(Animal a: list) {
		        	if(a.getName().equals(animalName)) {
		        		selectedAnimal = a;
		        	}
		        }
				
				/*
				 * DECORATE BASED ON USER DEMAND 
				 */
				selectedAnimal.setXY(100, 150);
				showAnimalFrame = new JFrame("Animal Farm Decorations");
				Dimension minDim = new Dimension(900,500);
				showAnimalFrame.setMinimumSize(minDim);
			        
				showAnimalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			    if(checkbox1.isSelected()) {
			    	selectedAnimal = new BlinkTextDecorator(selectedAnimal);
			    }
			    
			    if(checkbox2.isSelected()) {
			    	selectedAnimal = new BorderDecorator(selectedAnimal);
			    }
			    
			    if(checkbox3.isSelected()) {
			    	selectedAnimal = new BackgroundDecorator(selectedAnimal);
			    }
				
			    showAnimalFrame.add(new ImagePanel(selectedAnimal));
			    showAnimalFrame.setVisible(true);
			    
			    showAnimalFrame.addWindowListener(new java.awt.event.WindowAdapter() {
				    @Override
				    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				    	showAnimalFrame.dispose();
				    		
				        	
				    }
			    });
			}
		});
	        
    }

	
}