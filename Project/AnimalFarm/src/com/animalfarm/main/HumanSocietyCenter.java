package com.animalfarm.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.animalfarm.classes.Animal;
import com.animalfarm.classes.Cat;
import com.animalfarm.classes.Chicken;
import com.animalfarm.classes.Dalmation;
import com.animalfarm.classes.Poodle;
import com.animalfarm.classes.Sparrow;
import com.animalfarm.observer.DecoratorPatternImpl;
import com.animalfarm.observer.FactoryPatternImpl;
import com.animalfarm.observer.ShareSubject;
import com.animalfarm.observer.StrategyPatternImpl;
import com.animalfarm.strategy.Behavior1;
import com.animalfarm.strategy.FeedingBehavior;

public class HumanSocietyCenter {
	static JFrame detailsFrame = new JFrame();

	static JFrame tableFrame;
	static JFrame addAnimalFrame;
	static JFrame animalDecorationFrame;
	static JFrame changeAnimalFeedingBehaviorFrame;
	

    List<Animal> list = new ArrayList();
	static List<Animal> listFactory = new ArrayList();
	static int idCount = 1;
    
    static int x = 10 ;
    static int y = 10;
    static int incr = 190;
    static int animalCount = 0;
    
    DecoratorPatternImpl dimpl;
	FactoryPatternImpl fimpl;
	StrategyPatternImpl simpl;
	ShareSubject sb ;
    int runCount = 0;

	public void start() {
		/*
		 * Initialize the basic animal list. 
		 */
		initAnimalList();
		
		FeedingBehavior fb = list.get(0).getFeedingBehavior();
		System.out.println("FEEDING :: " + fb.getFeedingBehavior());

		FeedingBehavior fb1 = list.get(1).getFeedingBehavior();
		System.out.println("FEEDING :: " + fb1.getFeedingBehavior());
		
		
		/*
		 * Attach observers.
		 */
		
		 dimpl = new DecoratorPatternImpl();
		 fimpl = new FactoryPatternImpl();
		 simpl = new StrategyPatternImpl();
		
		sb = new ShareSubject();
		sb.attach(dimpl);
		sb.attach(fimpl);
		sb.attach(simpl);
	
		
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
		detailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		detailsFrame.add(new ImagePanel(list));
        Dimension minDim = new Dimension(600,1000);
        detailsFrame.setMinimumSize(minDim);
        detailsFrame.setVisible(true);
	}
	
		
	private void initAnimalList() {
		
		Cat a1 = new Cat(idCount, " Miao ", 9, "Cats", "Cats", " Very Cute. ","healthy", true, x, y+animalCount*incr, Cat.getCount() + 1);
		animalCount = animalCount +1;
		Chicken a2 = new Chicken(++idCount, " Angry Bird ", 10, "Birds", "Chicken", " No note to update. ", "Moderate", false, x, y+animalCount*incr, Chicken.getCount() + 1);
		animalCount = animalCount +1;
		Sparrow a3 = new Sparrow(++idCount, " Jack ", 12, "Birds", "Sparrow", "very small.", "Good", true, x, y+animalCount*incr, Sparrow.getCount() + 1);
		animalCount = animalCount +1;
		Poodle a4 = new Poodle(++idCount, " Mia ", 9, "Dogs", "Poodle", " Very Cute. ","healthy", true, x, y+animalCount*incr, Poodle.getCount() + 1);
		animalCount = animalCount +1;
		Dalmation a5 = new Dalmation(++idCount, " Vaghya ", 10, "Dogs", "Dalmation", " No note to update. ", "Moderate", false, x, y+animalCount*incr, Dalmation.getCount() + 1);
		animalCount = animalCount +1;
		
		
		a1.setFeedingBehavior(new Behavior1());
		a2.setFeedingBehavior(new Behavior1());
		a3.setFeedingBehavior(new Behavior1());
		a4.setFeedingBehavior(new Behavior1());
		a5.setFeedingBehavior(new Behavior1());
		
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
		
	}
	
	public void drawAnimalCountTable() {
		
		runCount++;
		
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
		JButton addNewAnimalBtn = new JButton("Add New Animal Using Factory");	
		addNewAnimalBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				/*
				 * Updating the changes which will notify to all the pattern implementations. 
				 */
				sb.setAnimalListWithRunCount(list, runCount);
				
				addAnimalFrame = new JFrame();
				fimpl.drawAddAnimalForm(addAnimalFrame);
				addAnimalFrame.addWindowListener(new java.awt.event.WindowAdapter() {
					    @Override
					    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					    		addAnimalFrame.dispose();
					    		tableFrame.dispose();
					    		
					    		// Restart the count table frame
					    		drawAnimalCountTable();
					        	
					    }
				});
				
			}
		});
		bottombtnPnl.add(addNewAnimalBtn);
		btnPnl.add(bottombtnPnl, BorderLayout.CENTER);
		

		JButton decorateAnimalBtn = new JButton("Animal details and decoration");	
		decorateAnimalBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				/*
				 * Updating the changes which will notify to all the pattern implementations. 
				 */
				sb.setAnimalListWithRunCount(list, runCount);
				
				
				animalDecorationFrame = new JFrame();
				dimpl.showAnimalDecorationForm(animalDecorationFrame);
				animalDecorationFrame.addWindowListener(new java.awt.event.WindowAdapter() {
					    @Override
					    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					    		animalDecorationFrame.dispose();
					    		tableFrame.dispose();
					    		
					    		// Restart the count table frame
					    		drawAnimalCountTable();
					        	
					    }
				});
			}
		});
		bottombtnPnl.add(decorateAnimalBtn);
		btnPnl.add(bottombtnPnl, BorderLayout.CENTER);
		
		
		JButton feedingBtn = new JButton("Change Feeding Behavior");	
		feedingBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				/*
				 * Updating the changes which will notify to all the pattern implementations. 
				 */		
				sb.setAnimalListWithRunCount(list, runCount);
				
				changeAnimalFeedingBehaviorFrame = new JFrame();
				simpl.showChangeFeedingBehaviorForm(changeAnimalFeedingBehaviorFrame);
				changeAnimalFeedingBehaviorFrame.addWindowListener(new java.awt.event.WindowAdapter() {
					    @Override
					    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					    		changeAnimalFeedingBehaviorFrame.dispose();
					    		tableFrame.dispose();
					    		
					    		// Restart the count table frame
					    		drawAnimalCountTable();
	
					    }
				});
			}
		});
		bottombtnPnl.add(feedingBtn);
		btnPnl.add(bottombtnPnl, BorderLayout.CENTER);
		

		jt.getTableHeader().setReorderingAllowed(false);
		
		tableFrame.add(jt.getTableHeader(), BorderLayout.NORTH);
		tableFrame.add(jt, BorderLayout.CENTER);
		tableFrame.add(btnPnl, BorderLayout.SOUTH);
		
		
		tableFrame.setTitle("Animal Count Table"); 
		tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tableFrame.pack();
		Dimension min = new Dimension(800,500);
		tableFrame.setMinimumSize(min);
		tableFrame.setVisible(true);
	}
		
	    
}
