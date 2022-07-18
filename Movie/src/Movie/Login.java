package Movie;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import DAO.UserDAO;
import VO.UserVO;

public class Login {

	private JFrame f;
	private JLabel namelabel;
	private JTextField idtf;
	private JTextField pwtf;
	private UserDAO dao;

	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// LookAndFeel Windows 스타일 적용
//			SwingUtilities.updateComponentTreeUI(f);
//		} catch (Exception e) {
//			
//		}
		dao = new UserDAO();
		f = new JFrame();
		f.getContentPane().setFont(new Font("새굴림", Font.PLAIN, 12));
		f.setFont(new Font("새굴림", Font.PLAIN, 12));
		f.setBounds(100, 100, 450, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);

		JPanel p = new JPanel();
		p.setBounds(12, 10, 410, 76);
		f.getContentPane().add(p);
		p.setLayout(null);

		namelabel = new JLabel("Movie Cord");
		namelabel.setFont(new Font("휴먼엑스포", Font.BOLD, 46));
		namelabel.setHorizontalAlignment(JLabel.CENTER);
		namelabel.setBounds(12, 10, 386, 56);
		p.add(namelabel);

		JPanel p1 = new JPanel();
		p1.setBounds(12, 106, 410, 145);
		f.getContentPane().add(p1);
		p1.setLayout(null);
		JButton loginbtn = new JButton("로그인");
		loginbtn.setFont(new Font("굴림", Font.BOLD, 12));
		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // 버튼을 눌럿을 떄

				if (idtf.getText().equals("")) { //
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요. ", "", JOptionPane.ERROR_MESSAGE);
				} else if (pwtf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.", "", JOptionPane.ERROR_MESSAGE);
				} else {
					UserVO vo = new UserVO(idtf.getText(), pwtf.getText()); // 디비에 있던 거랑 비교
					boolean b = dao.list(vo);
					if (b == true) {
						vo.setId(idtf.getText());
						UserVO.r(vo);
//						System.out.println(UserVO.user.getId());
						new MovieFrame();
						f.dispose();
					} else 
						JOptionPane.showMessageDialog(null, "다시 입력 해 주세요.", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		JButton hoewonbtn = new JButton("회원가입");
		hoewonbtn.setFont(new Font("굴림", Font.BOLD, 12));
		hoewonbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Hoewon();

			}
		});
		loginbtn.setBounds(273, 26, 97, 65);
		p1.add(loginbtn);

		hoewonbtn.setBounds(273, 112, 97, 25);
		p1.add(hoewonbtn);

		idtf = new JTextField();
		idtf.setBounds(65, 27, 167, 21);
		p1.add(idtf);
		idtf.setColumns(10);

		pwtf = new JPasswordField();
		pwtf.setColumns(10);
		pwtf.setBounds(65, 70, 167, 21);
//		pwtf.setEchoChar('*');
		p1.add(pwtf);

		JLabel idlabel = new JLabel("ID");
		idlabel.setBounds(12, 32, 57, 15);
		idlabel.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		p1.add(idlabel);

		JLabel pwlabel = new JLabel("PW");
		pwlabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwlabel.setBounds(12, 73, 57, 15);
		p1.add(pwlabel);
		f.setVisible(true);
		f.setLocationRelativeTo(null); // 창이 가운데로
		f.setResizable(false); // 크기변경 x
	}

}
