import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AddAnimal extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public AddAnimal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 50, 1000, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
