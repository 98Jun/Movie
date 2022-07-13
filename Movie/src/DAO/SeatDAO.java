package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import VO.SeatVO;

public class SeatDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##green";
	private String password = "green1234";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public boolean ticket(SeatVO vo) {
		try {
			connDB();
			System.out.println("연결 완료");
			String sql = "SELECT * " + " FROM SEAT s" + " WHERE s.SEAT_NUMBER = " + "'" + vo.getSeat_number() + "'"
					+ "and s.CINEMA_CORD = " + "'" + vo.getCinema_cord() + "'" + "and s.MOVIE_CORD = " + "'"
					+ vo.getMovie_cord() + "'" + "and s.DAY = " + "'" + vo.getDay() + "'" + "and s.TIME = " + "'"
					+ vo.getTime() + "'" + "and s.SEAT_CORD = " + "'" + vo.getSeat_cord() + "'";
			rs = stmt.executeQuery(sql);
			rs.last();
			if (rs.getRow() == 0) {
//				System.out.println("0 row selected...");
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
//			System.out.println("oracle connection success.\n");
//			System.out.println("jdbc driver loading success.");
//			System.out.println("statement create success.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
