package VO;

public class MovieVO {
	String cinema_location;
	String cinema_name;
	String movie_cord;
	String cinema_cord;
	public static MovieVO re;

	public static void remember(MovieVO vo) {
		re = vo;
	}

	public String getCinema_location() {
		return cinema_location;
	}

	public String getCinema_name() {
		return cinema_name;
	}

	public String getMovie_cord() {
		return movie_cord;
	}

	public String getCinema_cord() {
		return cinema_cord;
	}

	public void setCinema_location(String cinema_location) {
		this.cinema_location = cinema_location;
	}

	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}

	public void setMovie_cord(String movie_cord) {
		this.movie_cord = movie_cord;
	}

	public void setCinema_cord(String cinema_cord) {
		this.cinema_cord = cinema_cord;
	}

	public MovieVO() {

	}

	public MovieVO(String cinema_location, String cinema_name, String movie_cord, String cinema_cord) {
		super();
		this.cinema_location = cinema_location;
		this.cinema_name = cinema_name;
		this.movie_cord = movie_cord;
		this.cinema_cord = cinema_cord;
	}

	public MovieVO(String movie_cord, String cinema_name) {
		this.movie_cord = movie_cord;
		this.cinema_name = cinema_name;
	}

	public MovieVO(String movie_cord, String cinema_name, String cinema_location) {
		this.movie_cord = movie_cord;
		this.cinema_name = cinema_name;
		this.cinema_location = cinema_location;
	}

	@Override
	public String toString() {
		return "MovieVO [cinema_location=" + cinema_location + ", cinema_name=" + cinema_name + ", movie_cord="
				+ movie_cord + ", cinema_cord=" + cinema_cord + "]";
	}

}
