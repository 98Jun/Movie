package Movie;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FailText {
	public JFrame f;

	public FailText() {
		initialize();
	}

	private void initialize() {
		f = new JFrame("Fail");
		f.setSize(new Dimension(383, 236));
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null); // 창이 가운데로
		f.setResizable(false);
		f.getContentPane().setLayout(null);

		JPanel p = new JPanel();
		p.setBounds(12, 10, 343, 177);
		f.getContentPane().add(p);
		p.setLayout(new BorderLayout(0, 0));

		JLabel text = new JLabel("\uB85C\uADF8\uC778 \uC2E4\uD328");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("굴림", Font.BOLD, 49));
		p.add(text);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.setVisible(false);
			}
		});

	}
}
