package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import VO.MovieVO;

public class MovieDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##green";
	private String password = "green1234";
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	String code;
	String cname;
	
	public MovieDAO() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insertData(MovieVO vo) {
		String sql;

		try {
			sql = "SELECT c.CINEMA_NAME, c.MOVIE_CORD" + " FROM CINEMA c" + " WHERE c.MOVIE_CORD =" + "'"
					+ vo.getMovie_cord() + "'" + "  AND c.CINEMA_NAME =" + "'" + "¾öÁØ½Ä" + "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				code = rs.getString(2);
				cname = rs.getString(3);
				vo = new MovieVO(rs.getString(2), rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
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

	public String[] Movielocation(MovieVO vo) {
		String name;
		String[] cols = new String[8];
		int i = 0;
		try {

			String sql = "SELECT c.CINEMA_LOCATION " + " FROM CINEMA c " + "WHERE  c.CINEMA_NAME = " + "'"
					+ MovieVO.user.getCinema_name() + "'" + "AND c.MOVIE_CORD =" + "'" + MovieVO.user.getMovie_cord()
					+ "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				name = rs.getString("CINEMA_LOCATION");
				cols[i] = name;
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cols;
	}

}
