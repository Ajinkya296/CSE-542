import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	 * Create the frame.
	 */
	public PeerEval(int numOfMembers, boolean isPrevSubmitted) {
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		getContentPane().setLayout(null);

		String[] names = {"Tom" , "Matt" , "Pat" , "Bruce" , "Jim" , "Mike" , "Jon"};
		HashMap<String,ArrayList<Integer>> scores = new HashMap<String,ArrayList<Integer>>();
		for(int  i = 0 ; i < numOfMembers ; i++)
		{
			Integer arr[] = {5,4,3};
			ArrayList<Integer> individualScores = new ArrayList<Integer>(Arrays.asList( arr ));
			scores.put(names[i], individualScores) ;
		}
		
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
		
	
		ArrayList<JLabel> nameLabel = new ArrayList<JLabel>();
		ArrayList<JSpinner> scoreSpinner = new ArrayList<JSpinner>();
		
		for(int i = 0; i < numOfMembers; i++)
		{
			
			nameLabel.add(new JLabel(names[i]));
			nameLabel.get(i).setBounds(70, 100 + ((i)*51) , 70, 20);
			nameLabel.get(i).setFont(new Font("Arial", Font.PLAIN, 20));
			nameLabel.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(nameLabel.get(i));
			
			for(int j = 0 ; j < 3 ; j++) 
			{
				scoreSpinner.add(new JSpinner());
				scoreSpinner.get(scoreSpinner.size()-1).setBounds(280 + (j*130), 100 + (i*50), 50, 30);
				scoreSpinner.get(scoreSpinner.size()-1).setFont(new Font("Arial", Font.PLAIN, 20));
				
				if(isPrevSubmitted) 
				{
					int val = scores.get(names[i]).get(j);
					scoreSpinner.get(scoreSpinner.size()-1).setModel(new SpinnerNumberModel( val , 0, 5, 1));
				}
				else scoreSpinner.get(scoreSpinner.size()-1).setModel(new SpinnerNumberModel(0 , 0, 5, 1));
				((JSpinner.DefaultEditor)scoreSpinner.get(scoreSpinner.size()-1).getEditor()).getTextField().setEditable(false);
				getContentPane().add(scoreSpinner.get(scoreSpinner.size()-1));
				
			}
			
		}
		
		
		
		
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSubmit.setBounds(280, 450, 130, 50);
		btnSubmit.addActionListener(new SubmitClicked(scores));
		getContentPane().add(btnSubmit);
		
		
	}
	
	class SubmitClicked implements ActionListener
	{
		HashMap<String,ArrayList<Integer>> scores;
		SubmitClicked(HashMap<String,ArrayList<Integer>> scores)
		{
			this.scores = scores;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			HashMap<String,Double> normScores = normalizeScore(scores);
			Normalized normalizedScoreFrame = new Normalized(normScores);
			normalizedScoreFrame.setVisible(true);
		}

		private HashMap<String, Double> normalizeScore(HashMap<String, ArrayList<Integer>> scores) {
			// TODO Auto-generated method stub
			HashMap<String,Double> normalizedScore = new HashMap<String,Double>();
			HashMap<String,Integer> totalScore = new HashMap<String,Integer>();
			
			for(String name : scores.keySet())
			{
				int sum = 0 ;
				for(Integer points : scores.get(name))
				{
					sum += points;
				}
				totalScore.put(name,sum);
			}
			int sumOfTotalScores = 0;
			for(Integer score : totalScore.values())
			{
				sumOfTotalScores += score;
			}
			
			for(String name : totalScore.keySet())
			{
				normalizedScore.put(name, ((double)  totalScore.get(name) / sumOfTotalScores ) );
			}
			return normalizedScore;
		}
		
		
		
		
	}
	
	class SaveClicked implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
