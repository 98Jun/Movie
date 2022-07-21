package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import VO.HoewonVO;

public class HoewonDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##green";
	private String password = "green1234";
	private Connection con;
	private PreparedStatement pstmt;
	public HoewonDAO() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean insertData(HoewonVO vo) {
		String sql;

		try {

			sql = "insert into login(id,pw,name) ";
			sql += "values(?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			if (vo.getId().equals("")) {
				JOptionPane.showMessageDialog(null, "아이디를 입력 해 주세요", "", JOptionPane.ERROR_MESSAGE);
			} else if (vo.getPw().equals("")) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력 해 주세요", "", JOptionPane.ERROR_MESSAGE);
			} else if (vo.getName().equals("")) {
				JOptionPane.showMessageDialog(null, "이름을 입력 해 주세요", "", JOptionPane.ERROR_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "이 아이디는 사용 중 입니다.", "", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			if (con != null) {
				con = null;
			}
			if (pstmt != null) {
				pstmt = null;
			}
		}
		return true;

	}

}
