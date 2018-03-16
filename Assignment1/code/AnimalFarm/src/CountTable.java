import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class CountTable extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public CountTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 10, 1100, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		String data[][]={ {"101","Amit","670000"},    
	             {"102","Jai","780000"},    
	             {"101","Sachin","700000"}};    
		String column[]={"ID","NAME","SALARY"};   
		 
		table = new JTable(data,column);
		contentPane.add(table, BorderLayout.NORTH);
	}

}
