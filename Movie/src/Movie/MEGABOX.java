package Movie;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.MovieDAO;
import VO.MovieVO;

public class MEGABOX implements ListSelectionListener {

	private JFrame f;
	private MovieDAO dao;
	private String[] cols;
	private JList<?> list;
	private MovieVO vo;

	public MEGABOX() {
		initialize();
	}

	private void initialize() {
		f = new JFrame("MEGABOX");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		JPanel mainp = new JPanel();
		mainp.setLayout(null);
		mainp.setBackground(new Color(240, 248, 255));
		mainp.setBounds(0, 0, 484, 461);
		f.getContentPane().add(mainp);

		dao = new MovieDAO();
		vo = new MovieVO();
		cols = dao.Movielocation(vo);
		list = new JList<String>(cols);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(12, 91, 460, 360);
		list.setFixedCellHeight(40);
		mainp.add(list);

		JLabel Megaboxlabel = new JLabel("MEGABOX");
		Megaboxlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Megaboxlabel.setForeground(new Color(153, 50, 204));
		Megaboxlabel.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 42));
		Megaboxlabel.setBackground(Color.LIGHT_GRAY);
		Megaboxlabel.setBounds(12, 10, 460, 71);
		mainp.add(Megaboxlabel);
		f.setVisible(true);
		f.setLocationRelativeTo(null); // 창이 가운데로
		f.setResizable(false); // 크기변경 x
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
		list.addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		String name = "";
		int num = 1;
		String mcord = MovieVO.user.getMovie_cord();
		for (int i = 0; i < cols.length; i++) {
			if (list.getSelectedIndex() == i) {
				name = cols[i];
				MovieVO.user.setCinema_location(name);
//				System.out.println("user의 정보 : " + MovieVO.user.toString());
			}
		}
		for (int j = 1; j <= 6; j++) { // 무비코드
			String j2 = Integer.toString(j);
			if (mcord.equals(j2) && name.equals("분당")) { // 분당 시네마넘버
				num = 48;
				for (num = 48; num <= 53; num++) {
					if (num - 47 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("수원")) { // 시네마넘버
				num = 54;
				for (num = 54; num <= 59; num++) {
					if (num - 53 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("홍대")) { // 홍대 시네마넘버
				num = 60;
				for (num = 60; num <= 65; num++) {
					if (num - 59 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("신촌")) { // 신촌 시네마넘버
				num = 66;
				for (num = 66; num <= 71; num++) {
					if (num - 65 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("강동")) {// 강동 시네마넘버
				num = 72;
				for (num = 72; num <= 77; num++) {
					if (num - 71 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("양주")) { // 양주 시네마넘버
				num = 78;
				for (num = 78; num <= 83; num++) {
					if (num - 77 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("창동")) { // 창동 시네마넘버
				num = 84;
				for (num = 84; num <= 89; num++) {
					if (num - 83 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("별내")) { // 별내 시네마넘버
				num = 90;
				for (num = 90; num <= 95; num++) {
					if (num - 89 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
		}
	}

}
