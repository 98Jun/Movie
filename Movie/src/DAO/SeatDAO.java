package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
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
	private PreparedStatement pstmt;
	public boolean ticket(SeatVO vo) {
		try {
			connDB();
//			System.out.println("연결 완료");
			String sql = "SELECT * " + " FROM SEAT s" + " WHERE s.SEAT_NUMBER = " + "'" + vo.getSeat_number() + "'"
					+ "and s.CINEMA_CORD = " + "'" + vo.getCinema_cord() + "'" + "and s.MOVIE_CORD = " + "'"
					+ vo.getMovie_cord() + "'" + "and s.DAY = " + "'" + vo.getDay() + "'" + "and s.TIME = " + "'"
					+ vo.getTime() + "'" + "and s.SEAT_CORD = " + "'" + vo.getSeat_cord() + "'";
			rs = stmt.executeQuery(sql);
			rs.last();
			if (rs.getRow() == 0) {
//				
				return false;
			} else
				return true;
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
	public void seatinsert() {
		try {
			connDB();
			String sql1 = "insert into seat(seat_number,cinema_cord,movie_cord,day,time,seat_cord) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, SeatVO.user1.getSeat_number());
			pstmt.setString(2, SeatVO.user1.getCinema_cord());
			pstmt.setString(3, SeatVO.user1.getMovie_cord());
			pstmt.setString(4, SeatVO.user1.getDay());
			pstmt.setString(5, SeatVO.user1.getTime());
			pstmt.setString(6, SeatVO.user1.getSeat_cord());
			pstmt.executeUpdate();
			pstmt.close();
//			System.out.println("돌아가는 중");
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			if (con != null) {
				con = null;
			}
			if (pstmt != null) {
				pstmt = null;
			}
		}
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
