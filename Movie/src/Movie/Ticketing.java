package Movie;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class Ticketing {

	private JFrame f;
	private JTextField screentf;
	private ButtonGroup bg1;
	private Panel menup = null;
	private Panel mainp = null;
	private Choice choice = null;
	private Choice choice1 = null;
	private Label label = null;
	private Label label1 = null;
	private JToggleButton[] bt2 = new JToggleButton[42];
	private int year = 0;
	private int month = 0;
	private ButtonGroup bg = new ButtonGroup();

	public static void main(String args[]) {
		new Ticketing();
	}

	public Ticketing() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public Panel getMenup() { // 달력 년 / 월 정하기 
		if (menup == null) {
			label1 = new Label();
			label1.setText("년");
			label = new Label();
			label.setText("월");
			menup = new Panel();
			menup.setLayout(new FlowLayout());
			menup.add(getChoice(), null);
			menup.add(label1, null);
			menup.add(getChoice1(), null);
			menup.add(label, null);
		}
		return menup;
	}

	private Panel getMainp() { // 달력 요일, 일 출력
		if (mainp == null) {
			mainp = new Panel();
			mainp.setBackground(Color.LIGHT_GRAY);
			mainp.setLayout(new GridLayout(7, 7));
			JLabel[] day1 = new JLabel[7];
			String[] day = { "일", "월", "화", "수", "목", "금", "토" };

			for (int i = 0; i < 7; i++) {
				day1[i] = new JLabel(day[i]);
				mainp.add(day1[i]);
				day1[i].setHorizontalAlignment(SwingConstants.CENTER);
			}

			bt2 = new JToggleButton[42];
			for (int i = 0; i < 42; i++) {
				bt2[i] = new JToggleButton("");
				mainp.add(bt2[i]);
				bg.add(bt2[i]);
			}

			year = Integer.parseInt(choice.getSelectedItem());
			month = Integer.parseInt(choice1.getSelectedItem());

			int startDay = 0;
			int endDay = 0;

			Calendar sDay = java.util.Calendar.getInstance();
			Calendar eDay = java.util.Calendar.getInstance();

			sDay.set(year, month - 1, 1);
			eDay.set(year, month, 1);
			eDay.add(java.util.Calendar.DATE, -1);

			startDay = sDay.get(java.util.Calendar.DAY_OF_WEEK);
			endDay = eDay.get(java.util.Calendar.DATE);

			for (int i = 1; i <= endDay; i++) {
				bt2[i + startDay - 2].setLabel(i + "");

			}
		}
		return mainp;
	}

	private Choice getChoice() { // 메뉴에 있는 년도
		if (choice == null) {
			choice = new Choice();
			choice.add("2023");
			choice.add("2022");
			choice.select(1);
		}
		return choice;
	}

	private Choice getChoice1() { // 메뉴에 있는 월 
		if (choice1 == null) {
			choice1 = new Choice();
			choice1.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {

					for (int i = 0; i < 42; i++) {
						bt2[i].setLabel("");

					}

					year = Integer.parseInt(choice.getSelectedItem());
					month = Integer.parseInt(choice1.getSelectedItem());

					int startDay = 0;
					int endDay = 0;

					java.util.Calendar sDay = java.util.Calendar.getInstance();
					java.util.Calendar eDay = java.util.Calendar.getInstance();

					sDay.set(year, month - 1, 1);
					eDay.set(year, month, 1);
					eDay.add(java.util.Calendar.DATE, -1);

					startDay = sDay.get(java.util.Calendar.DAY_OF_WEEK);
					endDay = eDay.get(java.util.Calendar.DATE);

					for (int i = 1; i <= endDay; i++) {
						bt2[i + startDay - 2].setLabel(i + "");
					}
				}
			});
			choice1.add("1");
			choice1.add("2");
			choice1.add("3");
			choice1.add("4");
			choice1.add("5");
			choice1.add("6");
			choice1.add("7");
			choice1.add("8");
			choice1.add("9");
			choice1.add("10");
			choice1.add("11");
			choice1.add("12");

			choice1.select(6); // 7월부터 출력

		}
		return choice1;
	}

	private void initialize() { // 프레임 구현
		f = new JFrame("날짜 좌석 시간");
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

		JPanel calp = new JPanel();
		calp.setBackground(Color.GRAY);
		calp.setBounds(12, 10, 648, 465);
		calp.setLayout(new BorderLayout(0, 0));
		calp.add(getMenup(),BorderLayout.NORTH);
		calp.add(getMainp(),BorderLayout.CENTER);
		cp.add(calp);
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
		two.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
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
		three1.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
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
		three2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
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
		lblNewLabel_3.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
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
		four2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
		four2.setHorizontalAlignment(SwingConstants.CENTER);
		four2.setBounds(207, 10, 57, 15);
		timep5.add(four2);

		JButton nextbtn = new JButton("\uC608\uB9E4\uD558\uAE30");
		nextbtn.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 19));
		nextbtn.setBounds(684, 875, 270, 61);
		panel.add(nextbtn);

		JPanel seatp = new JPanel();
		seatp.setLayout(null);
		seatp.setBounds(5, 497, 672, 439);
		panel.add(seatp);

		screentf = new JTextField();
		screentf.setText("S C R E E N");
		screentf.setHorizontalAlignment(SwingConstants.CENTER);
		screentf.setForeground(Color.WHITE);
		screentf.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 46));
		screentf.setColumns(10);
		screentf.setBackground(Color.DARK_GRAY);
		screentf.setBounds(12, 10, 648, 97);
		seatp.add(screentf);

		JPanel alinep = new JPanel();
		alinep.setBounds(139, 167, 406, 53);
		seatp.add(alinep);
		alinep.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton a1 = new JToggleButton("A1");
		alinep.add(a1);

		JToggleButton a2 = new JToggleButton("A2");
		alinep.add(a2);

		JToggleButton a3 = new JToggleButton("A3");
		alinep.add(a3);

		JToggleButton a4 = new JToggleButton("A4");
		alinep.add(a4);

		JToggleButton a5 = new JToggleButton("A5");
		alinep.add(a5);

		JToggleButton a6 = new JToggleButton("A6");
		alinep.add(a6);

		JPanel blinep = new JPanel();
		blinep.setBounds(139, 230, 406, 53);
		seatp.add(blinep);
		blinep.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton b1 = new JToggleButton("B1");
		blinep.add(b1);

		JToggleButton b2 = new JToggleButton("B2");
		blinep.add(b2);

		JToggleButton b3 = new JToggleButton("B3");
		blinep.add(b3);

		JToggleButton b4 = new JToggleButton("B4");
		blinep.add(b4);

		JToggleButton b5 = new JToggleButton("B5");
		blinep.add(b5);

		JToggleButton b6 = new JToggleButton("B6");
		blinep.add(b6);

		JPanel clinep = new JPanel();
		clinep.setBounds(139, 293, 406, 53);
		seatp.add(clinep);
		clinep.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton c1 = new JToggleButton("C1");
		clinep.add(c1);

		JToggleButton c2 = new JToggleButton("C2");
		clinep.add(c2);

		JToggleButton c3 = new JToggleButton("C3");
		clinep.add(c3);

		JToggleButton c4 = new JToggleButton("C4");
		clinep.add(c4);

		JToggleButton c5 = new JToggleButton("C5");
		clinep.add(c5);

		JToggleButton c6 = new JToggleButton("C6");
		clinep.add(c6);

		JPanel dlinep = new JPanel();
		dlinep.setBounds(139, 356, 406, 53);
		seatp.add(dlinep);
		dlinep.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton d1 = new JToggleButton("D1");
		dlinep.add(d1);

		JToggleButton d2 = new JToggleButton("D2");
		dlinep.add(d2);

		JToggleButton d3 = new JToggleButton("D3");
		dlinep.add(d3);

		JToggleButton d4 = new JToggleButton("D4");
		dlinep.add(d4);

		JToggleButton d5 = new JToggleButton("D5");
		dlinep.add(d5);

		JToggleButton d6 = new JToggleButton("D6");
		dlinep.add(d6);
		
		
		bg1 = new ButtonGroup(); // 좌석 그룹
		bg1.add(a1);
		bg1.add(a2);
		bg1.add(a3);
		bg1.add(a4);
		bg1.add(a5);
		bg1.add(a6);

		bg1.add(b1);
		bg1.add(b2);
		bg1.add(b3);
		bg1.add(b4);
		bg1.add(b5);
		bg1.add(b6);

		bg1.add(c1);
		bg1.add(c2);
		bg1.add(c3);
		bg1.add(c4);
		bg1.add(c5);
		bg1.add(c6);

		bg1.add(d1);
		bg1.add(d2);
		bg1.add(d3);
		bg1.add(d4);
		bg1.add(d5);
		bg1.add(d6);
//		ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		f.setVisible(true); // 창ㄴ ㅏ옴 
		f.setLocationRelativeTo(null); // 창이 가운데로
		f.setResizable(false); // 크기변경 x

	}
}
