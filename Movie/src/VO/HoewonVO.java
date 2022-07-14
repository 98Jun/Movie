package VO;

public class HoewonVO {
	String id;
	String pw;
	String name;

	public HoewonVO() {

	}

	public HoewonVO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "HoewonVO [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
}
