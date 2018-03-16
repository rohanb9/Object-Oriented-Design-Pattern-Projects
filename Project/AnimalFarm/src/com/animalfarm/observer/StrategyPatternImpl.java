package com.animalfarm.observer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.animalfarm.classes.Animal;
import com.animalfarm.main.ImagePanel;
import com.animalfarm.strategy.Behavior1;
import com.animalfarm.strategy.Behavior2;
import com.animalfarm.strategy.Behavior3;
import com.animalfarm.strategy.FeedingBehavior;

public class StrategyPatternImpl extends Observer {
	

	static JFrame changeAnimalFeedingBehaviorFrame;
	static JFrame showAnimalFrame;

    static JComboBox<String> feedingText1;
    static JComboBox<String> namesText1;
    
    static String behavior1 = "omnivore";
    static String behavior2 = "herbivore";
    static String behavior3 = "carnivore";

    @Override
	public void update(List<Animal> list, int runCount) {
		this.list = list;
		this.runCount = runCount;
	}

	 public void showChangeFeedingBehaviorForm(JFrame changeAnimalFeedingBehaviorFrame) {

		 	changeAnimalFeedingBehaviorFrame.setTitle("[RUNCOUNT "+runCount+"] Change animal feeding behavior");
		 	changeAnimalFeedingBehaviorFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        Dimension minDim = new Dimension(600,1000);
	        changeAnimalFeedingBehaviorFrame.setMinimumSize(minDim);
	          
	        JPanel panel = new JPanel();    
	        // adding panel to frame
	        changeAnimalFeedingBehaviorFrame.add(panel);
	        // calling user defined method for adding components
	         // to the panel.
	        placeStrategyComponents(panel);
	        changeAnimalFeedingBehaviorFrame.setVisible(true);
	}
	 
	 private FeedingBehavior getFeedingBehaviorByText(String beh) {
	    	if(beh.toLowerCase().equals(behavior2)) {
	    		return new Behavior2();
	    	} else if(beh.toLowerCase().equals(behavior3)) {
	    		return new Behavior3();
	    	}
			return new Behavior1();
	    }
	 
	private void placeStrategyComponents(JPanel panel) {
				
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
	        namesText1 = new JComboBox<String>(names);
	        namesText1.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(namesText1);
	        
	        /*
	         *  Feeding Behavior: Creating JLabel
	         */
	        j = j+1;
	        String[] feeding= new String[] {"Omnivore", "Herbivore", "Carnivore"};
	        JLabel feedingLabel = new JLabel("Feeding Behavior");
	        feedingLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
	        panel.add(feedingLabel);

	        // Creating text field 
	        feedingText1 = new JComboBox<String>(feeding);
	        feedingText1.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(feedingText1);
			
			 // BUTTON
	        j = j+1;
	        // Creating add animal button
	        JButton updateButton = new JButton("Update And Show");
	        updateButton.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(updateButton);
	        
	        updateButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{			
					
					
					String animalName = namesText1.getSelectedItem().toString();
					Animal selectedAnimal = null;
					for(Animal a: list) {
			        	if(a.getName().equals(animalName)) {
			        		selectedAnimal = a;
			        		
			        	}
			        }
					/*
					 * Update Strategy based on user selection.
					 */
					selectedAnimal.setFeedingBehavior(getFeedingBehaviorByText(feedingText1.getSelectedItem().toString()));
					
					
					selectedAnimal.setXY(100, 150);
					showAnimalFrame = new JFrame("Animal Details");
					Dimension minDim = new Dimension(900,500);
					showAnimalFrame.setMinimumSize(minDim);
				        
					showAnimalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
					
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