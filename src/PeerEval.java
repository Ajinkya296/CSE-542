import java.awt.EventQueue;
import java.awt.Font; 
import javax.swing.plaf.FontUIResource; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.UIManager;
import java.util.*;
public class PeerEval extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeerEval frame = new PeerEval(5,true);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *  Class variables : Dummy names, ArrayLists for Labels and Spinners
	 */
	String[] names = {"Tom" , "Matt" , "Pat" , "Bruce" , "Jim" , "Mike" , "Jon"};
	ArrayList<JLabel>    nameLabel   = new ArrayList<JLabel>();
	ArrayList<JSpinner> scoreSpinner = new ArrayList<JSpinner>();
	int numOfMembers;
	
	
	/* Invocation : Called when the Next Button is clicked on Start Frame 
	 * Purpose : Creates the Peer Evaluation form with all the elements that need to appear on the frame. To edit/fill evaluation survey 
	 *  			1. 4 labels for headers 
	 *  			2. 1 label for each member name
	 *  			3. 3 spinner for each member
	 *  			4. 1 Button
	 */
	public PeerEval(int numOfMembers, boolean isPrevSubmitted) {
		UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("ARIAL",Font.PLAIN,15)));
		this.numOfMembers = numOfMembers;
		
		/*
		 *  If window is closed ; close the current window only not the previous ones.
		 *  After closing frame, reset the count of open windows
		 */
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter()
	        {
	            @Override
	            public void windowClosing(WindowEvent e)
	            {
	            	StartFrame s = new StartFrame();
	                s.countOpenWindows--;
	                e.getWindow().dispose();
	            }
	        });
		setBounds(100, 100, 700, 600);
		getContentPane().setLayout(null);

		
		/* Data Structure for scores
		 * LinkedHashMap with name of the member as key and List of topic-wise scores of that member as value 
		*/
		LinkedHashMap<String,ArrayList<Integer>> scores = new LinkedHashMap<String,ArrayList<Integer>>();
		
		/*
		 * Dummy random assignment of previously submitted survey scores
		 */
		Random rand = new Random();
		for(int  i = 0 ; i < numOfMembers ; i++)
		{
			Integer arr[] = {rand.nextInt(5)+ 1,rand.nextInt(5)+ 1,rand.nextInt(5)+ 1};
			ArrayList<Integer> individualScores = new ArrayList<Integer>(Arrays.asList( arr ));
			scores.put(names[i], individualScores) ;
		}
		
		
		/*
		 * Creating Labels for headers
		 */
		JLabel lblTeammates = new JLabel("Team members");
		lblTeammates.setBounds(30, 50, 150, 20);
		lblTeammates.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(lblTeammates);
		
	
		JLabel lblProfessionalism = new JLabel("Professionalism");
		lblProfessionalism.setBounds(220, 50, 170, 20);
		lblProfessionalism.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(lblProfessionalism);
		
		JLabel lblMeeting = new JLabel("Meeting");
		lblMeeting.setBounds(400, 50, 150, 20);
		lblMeeting.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(lblMeeting);
		
			
		JLabel lblParticipation = new JLabel("Participation");
		lblParticipation.setBounds(500, 50, 150, 20);
		lblParticipation.setFont(new Font("Arial", Font.BOLD, 20));
		getContentPane().add(lblParticipation);
		

		/*
		 * Dynamically Creating labels for names and 3 spinners for each name.
		 */
		for(int i = 0; i < numOfMembers; i++)
		{
			
			nameLabel.add(new JLabel(names[i]));
			nameLabel.get(i).setBounds(70, 100 + ((i)*51) , 70, 20);
			nameLabel.get(i).setFont(new Font("Arial", Font.PLAIN, 20));
			nameLabel.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(nameLabel.get(i));
			
			// 3 spinners for each name
			for(int j = 0 ; j < 3 ; j++) 
			{
				scoreSpinner.add(new JSpinner());
				scoreSpinner.get(scoreSpinner.size()-1).setBounds(280 + (j*130), 100 + (i*50), 50, 30);
				scoreSpinner.get(scoreSpinner.size()-1).setFont(new Font("Arial", Font.PLAIN, 20));
				
				// if not a new survey (i.e previously submitted) then spinners get whatever value exists in the data structure else  all spinners will have value 0
				if(isPrevSubmitted) 
				{
					int val = scores.get(names[i]).get(j);
					scoreSpinner.get(scoreSpinner.size()-1).setModel(new SpinnerNumberModel( val , 0, 5, 1));
				}
				else scoreSpinner.get(scoreSpinner.size()-1).setModel(new SpinnerNumberModel(0 , 0, 5, 1));
				// Disabling text editing in all spinners to avoid unwanted input
				((JSpinner.DefaultEditor)scoreSpinner.get(scoreSpinner.size()-1).getEditor()).getTextField().setEditable(false);
				getContentPane().add(scoreSpinner.get(scoreSpinner.size()-1));
				
			}
			
		}
		
		/*
		 * Creating Submit Button
		*/
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSubmit.setBounds(280, 450, 130, 50);
		
		// Adding action listener to submit button
		btnSubmit.addActionListener(new SubmitClicked());
		getContentPane().add(btnSubmit);
		
	}
	
	/*
	 *  Purpose    : Getter method to obtain values entered by the user through the spinners
	 *  Parameters  :  None
	 *  Returns	    :  LinkedHashMap<String, ArrayList<Integer>> scores
	 */
	public LinkedHashMap<String, ArrayList<Integer>> getScores()
	{
		//DataStructure for scores
		LinkedHashMap<String,ArrayList<Integer>> scores = new  LinkedHashMap<String,ArrayList<Integer>>();
		int i = 0;
		
		// parsing 3 spinners for each member name
		for(String name : Arrays.copyOfRange(names, 0, numOfMembers))
		{
			int value1=0,value2=0,value3=0;
			ArrayList<Integer> tempScore =  new ArrayList<Integer>();
			value1 = (Integer) scoreSpinner.get(i).getValue();
			value2 = (Integer) scoreSpinner.get(i+1).getValue();
			value3 = (Integer) scoreSpinner.get(i+2).getValue();
			tempScore.add(value1);
			tempScore.add(value2);
			tempScore.add(value3);
			i = i+3;
			scores.put(name, tempScore);
		}
		return scores;
	}
	
	/*
	 *  Purpose     : Performs normalization on the scores data structure.
	 *  Parameters  :  LinkedHashMap<String, ArrayList<Integer>> scores
	 *  Returns	    :  LinkedHashMap<String, Double> normalized scores
	 */
	public LinkedHashMap<String, Double> normalizeScore(LinkedHashMap<String, ArrayList<Integer>> scores) {
		// TODO Auto-generated method stub
		LinkedHashMap<String,Double> normalizedScore = new LinkedHashMap<String,Double>();
		LinkedHashMap<String,Integer> totalScore = new LinkedHashMap<String,Integer>();
		
		//Calculates total scores for each student
		for(String name : scores.keySet())
		{
			int sum = 0 ;
			for(Integer points : scores.get(name))
			{
				sum += points;
			}
			totalScore.put(name,sum);
		}
		
		//Calculates sum of all total scores
		int sumOfTotalScores = 0;
		for(Integer score : totalScore.values())
		{
			sumOfTotalScores += score;
		}
		
		//Error handling to avoid division by zero 
		if(sumOfTotalScores == 0)
		{
			JLabel label = new JLabel( " Form you tried to submit has all entries 0.\n  Please fill some entries. ");
			label.setFont(new Font("Arial", Font.BOLD, 15));
			JOptionPane.showMessageDialog( null ,label, "Empty Submission Error",JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		// Calculates normalized fraction for each name
		for(String name : totalScore.keySet())
		{
			normalizedScore.put(name, ((double)  totalScore.get(name) / sumOfTotalScores ) );
		}
		
		return normalizedScore;
	}
	
	
	/*
	 * Purpose :  Instance is called when submit button is clicked
	 */
	class SubmitClicked implements ActionListener
	{
		
		/*
		 *  Invocation : Called when Submit Button is clicked. 
		 *  Purpose :   1)  Obtains scores entered on the form in the scores data structure
		 *  			2)  Opens the next frame (Normalized) passes normalized scores to the next frame.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			LinkedHashMap<String, ArrayList<Integer>> scores = getScores();
			LinkedHashMap<String,Double> normScores = normalizeScore(scores);
			if(normScores != null) {
				Normalized normalizedScoreFrame = new Normalized(normScores);
				normalizedScoreFrame.setVisible(true);
			}
			
		}

		
		
		
		
		
	}
	
}
