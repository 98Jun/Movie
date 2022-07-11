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
	private JList<String> list;
	private MovieVO vo;

	public MEGABOX() {
		initialize();
	}

	private void initialize() {
		f = new JFrame("MEGABOX");
		f.setBounds(100, 100, 500, 500);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		JPanel mainp = new JPanel();
		mainp.setLayout(null);
		mainp.setBackground(new Color(240, 248, 255));
		mainp.setBounds(0, 0, 484, 461);
		f.getContentPane().add(mainp);

		dao = new MovieDAO();
		vo = new MovieVO();
//		MovieVO.remember(vo);
		cols = dao.Movielocation(vo);
		System.out.println(cols.length);
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
