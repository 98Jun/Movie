package Movie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SorryFrame {

	private JFrame f;

	public SorryFrame() {
		initialize();
	}

	private void initialize() {
		f = new JFrame();
		f.setBounds(100, 100, 450, 300);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		JPanel mainp = new JPanel();
		mainp.setBounds(12, 10, 410, 241);
		f.getContentPane().add(mainp);
		mainp.setLayout(null);

		JLabel sorrytext = new JLabel(
				"\uC774 \uC88C\uC11D\uC740 \uC608\uB9E4\uAC00 \uB418\uC5B4\uC788\uC2B5\uB2C8\uB2E4");
		sorrytext.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 21));
		sorrytext.setHorizontalAlignment(SwingConstants.CENTER);
		sorrytext.setBounds(0, 10, 410, 85);
		mainp.add(sorrytext);

		JButton backbtn = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		backbtn.setFont(new Font("굴림", Font.BOLD, 12));
		backbtn.setBounds(148, 183, 97, 48);
		mainp.add(backbtn);

		JLabel sorrytext_1 = new JLabel("\uB2E4\uB978 \uC88C\uC11D\uC744 \uC120\uD0DD \uD574 \uC8FC\uC138\uC694");
		sorrytext_1.setHorizontalAlignment(SwingConstants.CENTER);
		sorrytext_1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 21));
		sorrytext_1.setBounds(0, 72, 410, 85);
		mainp.add(sorrytext_1);
		f.setVisible(true);
		f.setLocationRelativeTo(null); // 창이 가운데로
		f.setResizable(false); // 크기변경 x

		backbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
	}
}
