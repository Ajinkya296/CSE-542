import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JToggleButton;



/*
 *  Purpose : Creates and handles the start frame of the application
 */
public class StartFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	static int countOpenWindows = 0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JRadioButton rdbtnYes;
	JRadioButton rdbtnNo;
	ButtonGroup group;
	JComboBox comboBox; 
	
	
	/* Invocation : Called when the application is launched
	 * Purpose : Creates the start frame with all the elements that need to appear on the frame 
	 *  			1. 2 labels 
	 *  			2. 1 comboBox
	 *  			3. 2 radio Buttons
	 *  			4. 1 Button
	 */
	public StartFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 346);
		getContentPane().setLayout(null);
		
		/*
		 * Creating the Labels
		 */
		JLabel lblNewLabel = new JLabel("Enter number of team-mates");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 46, 285, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Have your previously submitted a score : ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 116, 370, 22);
		getContentPane().add(lblNewLabel_1);
		
		
		/*
		 * Creating the comboBox number of team-members [values : 2 to 7 inclusive]
		 */
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7"}));
		comboBox.setBounds(420, 46, 114, 30);
		getContentPane().add(comboBox);
		
		
		
		
		/*
		 * Creating the Next Button
		 */
		JButton NextButton = new JButton("Next");
		NextButton.setFont(new Font("Arial", Font.PLAIN, 20));
		NextButton.setBounds(233, 199, 175, 42);
		
		//Adding Action Listener to Next Button
		NextButton.addActionListener(new NextButtonClicked());
		getContentPane().add(NextButton);
		
		
		
		/*
		 * Creating radio buttons Yes and No
		 */
		rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setFont(new Font("Arial", Font.PLAIN, 20));
		rdbtnYes.setBounds(420, 109, 70, 25);
		rdbtnYes.setActionCommand("Yes");
		getContentPane().add(rdbtnYes);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Arial", Font.PLAIN, 20));
		rdbtnNo.setBounds(514, 109, 61, 25);
		rdbtnNo.setActionCommand("No");
		
	   // Setting No to be by default selected.
		rdbtnNo.setSelected(true);
		getContentPane().add(rdbtnNo);
		
		group = new ButtonGroup();
		group.add(rdbtnYes);
		group.add(rdbtnNo);
	}
	
	/*
	 *  Purpose: Instance of this class is an action listener to Next Button 
	 */
	class NextButtonClicked  implements ActionListener {

		/*
		 *  Invocation : Called when Next Button is clicked. 
		 *  Purpose :   1)  Parses all the input elements and stores values in respective variables
		 *  				num_selection  : number of team members [From combo Box]
		 *  				radio_selection: Yes/No for previously submitted or not  [From Radio Buttons]
		 *  			2)  Opens the next frame (PeerEval) if not already opened and passes variable to the next frame. 
		 *  				Increases count of open windows
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean isPrevSubmitted = false;
			int num_selection = Integer.parseInt((String)comboBox.getSelectedItem());
			String radio_selection = group.getSelection().getActionCommand();
			System.out.println("You selected : num of members : " + num_selection + " subimtted : " + radio_selection);
			if(radio_selection.equals("Yes"))
			{
				isPrevSubmitted = true;
			}
			if(countOpenWindows == 0)
			{	
				PeerEval nextFrame = new PeerEval(num_selection,isPrevSubmitted);
				nextFrame.setVisible(true);
				countOpenWindows++;
			}
			
		}
	
	}
	}
	
	
