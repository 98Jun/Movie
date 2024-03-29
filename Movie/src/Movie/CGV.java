package Movie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class CGV implements ListSelectionListener {

	private JFrame f;
	private MovieDAO dao;
	private String[] cols;
	private MovieVO vo;
	private JList<String> list;

	public CGV() {
		initialize();
	}

	private void initialize() {
		f = new JFrame("CGV");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icon = tk.getImage("../Movie/src/Image/CGV.png");
		f.setIconImage(icon);
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		JPanel mainp = new JPanel();
		mainp.setBackground(Color.LIGHT_GRAY);
		mainp.setBounds(0, 0, 484, 461);
		f.getContentPane().add(mainp);
		mainp.setLayout(null);

		JLabel CGV = new JLabel("CGV");
		CGV.setBackground(Color.LIGHT_GRAY);
		CGV.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 42));
		CGV.setForeground(new Color(204, 0, 0));
		CGV.setHorizontalAlignment(SwingConstants.CENTER);
		CGV.setBounds(12, 10, 460, 71);
		mainp.add(CGV);
		dao = new MovieDAO();
		vo = new MovieVO();
		cols = dao.Movielocation(vo);
		list = new JList<String>(cols);
		list.setFont(new Font("휴먼엑스포", Font.BOLD, 30));
		list.setCellRenderer(new DefaultListCellRenderer() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public int getHorizontalAlignment() {
				return CENTER;
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 목록 중 하나만 선택 가능
		list.setBounds(12, 91, 460, 360);
		mainp.add(list);

		ImageIcon backbt = new ImageIcon("../Movie/src/Image/backbt2.png");
		JButton back = new JButton(backbt);
		back.setBounds(12, 10, 81, 50);
		back.setBackground(Color.LIGHT_GRAY);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		mainp.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MovieFrame();
				f.dispose();
			}
		});
		list.setFixedCellHeight(40);
//			DefaultListCellRenderer center = new DefaultListCellRenderer();
//			center.setHorizontalAlignment(SwingConstants.CENTER);
//			list.add(center);
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
//				System.out.println("user의 정보 : " + MovieVO.user.toString()); // 정보 확인
//				new Ticketing();
//				f.dispose();
			}
		}
		for (int j = 1; j <= 6; j++) { // 무비코드
			String j2 = Integer.toString(j);
			if (mcord.equals(j2) && name.equals("서현")) { // 무비코드가 ~ 서현 과 맞을때
				num = 1;
				for (num = 1; num <= 6; num++) {
					if (num == j) {
						MovieVO.user.setCinema_cord("c" + num);
//						System.out.println("user의 정보 : " + MovieVO.user.toString()); // 들어갓는지 확인..
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("야탑")) {
				num = 7;
				for (num = 7; num <= 11; num++) {
					if (num - 6 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("동탄")) {
				num = 12;
				for (num = 12; num <= 17; num++) {
					if (num - 11 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("기흥")) {
				num = 18;
				for (num = 18; num <= 23; num++) {
					if (num - 17 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("수유")) {
				num = 24;
				for (num = 24; num <= 29; num++) {
					if (num - 23 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("강남")) {
				num = 30;
				for (num = 30; num <= 35; num++) {
					if (num - 29 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("동대문")) {
				num = 36;
				for (num = 36; num <= 41; num++) {
					if (num - 35 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
			if (mcord.equals(j2) && name.equals("명동")) {
				num = 42;
				for (num = 42; num <= 47; num++) {
					if (num - 41 == j) {
						MovieVO.user.setCinema_cord("c" + num);
						new Ticketing();
						f.dispose();
					}
				}
			}
		}
	}

}
