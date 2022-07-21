package Movie;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DAO.TicketDAO;
import VO.TicketVO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		f = new JFrame("영화 티켓");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icon = tk.getImage("../Movie/src/Image/movieimg.png");
		f.setIconImage(icon);
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

				JOptionPane.showMessageDialog(null, "예매가 취소되었습니다", "", JOptionPane.INFORMATION_MESSAGE);
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
		numlable.setFont(new Font("Dialog", Font.BOLD, 19));
		numlable.setHorizontalAlignment(SwingConstants.CENTER);
		numlable.setBounds(154, 365, 273, 31);
		p.add(numlable);

		JLabel idlable = new JLabel(dao.getId());
		idlable.setFont(new Font("Dialog", Font.BOLD, 19));
		idlable.setHorizontalAlignment(SwingConstants.CENTER);
		idlable.setBounds(154, 78, 273, 31);
		p.add(idlable);
		namelable = new JLabel(dao.getName());
		namelable.setFont(new Font("Dialog", Font.BOLD, 19));
		namelable.setHorizontalAlignment(SwingConstants.CENTER);
		namelable.setBounds(154, 119, 273, 31);
		p.add(namelable);

		JLabel movielable = new JLabel(dao.getMoviename());
		movielable.setFont(new Font("Dialog", Font.BOLD, 19));
		movielable.setHorizontalAlignment(SwingConstants.CENTER);
		movielable.setBounds(154, 160, 273, 31);
		p.add(movielable);

		JLabel cinemanamelable = new JLabel(dao.getCinemaname());
		cinemanamelable.setFont(new Font("Dialog", Font.BOLD, 19));
		cinemanamelable.setHorizontalAlignment(SwingConstants.CENTER);
		cinemanamelable.setBounds(154, 201, 273, 31);
		p.add(cinemanamelable);

		JLabel cinemalocationlable = new JLabel(dao.getCinemalocation());
		cinemalocationlable.setFont(new Font("Dialog", Font.BOLD, 19));
		cinemalocationlable.setHorizontalAlignment(SwingConstants.CENTER);
		cinemalocationlable.setBounds(154, 242, 273, 31);
		p.add(cinemalocationlable);

		JLabel seatlable = new JLabel(dao.getSeatnum());
		seatlable.setFont(new Font("Dialog", Font.BOLD, 19));
		seatlable.setHorizontalAlignment(SwingConstants.CENTER);
		seatlable.setBounds(154, 283, 273, 31);
		p.add(seatlable);

		JLabel pricelable = new JLabel(dao.getPrice() + " 원");
		pricelable.setFont(new Font("Dialog", Font.BOLD, 19));
		pricelable.setHorizontalAlignment(SwingConstants.CENTER);
		pricelable.setBounds(154, 324, 273, 31);
		p.add(pricelable);

		JLabel daylable = new JLabel(dao.getDay());
		daylable.setFont(new Font("Dialog", Font.BOLD, 19));
		daylable.setHorizontalAlignment(SwingConstants.CENTER);
		daylable.setBounds(154, 406, 273, 31);
		p.add(daylable);

		JLabel timelable = new JLabel(dao.getTime());
		timelable.setFont(new Font("Dialog", Font.BOLD, 19));
		timelable.setHorizontalAlignment(SwingConstants.CENTER);
		timelable.setBounds(154, 447, 273, 31);
		p.add(timelable);

		JLabel lblNewLabel = new JLabel("\uC601\uD654 \uC785\uC7A5\uAD8C / \uC601\uC218\uC99D \uACB8\uC6A9");
		lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 439, 38);
		p.add(lblNewLabel);

		JLabel idl = new JLabel("ID : ");
		idl.setHorizontalAlignment(SwingConstants.LEFT);
		idl.setFont(new Font("Dialog", Font.BOLD, 19));
		idl.setBounds(77, 78, 88, 31);
		p.add(idl);

		JLabel namel = new JLabel("\uD68C\uC6D0 \uC774\uB984 : ");
		namel.setHorizontalAlignment(SwingConstants.LEFT);
		namel.setFont(new Font("Dialog", Font.BOLD, 19));
		namel.setBounds(77, 119, 105, 31);
		p.add(namel);

		JLabel movienamel = new JLabel("\uC601\uD654 \uC81C\uBAA9 : ");
		movienamel.setHorizontalAlignment(SwingConstants.LEFT);
		movienamel.setFont(new Font("Dialog", Font.BOLD, 19));
		movienamel.setBounds(77, 160, 105, 31);
		p.add(movienamel);

		JLabel cinemanamel = new JLabel("\uADF9\uC7A5 \uBE0C\uB79C\uB4DC :");
		cinemanamel.setHorizontalAlignment(SwingConstants.LEFT);
		cinemanamel.setFont(new Font("Dialog", Font.BOLD, 19));
		cinemanamel.setBounds(77, 201, 115, 31);
		p.add(cinemanamel);

		JLabel idlable_1_4 = new JLabel("\uC0C1\uC601\uAD00 : ");
		idlable_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		idlable_1_4.setFont(new Font("Dialog", Font.BOLD, 19));
		idlable_1_4.setBounds(77, 242, 88, 31);
		p.add(idlable_1_4);

		JLabel seatl = new JLabel("\uC88C\uC11D  :");
		seatl.setHorizontalAlignment(SwingConstants.LEFT);
		seatl.setFont(new Font("Dialog", Font.BOLD, 19));
		seatl.setBounds(77, 283, 88, 31);
		p.add(seatl);

		JLabel pricel = new JLabel("\uAE08\uC561 :");
		pricel.setHorizontalAlignment(SwingConstants.LEFT);
		pricel.setFont(new Font("Dialog", Font.BOLD, 19));
		pricel.setBounds(77, 324, 88, 31);
		p.add(pricel);

		JLabel numl = new JLabel("\uC608\uB9E4 \uBC88\uD638 :");
		numl.setHorizontalAlignment(SwingConstants.LEFT);
		numl.setFont(new Font("Dialog", Font.BOLD, 19));
		numl.setBounds(77, 365, 105, 31);
		p.add(numl);

		JLabel dayl = new JLabel("\uC0C1\uC601 \uC77C\uC2DC :");
		dayl.setHorizontalAlignment(SwingConstants.LEFT);
		dayl.setFont(new Font("Dialog", Font.BOLD, 19));
		dayl.setBounds(77, 406, 105, 31);
		p.add(dayl);

		JLabel timel = new JLabel("\uC0C1\uC601 \uC2DC\uC791\uC2DC\uAC04 : ");
		timel.setHorizontalAlignment(SwingConstants.LEFT);
		timel.setFont(new Font("Dialog", Font.BOLD, 19));
		timel.setBounds(77, 447, 140, 31);
		p.add(timel);
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
