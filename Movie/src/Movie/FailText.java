package Movie;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FailText {
	public JFrame frame;
	
	public FailText() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame("Fail");
		frame.setSize(new Dimension(383, 236));
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // â�� �����
		frame.setResizable(false);
		
		JLabel faillabel = new JLabel("\uB85C\uADF8\uC778 \uC2E4\uD328");
		faillabel.setFont(new Font("����", Font.BOLD, 29));
		faillabel.setHorizontalAlignment(JLabel.CENTER); // ��� ���� 

		frame.getContentPane().add(faillabel, BorderLayout.CENTER);
		frame.setVisible(true);	
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
			}
		});
			
			
	}
}
