package VO;

public class UserVO {
	// VO는 여러 다른 타비의 데이터를 다른 클래스로 전달할때 사용?
	private String id;
	private String password;
	public static UserVO user;

	public static void r(UserVO vo) {
		user = vo;
	}

	public UserVO(String id) {
		this.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserVO() {

	}

	public UserVO(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
}
