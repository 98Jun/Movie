package Movie;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.HoewonDAO;
import VO.HoewonVO;

public class Hoewon {

	private JFrame f;
	private JTextField tfid;
	private JTextField tfpw;
	private JTextField tfpw1;
	private JTextField tfname;
	private HoewonDAO dao;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Hoewon() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		dao = new HoewonDAO();

		f = new JFrame("회원가입");
		f.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		f.setBounds(100, 100, 327, 375);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.setVisible(false);
			}
		});
		f.getContentPane().setLayout(null);

		JButton okbtn = new JButton("가입?");
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b1 = tfpw.getText().equals(tfpw1.getText());
				if (b1 == true) {
					HoewonVO vo = new HoewonVO(tfid.getText(), tfpw.getText(), tfname.getText());

					boolean b = dao.insertData(vo);

					if (b == true) {
						JOptionPane.showMessageDialog(null, "가입을 축하합니다 ! ", "", JOptionPane.PLAIN_MESSAGE);
						f.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다. ", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		okbtn.setFont(new Font("새굴림", Font.PLAIN, 12));
		okbtn.setBounds(157, 254, 97, 23);
		f.getContentPane().add(okbtn);

		JButton closebtn = new JButton("\uCDE8\uC18C");
		closebtn.setFont(new Font("새굴림", Font.PLAIN, 12));
		closebtn.setBounds(37, 254, 97, 23);
		f.getContentPane().add(closebtn);

		JPanel p = new JPanel();
		p.setBounds(12, 10, 287, 226);
		f.getContentPane().add(p);
		p.setLayout(null);

		tfid = new JTextField();
		tfid.setBounds(12, 23, 116, 21);
		p.add(tfid);
		tfid.setColumns(10);

		tfpw = new JPasswordField();
		tfpw.setColumns(10);
		tfpw.setBounds(12, 73, 116, 21);
		p.add(tfpw);

		tfpw1 = new JPasswordField();
		tfpw1.setColumns(10);
		tfpw1.setBounds(12, 114, 116, 21);
		p.add(tfpw1);

		tfname = new JTextField();
		tfname.setColumns(10);
		tfname.setBounds(12, 159, 116, 21);
		p.add(tfname);

		JLabel idlabel = new JLabel("\uC544\uC774\uB514");
		idlabel.setFont(new Font("새굴림", Font.PLAIN, 12));
		idlabel.setBounds(160, 26, 57, 15);
		p.add(idlabel);

		JLabel pwlabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwlabel.setFont(new Font("새굴림", Font.PLAIN, 12));
		pwlabel.setBounds(160, 76, 57, 15);
		p.add(pwlabel);

		JLabel pw1label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		pw1label.setFont(new Font("새굴림", Font.PLAIN, 12));
		pw1label.setBounds(160, 117, 76, 15);
		p.add(pw1label);

		JLabel namelabel = new JLabel("\uC774\uB984");
		namelabel.setFont(new Font("새굴림", Font.PLAIN, 12));
		namelabel.setBounds(160, 162, 57, 15);
		p.add(namelabel);
		f.setVisible(true);
		f.setLocationRelativeTo(null); // 창이 가운데로
		f.setResizable(false); // 크기변경 x

		closebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
			}
		});
	}
}
