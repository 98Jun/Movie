package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import VO.UserVO;

public class UserDAO {
	// DAO 데이터 베이스 작업만 수행하는 클래스 
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public boolean list(UserVO p) {
		try {
			connDB();
			
			String query = "SELECT * FROM login WHERE id='" + p.getId()
			+ "' AND pw='" + p.getPassword() + "'";
//			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last(); // 뭔지모름 .. 
//			System.out.println("rs.getRow() : " + rs.getRow());
			
			if(rs.getRow() == 0) {
//				System.out.println("0 row selected...");
			}else {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) 
				rs = null;
			if(con!=null)
				con=null;
			if(stmt!=null)
				stmt=null;
		}
		return false;
	}
	
	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			System.out.println("oracle connection success.\n");
//			System.out.println("jdbc driver loading success.");
//			System.out.println("statement create success.\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
