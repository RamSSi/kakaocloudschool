package lecture0722.step3;

public class User {

	// private field : db의 column명과 같은 변수명
	
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String name;
	private String password;
	
	public User() {}
	
	
}
