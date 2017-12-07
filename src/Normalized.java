import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Normalized extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Normalized frame = new Normalized(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/* Invocation : Called when the Submit button is clicked on the PeerEval frame
	 * Purpose : Creates the normalized score frame which displays the names along with their normalized score. 
	 *  			1. 2 header labels
	 *  			2. 1 label for each name
	 *  			3. 1 label for each normalized score
	 */
	public Normalized(HashMap<String,Double> normScores) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 499);
		getContentPane().setLayout(null);
		

		/*
		 * Creating the Labels
		 */
		JLabel lblTeammates = new JLabel("Team members");
		lblTeammates.setBounds(30, 50, 150, 20);
		lblTeammates.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(lblTeammates);
		
		JLabel lblNorm = new JLabel("Normalized Score");
		lblNorm.setBounds(220, 50, 170, 20);
		lblNorm.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(lblNorm);
		
		int numOfMembers = normScores.size();
		
		// ArrayList of Labels for names and scores
		ArrayList<String> names = new  ArrayList<String>(normScores.keySet()); 
		ArrayList<JLabel> nameLabel = new ArrayList<JLabel>();
		ArrayList<JLabel> scoreLabel = new ArrayList<JLabel>();
		
		//Dynamically creating labels for names and scores  
		for(int i = 0; i < numOfMembers; i++)
		{
			nameLabel.add(new JLabel(names.get(i)));
			nameLabel.get(i).setBounds(70, 100 + ((i)*51) , 70, 20);
			nameLabel.get(i).setFont(new Font("Arial", Font.PLAIN, 20));
			nameLabel.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(nameLabel.get(i));
			
			// Scores are formatted to 2 decimal places
			scoreLabel.add(new JLabel( String.format( "%.2f" , normScores.get(names.get(i)))));
			scoreLabel.get(i).setBounds(220, 100 + ((i)*51) , 70, 20);
			scoreLabel.get(i).setFont(new Font("Arial", Font.PLAIN, 20));
			scoreLabel.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(scoreLabel.get(i));
			
		}
		
	}


}
