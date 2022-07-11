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
		f.setBounds(100, 100, 500, 500);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
//		MovieVO.remember(vo);
		cols = dao.Movielocation(vo);
		System.out.println(cols.length);
		list = new JList<String>(cols);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 목록 중 하나만 선택 가능
		list.setBounds(12, 91, 460, 360);
		mainp.add(list);
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

		for (int i = 0; i < cols.length; i++) {
			if (list.getSelectedIndex() == i) {
				String name = cols[i];
				MovieVO.re.setCinema_location(name);
				System.out.println("re의 위치 : " + MovieVO.re.getCinema_location());
				System.out.println(MovieVO.re.toString());
			}
		}
	}

}
