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
		f.setLocationRelativeTo(null); // â�� �����
		f.setResizable(false); // ũ�⺯�� x
		f.setVisible(true); // �ǝ
	}

}
