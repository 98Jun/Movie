package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import VO.HoewonVO;

public class HoewonDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";
	 Connection con;
	private PreparedStatement pstmt;
	ResultSet rs;

	public boolean insertData(HoewonVO vo) {
		String sql ;

		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "insert into login(id,pw,name) ";
			sql += "values(?,?,?)";
			pstmt =con.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return true;
		
	}

	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = null;
			System.out.println("jdbc driver loading success.");
			System.out.println("oracle connection success.\n");
			System.out.println("Preparedstatement create success.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public boolean list(HoewonVO vo) {
//		return false;
//	}
}
