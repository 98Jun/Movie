package Movie;


import javax.swing.JFrame;

public class Success {

	private JFrame f;
	public Success() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		f = new JFrame();
		f.setBounds(100, 100, 550, 700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null); // 창이 가운데로
		f.setResizable(false); // 크기변경 x
		f.setVisible(true); // 실앻ㅇ
	}

}
