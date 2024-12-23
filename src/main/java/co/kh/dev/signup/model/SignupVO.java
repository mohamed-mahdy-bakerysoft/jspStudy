package co.kh.dev.signup.model;

public class SignupVO {
	private String id;
	private String pwd;
	private String email;
	private String name;
	private int birth;
	
	public SignupVO() {
		super();
	}

	public SignupVO(String id, String pwd, String email, String name, int birth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "SignupVO [id=" + id + ", pwd=" + pwd + ", email=" + email + ", name=" + name + ", birth=" + birth + "]";
	}

	
}
