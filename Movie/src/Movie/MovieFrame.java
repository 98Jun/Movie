package Movie;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import DAO.MovieDAO;
import VO.MovieVO;

public class MovieFrame implements ActionListener {
	private JButton witch2cgv, witch2megabox, city2cgv, city2megabox, wordcgv, wordmegabox, brocgv, bromegabox, topcgv,
			topmegabox, bscgv, bsmegabox;
	private ImageIcon imgcgv = new ImageIcon("../Movie/src/Image/CGV.png");
	private ImageIcon imgmegabox = new ImageIcon("../Movie/src/Image/mega.png");
	private MovieDAO dao;
	private JFrame f;

	public MovieFrame() {

		dao = new MovieDAO();
		f = new JFrame("영화 선택");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.setVisible(false);
			}
		});
		f.setSize(1000, 1000);
		f.getContentPane().setLayout(null);
		witch2cgv = new JButton(imgcgv);
		witch2cgv.setBorderPainted(false);
		witch2cgv.setBounds(120, 410, 51, 51);
		witch2cgv.setBackground(Color.LIGHT_GRAY);
		witch2cgv.setOpaque(false); // 라벨 배경색 투명
		witch2cgv.setBorderPainted(false);
		witch2cgv.setFocusPainted(false);
		witch2megabox = new JButton(imgmegabox);
		witch2megabox.setBorderPainted(false);
		witch2megabox.setBounds(220, 410, 51, 51);
		witch2megabox.setBackground(Color.DARK_GRAY);
		witch2megabox.setBorderPainted(false);
		witch2megabox.setFocusPainted(false);

		city2cgv = new JButton(imgcgv);
		city2cgv.setBorderPainted(false);
		city2cgv.setBounds(430, 410, 51, 51);
		city2megabox = new JButton(imgmegabox);
		city2megabox.setBackground(Color.DARK_GRAY);
		city2megabox.setBorderPainted(false);
		city2megabox.setBounds(530, 410, 51, 51);

		wordcgv = new JButton(imgcgv);
		wordcgv.setBorderPainted(false);
		wordcgv.setBounds(730, 410, 51, 51);
		wordmegabox = new JButton(imgmegabox);
		wordmegabox.setBackground(Color.DARK_GRAY);
		wordmegabox.setBorderPainted(false);
		wordmegabox.setBounds(830, 410, 51, 51);
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 위 		
		brocgv = new JButton(imgcgv);
		brocgv.setBorderPainted(false);
		brocgv.setBounds(120, 860, 51, 51);
		brocgv.setOpaque(false); // 라벨 배경색 투명
		bromegabox = new JButton(imgmegabox);
		bromegabox.setBorderPainted(false);
		bromegabox.setBounds(220, 860, 51, 51);
		bromegabox.setBackground(Color.DARK_GRAY);

		topcgv = new JButton(imgcgv);
		topcgv.setBorderPainted(false);
		topcgv.setBounds(430, 860, 51, 51);
		topmegabox = new JButton(imgmegabox);
		topmegabox.setBackground(Color.DARK_GRAY);
		topmegabox.setBorderPainted(false);
		topmegabox.setBounds(530, 860, 51, 51);

		bscgv = new JButton(imgcgv);
		bscgv.setBorderPainted(false);
		bscgv.setBounds(730, 860, 51, 51);
		bsmegabox = new JButton(imgmegabox);
		bsmegabox.setBackground(Color.DARK_GRAY);
		bsmegabox.setBorderPainted(false);
		bsmegabox.setBounds(830, 860, 51, 51);
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 아래

		ImgPanel1 p1 = new ImgPanel1();
		ImgPanel2 p2 = new ImgPanel2();
		ImgPanel3 p3 = new ImgPanel3();
		ImgPanel4 p4 = new ImgPanel4();
		ImgPanel5 p5 = new ImgPanel5();
		ImgPanel6 p6 = new ImgPanel6();

		p1.setLayout(null);
		p1.setBounds(100, 100, 200, 300);

		p2.setLayout(null);
		p2.setBounds(400, 100, 200, 300);

		p3.setLayout(null);
		p3.setBounds(700, 100, 200, 300);

		p4.setLayout(null);
		p4.setBounds(100, 550, 200, 300);

		p5.setLayout(null);
		p5.setBounds(400, 550, 200, 300);

		p6.setLayout(null);
		p6.setBounds(700, 550, 200, 300);

		f.setBackground(Color.DARK_GRAY);
		f.getContentPane().add(p1);

		f.getContentPane().add(witch2cgv);
		f.getContentPane().add(witch2megabox);
		f.getContentPane().add(city2megabox);
		f.getContentPane().add(city2cgv);
		f.getContentPane().add(wordmegabox);
		f.getContentPane().add(wordcgv);
		f.getContentPane().add(brocgv);
		f.getContentPane().add(bromegabox);
		f.getContentPane().add(topmegabox);
		f.getContentPane().add(topcgv);
		f.getContentPane().add(bsmegabox);
		f.getContentPane().add(bscgv);

		f.getContentPane().add(p2);
		f.getContentPane().add(p3);
		f.getContentPane().add(p4);
		f.getContentPane().add(p5);
		f.getContentPane().add(p6);
		f.setLocationRelativeTo(null); // 창이 가운데로
		f.setResizable(false); // 크기변경 x
		f.setVisible(true); // 실앻ㅇ

		witch2cgv.addActionListener(this);
		city2cgv.addActionListener(this);
		wordcgv.addActionListener(this);
		brocgv.addActionListener(this);
		topcgv.addActionListener(this);
		bscgv.addActionListener(this);
		witch2megabox.addActionListener(this);
		city2megabox.addActionListener(this);
		wordmegabox.addActionListener(this);
		bromegabox.addActionListener(this);
		topmegabox.addActionListener(this);
		bsmegabox.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MovieVO vo = new MovieVO();
		dao.insertData(vo);
		if (e.getSource() == witch2cgv) {
			vo = new MovieVO("1", "CGV");
			MovieVO.remember(vo); // user 에 선언한 vo 코드 입력
//			System.out.println(MovieVO.user.toString());

		} else if (e.getSource() == city2cgv) {
			vo = new MovieVO("2", "CGV");
			MovieVO.remember(vo);

		} else if (e.getSource() == wordcgv) {
			vo = new MovieVO("3", "CGV");
			MovieVO.remember(vo);

		} else if (e.getSource() == brocgv) {
			vo = new MovieVO("4", "CGV");
			MovieVO.remember(vo);

		} else if (e.getSource() == topcgv) {
			vo = new MovieVO("5", "CGV");
			MovieVO.remember(vo);

		} else if (e.getSource() == bscgv) {
			vo = new MovieVO("6", "CGV");
			MovieVO.remember(vo);

		} else if (e.getSource() == witch2megabox) { //// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ megabox
			vo = new MovieVO("1", "MEGABOX");
			MovieVO.remember(vo);

		} else if (e.getSource() == city2megabox) {
			vo = new MovieVO("2", "MEGABOX");
			MovieVO.remember(vo);

		} else if (e.getSource() == wordmegabox) {
			vo = new MovieVO("3", "MEGABOX");
			MovieVO.remember(vo);

		} else if (e.getSource() == topmegabox) {
			vo = new MovieVO("4", "MEGABOX");
			MovieVO.remember(vo);

		} else if (e.getSource() == bromegabox) {
			vo = new MovieVO("5", "MEGABOX");
			MovieVO.remember(vo);

		} else if (e.getSource() == bsmegabox) {
			vo = new MovieVO("6", "MEGABOX");
			MovieVO.remember(vo);
		}

		if (vo.getCinema_name().equals("CGV")) {
			new CGV();
			f.dispose();
		} else if (vo.getCinema_name().equals("MEGABOX")) {
			new MEGABOX();
			f.dispose();
		}

	}
}