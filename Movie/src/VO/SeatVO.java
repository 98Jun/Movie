package VO;

public class SeatVO {
	private String seat_cord ;
	private String seat_number ;
	private String cinema_cord = MovieVO.user.getCinema_cord();
	private String movie_cord = MovieVO.user.getMovie_cord();
	private String day;
	private String time;
	public static SeatVO user1;
	public static void remember(SeatVO vo) {
		user1 = vo;
	}
	public SeatVO(String day) {
		this.day= day;
	}
	
	public SeatVO() {

	}
	public SeatVO(String seat_cord, String seat_number, String cinema_cord, String movie_cord, String day,
			String time) {
		super();
		this.seat_cord =(movie_cord+cinema_cord+seat_number);
		this.seat_number = seat_number;
		this.cinema_cord = cinema_cord;
		this.movie_cord = movie_cord;
		this.day = day;
		this.time = time;
	}
	
	public String getSeat_cord() {
		return seat_cord;
	}

	public void setSeat_cord(String seat_cord) {
		this.seat_cord = seat_cord;
	}

	public String getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}

	public String getCinema_cord() {
		return cinema_cord;
	}

//	public void setCinema_cord(String cinema_cord) {
//		this.cinema_cord = cinema_cord;
//	}

	public String getMovie_cord() {
		return movie_cord;
	}

//	public void setMovie_cord(String movie_cord) {
//		this.movie_cord = movie_cord;
//	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "SeatVO [seat_cord=" + seat_cord + ", seat_number=" + seat_number + ", cinema_cord=" + cinema_cord
				+ ", movie_cord=" + movie_cord + ", day=" + day + ", time=" + time + "]";
	}
}
