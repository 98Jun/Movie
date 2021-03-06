package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

import VO.TicketVO;

public class TicketDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##green";
	private String password = "green1234";
	private String ticketnum;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String id;
	private String name;
	private String moviename;
	private String cinemaname;
	private String cinemalocation;
	private String seatnum;
	private String price;
	private String day;
	private String time;

	public TicketDAO() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insert(TicketVO vo) {
		String sql;

		try {

			sql = "insert into ticket(id,ticket_number,cinema_cord,movie_cord,seat_cord) ";
			sql += "values(?,num.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getCinemacord());
			pstmt.setString(3, vo.getMoviecord());
			pstmt.setString(4, vo.getSeatcord());
			pstmt.executeUpdate();
//			
			pstmt.close();
		} catch (Exception e) {
//			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "이 좌석은 예매되어 있습니다. \n 다른 좌석을 선택해 주세요", "", JOptionPane.WARNING_MESSAGE);
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

	public String ticket() {
		String num = null;
		try {
			num = "select t.TICKET_NUMBER " + "FROM TICKET t";
			pstmt = con.prepareStatement(num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ticketnum = rs.getString("TICKET_NUMBER");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticketnum;
	}

	public void list(String ticket) {

		try {

			String sql = "SELECT l.ID , l.NAME ,m.MOVIE_NAME  ,c.CINEMA_NAME ,c.CINEMA_LOCATION , s.SEAT_NUMBER ,m.PRICE ,t.TICKET_NUMBER ,s.\"DAY\" ,s.\"TIME\" "
					+ "FROM TICKET t  ,LOGIN l ,MOVIE m ,SEAT s ,CINEMA c "
					+ "WHERE t.ID =l.ID  AND c.CINEMA_CORD =t.CINEMA_CORD  AND t.MOVIE_CORD = m.MOVIE_CORD  AND t.SEAT_CORD =s.SEAT_CORD   AND t.TICKET_NUMBER = "
					+ "'" + ticket + "'";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getString("ID");
				name = rs.getString("NAME");
				moviename = rs.getString("MOVIE_NAME");
				cinemaname = rs.getString("CINEMA_NAME");
				cinemalocation = rs.getString("CINEMA_LOCATION");
				seatnum = rs.getString("SEAT_NUMBER");
				price = rs.getString("PRICE");
				ticketnum = rs.getString("TICKET_NUMBER");
				day = rs.getString("DAY");
				time = rs.getString("TIME");
//				System.out.println(id);

			}
		} catch (Exception e) {
//			e.printStackTrace();
		}

	}

	public int delete(String ticket) {
		int result = 0;
		try {
			String sql = "DELETE  TICKET t " + " WHERE t.ticket_number = ?";
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, ticket);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMoviename() {
		return moviename;
	}

	public String getCinemaname() {
		return cinemaname;
	}

	public String getCinemalocation() {
		return cinemalocation;
	}

	public String getSeatnum() {
		return seatnum;
	}

	public String getPrice() {
		return price;
	}

	public String getDay() {
		return day;
	}

	public String getTime() {
		return time;
	}
}
