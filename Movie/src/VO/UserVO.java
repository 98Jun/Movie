package VO;

public class UserVO {
	// VO�� ���� �ٸ� Ÿ���� �����͸� �ٸ� Ŭ������ �����Ҷ� ���?
	private String id;
	private String password;

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
