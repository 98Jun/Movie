package Movie;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class OKText {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public OKText() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(" Good");
		frame.setSize(new Dimension(383, 236));
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // 창이 가운데로
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		JLabel oklabel = new JLabel("\uC644\uB8CC.");
		oklabel.setFont(new Font("굴림", Font.BOLD, 29));
		oklabel.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬 

		frame.getContentPane().add(oklabel, BorderLayout.CENTER);
		frame.setVisible(true);	
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
			}
		});
	}

}
