package Movie;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import DAO.SeatDAO;
import DAO.TicketDAO;
import VO.MovieVO;
import VO.SeatVO;
import VO.TicketVO;

public class Ticketing implements ActionListener {

	private JFrame f;
	private JTextField screentf;
	private ButtonGroup bgseat;
	private ButtonGroup bgtime = new ButtonGroup();
	private JRadioButton[] timebt = new JRadioButton[20];
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
	private JToggleButton[] bt = new JToggleButton[24];
	private String seat[] = { "a1", "a2", "a3", "a4", "a5", "a6", "b1", "b2", "b3", "b4", "b5", "b6", "c1", "c2", "c3",
			"c4", "c5", "c6", "d1", "d2", "d3", "d4", "d5", "d6" };;
	private String time[] = { "09 : 20", "10 : 30", "12 : 00", "16 : 50", "08 : 00", "09 : 00", "14 : 30", "17 : 20",
			"17 : 00", "20 : 00", "21 : 10", "23 : 20", "11 : 30", "12 : 00", "16 : 50", "23 : 30", "09 : 10",
			"19 : 20", "22 : 20", "23 : 00" };
	private JButton nextbtn;
	private String days;
	private SeatVO vo;
	private SeatDAO dao;
	private String seatcord;
	int startDay;
	int endDay;

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
			for (int i = 0; i < 42; i++) { // 일
				bt2[i] = new JToggleButton("");
				mainp.add(bt2[i]);
				bg.add(bt2[i]);
				bt2[i].addActionListener(this);
			}

			year = Integer.parseInt(choice.getSelectedItem());
			month = Integer.parseInt(choice1.getSelectedItem());

			int startDay = 0;
			int endDay = 0;

			Calendar sDay = Calendar.getInstance();
			Calendar eDay = Calendar.getInstance();

			sDay.set(year, month - 1, 1);
			eDay.set(year, month, 1);
			eDay.add(java.util.Calendar.DATE, -1);

			startDay = sDay.get(Calendar.DAY_OF_WEEK);
			endDay = eDay.get(Calendar.DATE);

			for (int i = 1; i <= endDay; i++) {
				bt2[i + startDay - 2].setText(i + "");

			}
		}
		return mainp;
	}

	private Choice getChoice() { // 메뉴에 있는 년도
		if (choice == null) {
			choice = new Choice();
//			choice.add("2023");
			choice.add("2022");
//			choice.select(1);
		}
		return choice;
	}

	private Choice getChoice1() { // 메뉴에 있는 월
		if (choice1 == null) {
			choice1 = new Choice();
			choice1.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {

					for (int i = 0; i < 42; i++) {
						bt2[i].setText("");

					}

					year = Integer.parseInt(choice.getSelectedItem());
					month = Integer.parseInt(choice1.getSelectedItem());

					startDay = 0;
					endDay = 0;

					Calendar sDay = java.util.Calendar.getInstance();
					Calendar eDay = java.util.Calendar.getInstance();

					sDay.set(year, month - 1, 1);
					eDay.set(year, month, 1);
					eDay.add(java.util.Calendar.DATE, -1);

					startDay = sDay.get(java.util.Calendar.DAY_OF_WEEK);
					endDay = eDay.get(java.util.Calendar.DATE);

					for (int i = 1; i <= endDay; i++) {
						bt2[i + startDay - 2].setText(i + "");
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
		vo = new SeatVO();
		dao = new SeatDAO();
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
		calp.add(getMenup(), BorderLayout.NORTH);
		calp.add(getMainp(), BorderLayout.CENTER);
		cp.add(calp);
		JPanel timep1 = new JPanel();
		timep1.setLayout(null);
		timep1.setBounds(684, 5, 270, 166);
		panel.add(timep1);

		JLabel two = new JLabel("2\uCE35 1\uAD00");
		two.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
		two.setHorizontalAlignment(SwingConstants.CENTER);
		two.setBounds(207, 10, 57, 15);
		timep1.add(two);

		JPanel twop1 = new JPanel();
		twop1.setBounds(25, 46, 178, 41);
		timep1.add(twop1);
		twop1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel twop2 = new JPanel();
		twop2.setBounds(25, 97, 178, 41);
		timep1.add(twop2);
		twop2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		nextbtn = new JButton("\uC608\uB9E4\uD558\uAE30");
		nextbtn.setFont(new Font("휴먼엑스포", Font.BOLD, 20));
		nextbtn.setBounds(822, 875, 132, 61);
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

		JPanel setp = new JPanel();
		setp.setBounds(50, 159, 574, 250);
		seatp.add(setp);
		setp.setLayout(null);

		JPanel timep2 = new JPanel();
		timep2.setLayout(null);
		timep2.setBounds(684, 176, 270, 166);
		panel.add(timep2);

		JLabel tree1 = new JLabel("3\uCE35 1\uAD00");
		tree1.setHorizontalAlignment(SwingConstants.CENTER);
		tree1.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
		tree1.setBounds(207, 10, 57, 15);
		timep2.add(tree1);

		JPanel treep1 = new JPanel();
		treep1.setBounds(25, 46, 178, 41);
		timep2.add(treep1);
		treep1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel treep2 = new JPanel();
		treep2.setBounds(25, 97, 178, 41);
		timep2.add(treep2);
		treep2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel timep3 = new JPanel();
		timep3.setLayout(null);
		timep3.setBounds(684, 352, 270, 166);
		panel.add(timep3);

		JLabel tree2 = new JLabel("3\uCE35 2\uAD00");
		tree2.setHorizontalAlignment(SwingConstants.CENTER);
		tree2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
		tree2.setBounds(207, 10, 57, 15);
		timep3.add(tree2);

		JPanel treep2_1 = new JPanel();
		treep2_1.setBounds(25, 46, 178, 41);
		timep3.add(treep2_1);
		treep2_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel treep2_2 = new JPanel();
		treep2_2.setBounds(25, 97, 178, 41);
		timep3.add(treep2_2);
		treep2_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel timep4 = new JPanel();
		timep4.setLayout(null);
		timep4.setBounds(684, 528, 270, 166);
		panel.add(timep4);

		JLabel tour1 = new JLabel("4\uCE35 1\uAD00");
		tour1.setHorizontalAlignment(SwingConstants.CENTER);
		tour1.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
		tour1.setBounds(207, 10, 57, 15);
		timep4.add(tour1);

		JPanel fourp1 = new JPanel();
		fourp1.setBounds(25, 46, 178, 41);
		timep4.add(fourp1);
		fourp1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel fourp2 = new JPanel();
		fourp2.setBounds(25, 97, 178, 41);
		timep4.add(fourp2);
		fourp2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel timep5 = new JPanel();
		timep5.setLayout(null);
		timep5.setBounds(684, 704, 270, 166);
		panel.add(timep5);

		JLabel four2 = new JLabel("4\uCE35 2\uAD00");
		four2.setHorizontalAlignment(SwingConstants.CENTER);
		four2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 12));
		four2.setBounds(207, 10, 57, 15);
		timep5.add(four2);

		JPanel fourp2_1 = new JPanel();
		fourp2_1.setBounds(25, 46, 178, 41);
		timep5.add(fourp2_1);
		fourp2_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel fourp2_2 = new JPanel();
		fourp2_2.setBounds(25, 97, 178, 41);
		timep5.add(fourp2_2);
		fourp2_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back.setFont(new Font("휴먼엑스포", Font.BOLD, 20));
		back.setBounds(684, 875, 132, 61);
		panel.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (MovieVO.user.getCinema_name().equals("CGV")) {
					new CGV();
					f.dispose();
				} else {
					new MEGABOX();
					f.dispose();
				}
			}
		});
		bgseat = new ButtonGroup();
		for (int i = 0; i < 24; i++) { // 좌석 버튼 구현 및 그룹 설정
			bt[i] = new JToggleButton(seat[i]);
			setp.add(bt[i]);
			bt[i].setHorizontalAlignment(SwingConstants.CENTER);
			bgseat.add(bt[i]);
//			bt[i].addActionListener(this);
			String myseat = bt[i].getText();
			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals(myseat)) {
						vo.setSeat_number(myseat);
						SeatVO.remember(vo);
					}
				}
			});
		}
		bt[0].setBounds(12, 10, 50, 50);
		bt[1].setBounds(112, 10, 50, 50);
		bt[2].setBounds(212, 10, 50, 50);
		bt[3].setBounds(312, 10, 50, 50);
		bt[4].setBounds(412, 10, 50, 50);
		bt[5].setBounds(512, 10, 50, 50);
		bt[6].setBounds(12, 70, 50, 50);
		bt[7].setBounds(112, 70, 50, 50);
		bt[8].setBounds(212, 70, 50, 50);
		bt[9].setBounds(312, 70, 50, 50);
		bt[10].setBounds(412, 70, 50, 50);
		bt[11].setBounds(512, 70, 50, 50);
		bt[12].setBounds(12, 130, 50, 50);
		bt[13].setBounds(112, 130, 50, 50);
		bt[14].setBounds(212, 130, 50, 50);
		bt[15].setBounds(312, 130, 50, 50);
		bt[16].setBounds(412, 130, 50, 50);
		bt[17].setBounds(512, 130, 50, 50);
		bt[18].setBounds(12, 190, 50, 50);
		bt[19].setBounds(112, 190, 50, 50);
		bt[20].setBounds(212, 190, 50, 50);
		bt[21].setBounds(312, 190, 50, 50);
		bt[22].setBounds(412, 190, 50, 50);
		bt[23].setBounds(512, 190, 50, 50);
		for (int i = 0; i < 20; i++) { // 시간 버튼 구현
			timebt[i] = new JRadioButton(time[i]);
			bgtime.add(timebt[i]);
			String times = timebt[i].getText();
			timebt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals(times)) {
						vo.setTime(times);
					}
				}
			});
		}

		for (int i = 0; i < 2; i++) {
			twop1.add(timebt[i]);
		}
		for (int i = 2; i < 4; i++) {
			twop2.add(timebt[i]);
		}
		for (int i = 4; i < 6; i++) {
			treep1.add(timebt[i]);
		}
		for (int i = 6; i < 8; i++) {
			treep2.add(timebt[i]);
		}
		for (int i = 8; i < 10; i++) {
			treep2_1.add(timebt[i]);
		}
		for (int i = 10; i < 12; i++) {
			treep2_2.add(timebt[i]);
		}
		for (int i = 12; i < 14; i++) {
			fourp1.add(timebt[i]);
		}
		for (int i = 14; i < 16; i++) {
			fourp2.add(timebt[i]);
		}
		for (int i = 16; i < 18; i++) {
			fourp2_1.add(timebt[i]);
		}
		for (int i = 18; i < 20; i++) {
			fourp2_2.add(timebt[i]);
		}
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		nextbtn.addActionListener(this);
		f.setVisible(true); // 창ㄴ ㅏ옴
		f.setLocationRelativeTo(null); // 창이 가운데로
		f.setResizable(false); // 크기변경 x
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icon = tk.getImage("../Movie/src/Image/movieimg.png");
		f.setIconImage(icon);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		
		for (int i = 0; i < 42; i++) { // 일 값
			days = year + "-" + month + "-" + bt2[i].getText();
			if (e.getSource() == bt2[i]) {
				vo.setDay(days);
				SeatVO.remember(vo);
				break;
			}
		}

		if (e.getSource() == nextbtn) {
			if (vo.getDay() == null) {
				JOptionPane.showMessageDialog(null, " 상영 날짜를 선택 해 주세요 ", "", JOptionPane.QUESTION_MESSAGE);
			} else if (SeatVO.user1.getTime() == null) {
				JOptionPane.showMessageDialog(null, " 상영 시간를 선택 해 주세요 ", "", JOptionPane.QUESTION_MESSAGE);
			} else if (SeatVO.user1.getSeat_number() == null) {
				JOptionPane.showMessageDialog(null, " 좌석을 선택 해 주세요 ", "", JOptionPane.QUESTION_MESSAGE);
			} else {

				seatcord = SeatVO.user1.getMovie_cord() + SeatVO.user1.getCinema_cord() + SeatVO.user1.getSeat_number()
						+ SeatVO.user1.getTime();
				vo.setSeat_cord(seatcord);
				SeatVO.remember(vo);
				Boolean b = dao.ticket(SeatVO.user1);
				if (b == true) {
					TicketDAO tdao = new TicketDAO();
					TicketVO tvo = new TicketVO();
					Boolean b1 = tdao.insert(tvo);
					if (b1 == true) {
						new Success();
						f.dispose();
					}
				} else {
					dao.seatinsert();
					Boolean b1 = dao.ticket(SeatVO.user1);
					if (b1 == true) {
						TicketDAO tdao = new TicketDAO();
						TicketVO tvo = new TicketVO();
						Boolean b11 = tdao.insert(tvo);
						if (b11 == true) {
							new Success();
							f.dispose();
						}
					}
				}
			}

		}
	}
}