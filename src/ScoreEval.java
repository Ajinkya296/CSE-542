import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class ScoreEval extends JFrame {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreEval frame = new ScoreEval();
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
	public ScoreEval() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 500);
		getContentPane().setLayout(null);
		
		
		JLabel lblTeammates = new JLabel("Team members");
		lblTeammates.setFont(new Font("Arial", Font.BOLD, 15));
		getContentPane().add(lblTeammates);
		
		JLabel lblProfessionalism = new JLabel("Professionalism");
		lblProfessionalism.setFont(new Font("Arial", Font.BOLD, 15));
		getContentPane().add(lblProfessionalism);
		
		JLabel lblMeeting = new JLabel("Meeting");
		lblMeeting.setFont(new Font("Arial", Font.BOLD, 15));
		getContentPane().add(lblMeeting);
		
		JLabel lblParticipation = new JLabel("Participation");
		lblParticipation.setFont(new Font("Arial", Font.BOLD, 15));
		getContentPane().add(lblParticipation);
		
		JLabel lblTom = new JLabel("Tom");
		lblTom.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTom.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTom);
		
		JLabel lblMat = new JLabel("Mat");
		lblMat.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMat.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTom);
		
		JLabel lblPat = new JLabel("Pat");
		lblPat.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPat.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTom);
		
		JLabel lblBruce = new JLabel("Bruce");
		lblBruce.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBruce.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTom);
		
		JLabel lblJim = new JLabel("Jim");
		lblJim.setFont(new Font("Arial", Font.PLAIN, 15));
		lblJim.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTom);
		
		JSpinner spinner_0 = new JSpinner();
		spinner_0.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_11 = new JSpinner();
		spinner_11.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_12 = new JSpinner();
		spinner_12.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_13 = new JSpinner();
		spinner_13.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		JSpinner spinner_14 = new JSpinner();
		spinner_14.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		
		getContentPane().add(spinner_0);
		getContentPane().add(spinner_1);
		getContentPane().add(spinner_2);
		getContentPane().add(spinner_3);
		getContentPane().add(spinner_4);
		getContentPane().add(spinner_5);
		getContentPane().add(spinner_6);
		getContentPane().add(spinner_7);
		getContentPane().add(spinner_8);
		getContentPane().add(spinner_9);
		getContentPane().add(spinner_10);
		getContentPane().add(spinner_11);
		getContentPane().add(spinner_12);
		getContentPane().add(spinner_13);
		getContentPane().add(spinner_14);
		
		
		JButton btnSave = new JButton("Save");
		getContentPane().add(btnSave);
		JButton btnSubmit = new JButton("Submit");
		getContentPane().add(btnSubmit);
		
		
		/*GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTeammates)
					.addGap(51)
					.addComponent(lblProfessionalism)
					.addGap(21)
					.addComponent(lblMeeting)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblParticipation)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBruce, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPat, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJim, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMat, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTom, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(120)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(spinner_3, Alignment.TRAILING)
						.addComponent(spinner, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
						.addComponent(spinner_6)
						.addComponent(spinner_9)
						.addComponent(spinner_12))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
								.addComponent(spinner_7)
								.addComponent(spinner_10)
								.addComponent(spinner_13)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(spinner_8, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(spinner_11)
								.addComponent(spinner_14, Alignment.TRAILING)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinner_5, Alignment.TRAILING)
								.addComponent(spinner_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))))
					.addGap(102))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(79)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(87)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(151, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(86)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTeammates)
						.addComponent(lblParticipation)
						.addComponent(lblProfessionalism)
						.addComponent(lblMeeting))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTom)
							.addGap(18)
							.addComponent(lblMat)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPat)
							.addGap(18)
							.addComponent(lblBruce)
							.addGap(18)
							.addComponent(lblJim))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(spinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(spinner_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(4)
									.addComponent(spinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
									.addComponent(spinner_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(spinner_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(spinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
									.addComponent(spinner_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(spinner_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(74)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(50))
		);
		contentPane.setLayout(gl_contentPane);*/
	}
}
