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

	public boolean insertData(HoewonVO vo) {
		String sql;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "insert into login(id,pw,name) ";
			sql += "values(?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "빈칸을 모두 입력 해 주세요", "", JOptionPane.ERROR_MESSAGE);
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
