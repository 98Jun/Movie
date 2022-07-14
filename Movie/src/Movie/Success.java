package Movie;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DAO.TicketDAO;
import VO.TicketVO;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Success {

	private JFrame f;
	private TicketVO vo;
	private TicketDAO dao;
	private JLabel namelable;

	public Success() {
		initialize();
	}

	private void initialize() {
		vo = new TicketVO();
		dao = new TicketDAO();
		TicketVO.re(vo);
		TicketVO.user.setTicketnum(dao.ticket());
		dao.list(TicketVO.user.getTicketnum());
//		System.out.println(dao.id);
		f = new JFrame();
		f.setBounds(100, 100, 550, 700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null); // 창이 가운데로
		f.setResizable(false); // 크기변경 x
		f.getContentPane().setLayout(null);

		JPanel mainp = new JPanel();
		mainp.setBounds(12, 10, 510, 641);
		f.getContentPane().add(mainp);
		mainp.setLayout(null);

		JButton deletebtn = new JButton("\uC608\uB9E4 \uCDE8\uC18C");
		deletebtn.setFont(new Font("굴림", Font.BOLD, 16));
		deletebtn.setBounds(308, 565, 168, 66);
		mainp.add(deletebtn);
		deletebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dao.delete(TicketVO.user.getTicketnum());
				System.out.println("삭제 완료");
				
			}
		});

		JButton retrybtn = new JButton("\uCD94\uAC00 \uC608\uB9E4\uD558\uAE30");
		retrybtn.setFont(new Font("굴림", Font.BOLD, 16));
		retrybtn.setBounds(37, 565, 168, 66);
		mainp.add(retrybtn);

		JPanel p = new JPanel();
		p.setBounds(37, 10, 439, 545);
		mainp.add(p);
		p.setLayout(null);

		JLabel numlable = new JLabel(TicketVO.user.getTicketnum());
		numlable.setHorizontalAlignment(SwingConstants.CENTER);
		numlable.setBounds(30, 345, 382, 31);
		p.add(numlable);

		JLabel idlable = new JLabel(TicketVO.user.getId());
		idlable.setHorizontalAlignment(SwingConstants.CENTER);
		idlable.setBounds(30, 58, 382, 31);
		p.add(idlable);
		namelable = new JLabel(dao.name);
		namelable.setHorizontalAlignment(SwingConstants.CENTER);
		namelable.setBounds(30, 99, 382, 31);
		p.add(namelable);

		JLabel movielable = new JLabel(dao.moviename);
		movielable.setHorizontalAlignment(SwingConstants.CENTER);
		movielable.setBounds(30, 140, 382, 31);
		p.add(movielable);

		JLabel cinemanamelable = new JLabel(dao.cinemaname);
		cinemanamelable.setHorizontalAlignment(SwingConstants.CENTER);
		cinemanamelable.setBounds(30, 181, 382, 31);
		p.add(cinemanamelable);

		JLabel cinemalocationlable = new JLabel(dao.cinemalocation);
		cinemalocationlable.setHorizontalAlignment(SwingConstants.CENTER);
		cinemalocationlable.setBounds(30, 222, 382, 31);
		p.add(cinemalocationlable);

		JLabel seatlable = new JLabel(dao.seatnum);
		seatlable.setHorizontalAlignment(SwingConstants.CENTER);
		seatlable.setBounds(30, 263, 382, 31);
		p.add(seatlable);

		JLabel pricelable = new JLabel(dao.price);
		pricelable.setHorizontalAlignment(SwingConstants.CENTER);
		pricelable.setBounds(30, 304, 382, 31);
		p.add(pricelable);

		JLabel daylable = new JLabel(dao.day);
		daylable.setHorizontalAlignment(SwingConstants.CENTER);
		daylable.setBounds(30, 386, 382, 31);
		p.add(daylable);

		JLabel timelable = new JLabel(dao.time);
		timelable.setHorizontalAlignment(SwingConstants.CENTER);
		timelable.setBounds(30, 427, 382, 31);
		p.add(timelable);
		f.setVisible(true); // 실행
//		System.out.println(vo.toString());
		retrybtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MovieFrame();
				f.dispose();
			}
		});
	}
}
