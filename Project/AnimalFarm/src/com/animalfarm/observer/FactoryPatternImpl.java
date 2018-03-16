package com.animalfarm.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.animalfarm.classes.Animal;
import com.animalfarm.factory.AnimalFactory;
import com.animalfarm.factory.AnimalFactoryCreator;
import com.animalfarm.strategy.Behavior1;
import com.animalfarm.strategy.Behavior2;
import com.animalfarm.strategy.Behavior3;
import com.animalfarm.strategy.FeedingBehavior;

public class FactoryPatternImpl extends Observer {

	static JFrame addAnimalFrame;
	static JTextField nameText;
    static JTextField ageText;
    static JComboBox<String> typeText;
    static JComboBox<String> breedText;
    static JComboBox<String> adoptionText;
    static JComboBox<String> feedingText;
    static JTextField medText;
    static JTextField noteText;
    
	static String name;
    static int age;
    static String type;
    static String breed;
    static String note;
    static String med;
    static boolean adoption;

    static String behavior1 = "omnivore";
    static String behavior2 = "herbivore";
    static String behavior3 = "carnivore";
    
    static int idCount;
    static int x = 10 ;
    static int y = 10;
    static int incr = 190;
    static int animalCount = 0;
	
    @Override
	public void update(List<Animal> list, int runCount) {
		this.list = list;
		this.runCount = runCount;
	}
	

	public void drawAddAnimalForm(JFrame addAnimalFrame) {
		addAnimalFrame = addAnimalFrame;
		addAnimalFrame.setTitle("[RUNCOUNT "+runCount+"] Add New Animal Using Factory Design Pattern");

		addAnimalFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Setting the width and height of frame
        addAnimalFrame.setSize(550, 900);

       
        JPanel panel = new JPanel();    
        // adding panel to frame
        addAnimalFrame.add(panel);
        // calling user defined method for adding components
         // to the panel.
        placeComponents(panel);

        // Setting the frame visibility to true
        addAnimalFrame.setVisible(true);
		
	}
	
    private void placeComponents(JPanel panel) {
    		

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
	         *  NAME: Creating JLabel
	         */
	        JLabel nameLabel = new JLabel("Name");
	        nameLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
	        panel.add(nameLabel);

	        // Creating text field 
	        nameText = new JTextField(20);
	        nameText.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(nameText);
	        
	        /*
	         *  AGE: Creating JLabel
	         */
	        j = j+1;
	        JLabel ageLabel = new JLabel("Age");
	        ageLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
	        panel.add(ageLabel);

	        // Creating text field 
	        ageText = new JTextField(20);
	        ageText.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(ageText);
	        
	        
	        /*
	         *  TYPE: Creating JLabel
	         */
	        j = j+1;
	        String[] types = new String[] {"Cats", "Birds", "Dogs"};
		       
	        JLabel typeLabel = new JLabel("Type");
	        typeLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
	        panel.add(typeLabel);

	        // Creating text field 
	        typeText = new JComboBox<String>(types);
	        typeText.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(typeText);
	        
	        /*
	         *  BREED: Creating JLabel
	         */
	        j = j+1;
	        String[] breeds = new String[] {"Chicken", "Sparrow", "Poodle", "Dalmation", "None"};
			   
	        JLabel breedLabel = new JLabel("Breed");
	        breedLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
	        panel.add(breedLabel);
	        
	        // Creating text field 
	        breedText = new JComboBox<String>(breeds);
	        breedText.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(breedText);
	        
	        /*
	         *  ADOPTION: Creating JLabel
	         */
	        j = j+1;
	        String[] adotionOptions= new String[] {"Yes", "No"};
	        JLabel adoptionLabel = new JLabel("Ready For Adoption");
	        adoptionLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
	        panel.add(adoptionLabel);

	        // Creating text field 
	        adoptionText = new JComboBox<String>(adotionOptions);
	        adoptionText.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(adoptionText);
	        
	        /*
	         *  Feeding Behavior: Creating JLabel
	         */
	        j = j+1;
	        String[] feeding= new String[] {"Omnivore", "Herbivore", "Carnivore"};
	        JLabel feedingLabel = new JLabel("Feeding Behavior");
	        feedingLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
	        panel.add(feedingLabel);

	        // Creating text field 
	        feedingText = new JComboBox<String>(feeding);
	        feedingText.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(feedingText);
	        
	        /*
	         *  MEDICAL CONDITION: Creating JLabel
	         */
	        j = j+1;
	        JLabel medLabel = new JLabel("Medical Condition");
	        medLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
	        panel.add(medLabel);

	        // Creating text field 
	        medText = new JTextField(20);
	        medText.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(medText);
	        
	        /*
	         *  NOTE: Creating JLabel
	         */
	        j = j+1;
	        JLabel noteLabel = new JLabel("Note");
	        noteLabel.setBounds(labelx1,labely1 + j*labelInc,labelx2,labely3);
	        panel.add(noteLabel);

	        // Creating text field 
	        noteText = new JTextField(20);
	        noteText.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(noteText);
	       
	        // BUTTON
	        j = j+1;
	        // Creating add animal button
	        JButton loginButton = new JButton("Add Animal");
	        loginButton.setBounds(fieldx1,fieldy1+ j*fieldInc,fieldx2,fieldy3);
	        panel.add(loginButton);
	        
	        loginButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
															
					onClickAddNewAnimal();
					
					//addAnimalFrame.dispose();
					
					
					// Clear values
					nameText.setText("");;
					ageText.setText("");
					medText.setText("");
					noteText.setText("");
					
					//drawAnimalCountTable();
				}
			});
	    }
    
    private FeedingBehavior getFeedingBehaviorByText(String beh) {
    	if(beh.toLowerCase().equals(behavior2)) {
    		return new Behavior2();
    	} else if(beh.toLowerCase().equals(behavior3)) {
    		return new Behavior3();
    	}
		return new Behavior1();
    }
    
    private void onClickAddNewAnimal() {
    	 name = nameText.getText().toLowerCase(); 
		 type = typeText.getSelectedItem().toString().toLowerCase();
		 breed = breedText.getSelectedItem().toString().toLowerCase();
		 note = noteText.getText().toLowerCase();
		 med = medText.getText().toLowerCase();
		 
		 if(name.isEmpty() || ageText.getText().toLowerCase().isEmpty() || note.isEmpty() || med.isEmpty()) {
			 JOptionPane.showMessageDialog(addAnimalFrame,
				        " Please fill all the details.");
		 } else {
		 
			 age = Integer.parseInt(ageText.getText().toLowerCase());
			 if(adoptionText.getSelectedItem().toString().toLowerCase().equals("yes")) {
				adoption = true;
			 } else if (adoptionText.getSelectedItem().toString().toLowerCase().equals("no")) {
				adoption = false;
			 } else {
				 JOptionPane.showMessageDialog(addAnimalFrame,
					        " Please respond for adoption in 'yes' or 'no' format.");
			 }
			 
			 /*
			  * USING ANIMAL FACTORY 
			  */
			 AnimalFactory afc = null;
			 Animal newAnimal = null;
			 try {
				 
				 if(type.equals("dogs") || type.equals("cats")) {
				 	 afc = AnimalFactoryCreator.getAnimalFactory("mammal");
				 } else if(type.equals("birds"))  {
					 afc = AnimalFactoryCreator.getAnimalFactory("bird");
				 }
				  newAnimal = afc.getAnimal(++idCount, nameText.getText(), age, typeText.getSelectedItem().toString(), breedText.getSelectedItem().toString(), noteText.getText(), medText.getText(), adoption, x, y+idCount*incr);
			 } catch (UnsupportedOperationException e) {
				 JOptionPane.showMessageDialog(addAnimalFrame, e.getMessage());
			}
			 
			 
			 if(newAnimal != null) {
				 newAnimal.setFeedingBehavior(getFeedingBehaviorByText(feedingText.getSelectedItem().toString()));
				 list.add(newAnimal);
			 }
			 idCount = list.size();
			 
			 JOptionPane.showMessageDialog(null, 
                     "Animal added successfully..", "WOW",
                     JOptionPane.INFORMATION_MESSAGE);
		 }
		 
    }

	
}