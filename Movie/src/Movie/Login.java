package Movie;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // 버튼을 눌럿을 떄 

				if (idtf.getText().equals("")) { // 
					new FailText();
				} else if (pwtf.getText().equals("")) {
					new FailText();
				} else {
					UserVO vo = new UserVO(idtf.getText(), pwtf.getText()); // 디비에 있던 거랑 비교 
					boolean b = dao.list(vo);
					if (b == true) {
						new MovieFrame();
						f.dispose();
					} else 
						new FailText();
					
				}
			}
		});
		JButton hoewonbtn = new JButton("회원가입");
		hoewonbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Hoewon();
				
			}
		});
		loginbtn.setBounds(273, 26, 97, 65);
		p1.add(loginbtn);

		
		hoewonbtn.setBounds(273, 112, 97, 23);
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
