package VO;

public class TicketVO {
	private String id = UserVO.user.getId();
//	int num = (int) (Math.random()*99999999)+90000000;
//	String tnum = String.valueOf(num);
	private String ticketnum;
//	
	private String cinemacord = SeatVO.user1.getCinema_cord();
	private String moviecord = SeatVO.user1.getMovie_cord();
	private String seatcord = SeatVO.user1.getSeat_cord();
	public static TicketVO user;

	public static void re(TicketVO vo) {
		user = vo;
	}

	@Override
	public String toString() {
		return "TicketVO [id=" + id + ", ticketnum=" + ticketnum + ", cinemacord=" + cinemacord + ", moviecord="
				+ moviecord + ", seatcord=" + seatcord + "]";
	}

	public TicketVO() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTicketnum() {
		return ticketnum;
	}

	public void setTicketnum(String ticketnum) {
		this.ticketnum = ticketnum;
	}

	public String getCinemacord() {
		return cinemacord;
	}

	public void setCinemacord(String cinemacord) {
		this.cinemacord = cinemacord;
	}

	public String getMoviecord() {
		return moviecord;
	}

	public void setMoviecord(String moviecord) {
		this.moviecord = moviecord;
	}

	public String getSeatcord() {
		return seatcord;
	}

	public void setSeatcord(String seatcord) {
		this.seatcord = seatcord;
	}
}
