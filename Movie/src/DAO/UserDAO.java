package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import VO.UserVO;

public class UserDAO {
	// DAO 데이터 베이스 작업만 수행하는 클래스
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##green";
	private String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public UserDAO() {
		connDB();
	}
	public boolean list(UserVO p) {
		try {

			String query = "SELECT * FROM login WHERE id='" + p.getId() + "' AND pw='" + p.getPassword() + "'";
			rs = stmt.executeQuery(query);
			rs.last(); 

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs = null;
			if (con != null)
				con = null;
			if (stmt != null)
				stmt = null;
		}
		return false;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
