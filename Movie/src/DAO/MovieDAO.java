package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import VO.MovieVO;

public class MovieDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";
	Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	String code;
	String cname;

	public boolean insertData(MovieVO vo) {
		String sql;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 완료");
			sql = "SELECT c.CINEMA_NAME, c.MOVIE_CORD" + " FROM CINEMA c" + " WHERE c.MOVIE_CORD =" + "'"
					+ vo.getMovie_cord() + "'" + "  AND c.CINEMA_NAME =" + "'" + "엄준식" + "'";
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 완료");
			String sql = "SELECT c.CINEMA_LOCATION " + " FROM CINEMA c " + "WHERE  c.CINEMA_NAME = " + "'"
					+ MovieVO.user.getCinema_name() + "'" + "AND c.MOVIE_CORD =" + "'" + MovieVO.user.getMovie_cord() + "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
//			System.out.println(rs);
//			System.out.println(pstmt);

			while (rs.next()) {
				name = rs.getString("CINEMA_LOCATION");
				cols[i] = name;
//				System.out.println(cols[i]);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cols;
	}

}
