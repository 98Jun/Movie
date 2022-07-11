package Movie;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class Ticketing {

	private JFrame f;
	private JTextField textField;

	public static void main(String args[]) {
		new Ticketing();
	}

	public Ticketing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		f = new JFrame();
		f.setBounds(100, 100, 1000, 1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(12, 10, 960, 941);
		f.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel cp = new JPanel();
		cp.setLayout(null);
		cp.setBounds(5, 5, 672, 485);
		panel.add(cp);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 5, 660, 470);
		cp.add(calendar);

		JPanel timep1 = new JPanel();
		timep1.setLayout(null);
		timep1.setBounds(684, 5, 270, 166);
		panel.add(timep1);

		JRadioButton rb1 = new JRadioButton("09 : 20");
		rb1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb1.setForeground(Color.BLACK);
		rb1.setBounds(33, 49, 69, 23);
		timep1.add(rb1);

		JRadioButton rb3 = new JRadioButton("12 : 00");
		rb3.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb3.setBounds(33, 95, 69, 23);
		timep1.add(rb3);

		JRadioButton rb4 = new JRadioButton("16 : 50");
		rb4.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb4.setBounds(163, 95, 69, 23);
		timep1.add(rb4);

		JRadioButton rb2 = new JRadioButton("10 : 30");
		rb2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb2.setBounds(163, 49, 69, 23);
		timep1.add(rb2);

		JLabel two = new JLabel("2\uCE35 1\uAD00");
		two.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.BOLD, 12));
		two.setHorizontalAlignment(SwingConstants.CENTER);
		two.setBounds(207, 10, 57, 15);
		timep1.add(two);

		JPanel timep2 = new JPanel();
		timep2.setLayout(null);
		timep2.setBounds(684, 176, 270, 166);
		panel.add(timep2);

		JRadioButton rb7 = new JRadioButton("14 : 30");
		rb7.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb7.setBounds(33, 95, 69, 23);
		timep2.add(rb7);

		JRadioButton rb5 = new JRadioButton("08 : 00");
		rb5.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb5.setBounds(33, 49, 69, 23);
		timep2.add(rb5);

		JRadioButton rb6 = new JRadioButton("09 : 00");
		rb6.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb6.setBounds(163, 49, 69, 23);
		timep2.add(rb6);

		JRadioButton rb8 = new JRadioButton("17 : 20");
		rb8.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb8.setBounds(163, 95, 69, 23);
		timep2.add(rb8);

		JLabel three1 = new JLabel("3\uCE35 1\uAD00");
		three1.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.BOLD, 12));
		three1.setHorizontalAlignment(SwingConstants.CENTER);
		three1.setBounds(207, 10, 57, 15);
		timep2.add(three1);

		JPanel timep3 = new JPanel();
		timep3.setLayout(null);
		timep3.setBounds(684, 352, 270, 166);
		panel.add(timep3);

		JRadioButton rb9 = new JRadioButton("21 : 10");
		rb9.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb9.setBounds(33, 95, 69, 23);
		timep3.add(rb9);

		JRadioButton rb10 = new JRadioButton("17 : 00");
		rb10.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb10.setBounds(33, 49, 69, 23);
		timep3.add(rb10);

		JRadioButton rb11 = new JRadioButton("20 : 00");
		rb11.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb11.setBounds(163, 49, 69, 23);
		timep3.add(rb11);

		JRadioButton rb12 = new JRadioButton("23 : 20");
		rb12.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb12.setBounds(163, 95, 69, 23);
		timep3.add(rb12);

		JLabel three2 = new JLabel("3\uCE35 2\uAD00");
		three2.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.BOLD, 12));
		three2.setHorizontalAlignment(SwingConstants.CENTER);
		three2.setBounds(207, 10, 57, 15);
		timep3.add(three2);

		JPanel four = new JPanel();
		four.setLayout(null);
		four.setBounds(684, 528, 270, 166);
		panel.add(four);

		JRadioButton rb13 = new JRadioButton("16 : 50");
		rb13.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb13.setBounds(33, 95, 69, 23);
		four.add(rb13);

		JRadioButton rb14 = new JRadioButton("11: 30");
		rb14.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb14.setBounds(33, 49, 69, 23);
		four.add(rb14);

		JRadioButton rb15 = new JRadioButton("12 : 00");
		rb15.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb15.setBounds(163, 49, 69, 23);
		four.add(rb15);

		JRadioButton rb16 = new JRadioButton("23: 30");
		rb16.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb16.setBounds(163, 95, 69, 23);
		four.add(rb16);

		JLabel lblNewLabel_3 = new JLabel("4\uCE35 1\uAD00");
		lblNewLabel_3.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(207, 10, 57, 15);
		four.add(lblNewLabel_3);

		JPanel timep5 = new JPanel();
		timep5.setLayout(null);
		timep5.setBounds(684, 704, 270, 166);
		panel.add(timep5);

		JRadioButton rb17 = new JRadioButton("22: 20");
		rb17.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb17.setBounds(33, 95, 69, 23);
		timep5.add(rb17);

		JRadioButton rb18 = new JRadioButton("09 : 00");
		rb18.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb18.setBounds(33, 49, 69, 23);
		timep5.add(rb18);

		JRadioButton rb19 = new JRadioButton("19 : 20");
		rb19.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb19.setBounds(163, 49, 69, 23);
		timep5.add(rb19);

		JRadioButton rb20 = new JRadioButton("23 : 00");
		rb20.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		rb20.setBounds(163, 95, 69, 23);
		timep5.add(rb20);

		JLabel four2 = new JLabel("4\uCE35 2\uAD00");
		four2.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.BOLD, 12));
		four2.setHorizontalAlignment(SwingConstants.CENTER);
		four2.setBounds(207, 10, 57, 15);
		timep5.add(four2);

		JButton nextbtn = new JButton("\uC608\uB9E4\uD558\uAE30");
		nextbtn.setFont(new Font("»ﬁ∏’µ’±Ÿ«ÏµÂ∂Û¿Œ", Font.PLAIN, 12));
		nextbtn.setBounds(776, 875, 114, 61);
		panel.add(nextbtn);

		JPanel seatp = new JPanel();
		seatp.setLayout(null);
		seatp.setBounds(5, 497, 672, 439);
		panel.add(seatp);

		textField = new JTextField();
		textField.setText("S C R E E N");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("»ﬁ∏’µ’±Ÿ«ÏµÂ∂Û¿Œ", Font.BOLD, 46));
		textField.setColumns(10);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(12, 10, 648, 97);
		seatp.add(textField);

		JPanel alinep = new JPanel();
		alinep.setBounds(139, 167, 406, 53);
		seatp.add(alinep);
		alinep.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton a1 = new JToggleButton("New");
		alinep.add(a1);

		JToggleButton a2 = new JToggleButton("New");
		alinep.add(a2);

		JToggleButton a3 = new JToggleButton("New");
		alinep.add(a3);

		JToggleButton a4 = new JToggleButton("New");
		alinep.add(a4);

		JToggleButton a5 = new JToggleButton("New");
		alinep.add(a5);

		JToggleButton a6 = new JToggleButton("New");
		alinep.add(a6);

		JPanel blinep = new JPanel();
		blinep.setBounds(139, 230, 406, 53);
		seatp.add(blinep);
		blinep.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton b1 = new JToggleButton("New");
		blinep.add(b1);

		JToggleButton b2 = new JToggleButton("New");
		blinep.add(b2);

		JToggleButton b3 = new JToggleButton("New");
		blinep.add(b3);

		JToggleButton b4 = new JToggleButton("New");
		blinep.add(b4);

		JToggleButton b5 = new JToggleButton("New");
		blinep.add(b5);

		JToggleButton b6 = new JToggleButton("New");
		blinep.add(b6);

		JPanel clinep = new JPanel();
		clinep.setBounds(139, 293, 406, 53);
		seatp.add(clinep);
		clinep.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton c1 = new JToggleButton("New");
		clinep.add(c1);

		JToggleButton c2 = new JToggleButton("New");
		clinep.add(c2);

		JToggleButton c3 = new JToggleButton("New");
		clinep.add(c3);

		JToggleButton c4 = new JToggleButton("New");
		clinep.add(c4);

		JToggleButton c5 = new JToggleButton("New");
		clinep.add(c5);

		JToggleButton c6 = new JToggleButton("New");
		clinep.add(c6);

		JPanel dlinep = new JPanel();
		dlinep.setBounds(139, 356, 406, 53);
		seatp.add(dlinep);
		dlinep.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton d1 = new JToggleButton("New");
		dlinep.add(d1);

		JToggleButton d2 = new JToggleButton("New");
		dlinep.add(d2);

		JToggleButton d3 = new JToggleButton("New");
		dlinep.add(d3);

		JToggleButton d4 = new JToggleButton("New");
		dlinep.add(d4);

		JToggleButton d5 = new JToggleButton("New");
		dlinep.add(d5);

		JToggleButton d6 = new JToggleButton("New");
		dlinep.add(d6);

		f.setVisible(true);
		f.setLocationRelativeTo(null); // √¢¿Ã ∞°øÓµ•∑Œ
		f.setResizable(false); // ≈©±‚∫Ø∞Ê x

	}
}
