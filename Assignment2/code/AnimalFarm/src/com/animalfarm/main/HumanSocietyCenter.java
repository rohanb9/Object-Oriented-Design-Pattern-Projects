package com.animalfarm.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.animalfarm.classes.Animal;
import com.animalfarm.classes.Cat;
import com.animalfarm.classes.Chicken;
import com.animalfarm.classes.Dalmation;
import com.animalfarm.classes.Poodle;
import com.animalfarm.classes.Sparrow;
import com.animalfarm.decorator.BackgroundDecorator;
import com.animalfarm.decorator.BlinkTextDecorator;
import com.animalfarm.decorator.BorderDecorator;

public class HumanSocietyCenter {
	static JFrame detailsFrame = new JFrame();
	static JFrame tableFrame;
	static JFrame addAnimalFrame;
	static JFrame animalDecorationFrame;
	
	static List<Animal> list = new ArrayList();
	static int idCount = 1;
	
	static String name;
    static int age;
    static String type;
    static String breed;
    static String note;
    static String med;
    static boolean adoption;
    
    static JTextField nameText;
    static JTextField ageText;
    static JComboBox<String> typeText;
    static JComboBox<String> breedText;
    static JComboBox<String> adoptionText;
    static JTextField medText;
    static JTextField noteText;
    
    static JComboBox<String> namesText;
    static JCheckBox checkbox1;
    static JCheckBox checkbox2;
    static JCheckBox checkbox3;
    
    
    static int x = 10 ;
    static int y = 10;
    static int incr = 170;
    static int animalCount = 0;

	public void start() {
		/*
		 * Initialize the basic animal list. 
		 */
		initAnimalList();
		
		/*
		 * Show animal details.  
		 */
		showAnimalDetails();
		
		/*
		 * Draw animal count table.
		 */
		drawAnimalCountTable();
    
	}
	
	private void showAnimalDetails() {
		detailsFrame.setTitle("Animal Details"); 
		detailsFrame.add(new ImagePanel(list));
        Dimension minDim = new Dimension(600,1000);
        detailsFrame.setMinimumSize(minDim);
        detailsFrame.setVisible(true);
	}
	
		
	private void initAnimalList() {
		
		Cat a1 = new Cat(idCount, " Miao ", 9, "Cats", "Cats", " Very Cute. ","healthy", true, x, y+animalCount*incr, Cat.getCount() + 1);
		animalCount = animalCount +1;
		Chicken a2 = new Chicken(++idCount, " Angry Bird ", 10, "Birds", "Chicken", " No note to update. ", "Moderate", false, x, y+animalCount*incr);
		animalCount = animalCount +1;
		Sparrow a3 = new Sparrow(++idCount, " Jack ", 12, "Birds", "Sparrow", "very small.", "Good", true, x, y+animalCount*incr, Sparrow.getCount() + 1);
		animalCount = animalCount +1;
		Poodle a4 = new Poodle(++idCount, " Mia ", 9, "Dogs", "Poodle", " Very Cute. ","healthy", true, x, y+animalCount*incr, Poodle.getCount() + 1);
		animalCount = animalCount +1;
		Dalmation a5 = new Dalmation(++idCount, " Vaghya ", 10, "Dogs", "Dalmation", " No note to update. ", "Moderate", false, x, y+animalCount*incr, Dalmation.getCount() + 1);
		animalCount = animalCount +1;
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		
	}
	
	private static void drawAnimalCountTable() {
		tableFrame = new JFrame();
		String[][] arr = { { "Dogs", "Poodle", Integer.toString(Poodle.getCount()) }, { "Dogs", "Dalmatian", Integer.toString(Dalmation.getCount()) },
				{ "Cats", "Cats", Integer.toString(Cat.getCount()) }, { "Birds", "Chicken", Integer.toString(Chicken.getCount()) },
				{ "Birds", "Sparrow", Integer.toString(Sparrow.getCount())} };
		//System.out.println(" -----  " + Chicken.getCount());
   
		String column[]={"Type","Breed","Count"};         
		JTable jt=new JTable(arr,column);    
		
		
		tableFrame.setLayout(new BorderLayout());
		
		
		JPanel btnPnl = new JPanel(new BorderLayout());   
		JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));	
		JButton addNewAnimalBtn = new JButton("Add New Animal");	
		addNewAnimalBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tableFrame.dispose();
				drawAddAnimalForm();
			}
		});
		bottombtnPnl.add(addNewAnimalBtn);
		btnPnl.add(bottombtnPnl, BorderLayout.CENTER);
		
		

		JButton decorateAnimalBtn = new JButton("Animal details and decoration");	
		decorateAnimalBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tableFrame.dispose();
				showAnimalDecorationForm();
			}
		});
		bottombtnPnl.add(decorateAnimalBtn);
		btnPnl.add(bottombtnPnl, BorderLayout.CENTER);
		
		
		
		jt.getTableHeader().setReorderingAllowed(false);
		
		tableFrame.add(jt.getTableHeader(), BorderLayout.NORTH);
		tableFrame.add(jt, BorderLayout.CENTER);
		tableFrame.add(btnPnl, BorderLayout.SOUTH);
		
		
		tableFrame.setTitle("Animal Count Table"); 
		tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tableFrame.pack();
		Dimension min = new Dimension(500,500);
		tableFrame.setMinimumSize(min);
		tableFrame.setVisible(true);
	}
		
	private static void drawAddAnimalForm() {
		addAnimalFrame = new JFrame();
        addAnimalFrame.setTitle("Add New Animal"); 
        // Setting the width and height of frame
        addAnimalFrame.setSize(550, 900);
        addAnimalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        JPanel panel = new JPanel();    
        // adding panel to frame
        addAnimalFrame.add(panel);
        // calling user defined method for adding components
         // to the panel.
        placeComponents(panel);

        // Setting the frame visibility to true
        addAnimalFrame.setVisible(true);
		
	}
	
	
	
    private static void placeComponents(JPanel panel) {
    		

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
					
					addAnimalFrame.dispose();
					
					// Clear values
					nameText.setText("");;
					ageText.setText("");
					medText.setText("");
					noteText.setText("");
					
					drawAnimalCountTable();
				}
			});
	    }
    
    
    static void onClickAddNewAnimal() {
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
			 Animal newAnimal = null;
			 switch(type) {
				 case "dogs" : 
					 if(breed.equals("dalmation")) {
						 newAnimal = new Dalmation(++idCount, nameText.getText(), age, typeText.getSelectedItem().toString(), breedText.getSelectedItem().toString(), noteText.getText(), medText.getText(), adoption, x, y+animalCount*incr, Dalmation.getCount() + 1);
					 } else if(breed.equals("poodle")) {
						 newAnimal = new Poodle(++idCount, nameText.getText(), age, typeText.getSelectedItem().toString(), breedText.getSelectedItem().toString(), noteText.getText(), medText.getText(), adoption, x, y+animalCount*incr, Poodle.getCount() + 1);
					 } else {
						 JOptionPane.showMessageDialog(addAnimalFrame,
							        " Invalid type or breed.");
					 }
					 break;
				 case "cats" : 
					 if(breed.equals("none")) {
						 newAnimal = new Cat(++idCount, nameText.getText(), age, typeText.getSelectedItem().toString(), breedText.getSelectedItem().toString(), noteText.getText(), medText.getText(), adoption, x, y+animalCount*incr, Cat.getCount() + 1);
					 } else {
						 JOptionPane.showMessageDialog(addAnimalFrame,
							        " Invalid type or breed.");
					 }
					 break;
				 case "birds" : 
					 if(breed.equals("sparrow")) {
						 newAnimal = new Sparrow(++idCount, nameText.getText(), age, typeText.getSelectedItem().toString(), breedText.getSelectedItem().toString(), noteText.getText(), medText.getText(), adoption, x, y+animalCount*incr, Sparrow.getCount() + 1);
					 } else if(breed.equals("chicken")) {
						 newAnimal = new Chicken(++idCount, nameText.getText(), age, typeText.getSelectedItem().toString(), breedText.getSelectedItem().toString(), noteText.getText(), medText.getText(), adoption, x, y+animalCount*incr);
					 } else {
						 JOptionPane.showMessageDialog(addAnimalFrame,
							        " Invalid type or breed.");
					 }
					 break;

			 }
			 animalCount = animalCount +1;
			 if(newAnimal != null) {
				 list.add(newAnimal);
			 }
		 }
		 
    }
    
    private static void showAnimalDecorationForm() {
    	
    	animalDecorationFrame = new JFrame("Animal Details And Decorations");
        Dimension minDim = new Dimension(600,1000);
        animalDecorationFrame.setMinimumSize(minDim);
        
        animalDecorationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel panel = new JPanel();    
        // adding panel to frame
        animalDecorationFrame.add(panel);
        // calling user defined method for adding components
         // to the panel.
        placeDecoratorComponents(panel);
        animalDecorationFrame.setVisible(true);
	}
    
    private static void placeDecoratorComponents(JPanel panel) {
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
					animalDecorationFrame.dispose();
					
					String animalName = namesText.getSelectedItem().toString();
					Animal selectedAnimal = null;
					for(Animal a: list) {
			        	if(a.getName().equals(animalName)) {
			        		selectedAnimal = a;
			        	}
			        }
					
					selectedAnimal.setXY(100, 150);
					animalDecorationFrame = new JFrame("Animal Farm Decorations");
					Dimension minDim = new Dimension(900,500);
				    animalDecorationFrame.setMinimumSize(minDim);
				        
				    animalDecorationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				    if(checkbox1.isSelected()) {
				    	selectedAnimal = new BlinkTextDecorator(selectedAnimal);
				    }
				    
				    if(checkbox2.isSelected()) {
				    	selectedAnimal = new BorderDecorator(selectedAnimal);
				    }
				    
				    if(checkbox3.isSelected()) {
				    	selectedAnimal = new BackgroundDecorator(selectedAnimal);
				    }
					
					animalDecorationFrame.add(new ImagePanel(selectedAnimal));
					animalDecorationFrame.setVisible(true);
				}
			});
	        
    }
    
    
}
