package co.kh.dev.tempmember.model;

public class TempMemberVO {
	private String id;
	private String passwd;
	private String name;
	private String memNum1;
	private String memNum2;
	private String email;
	private String phone;
	private String zipcode;
	private String address;
	private String job;

	public TempMemberVO() {
		super();
	}

	public TempMemberVO(String id, String passwd, String name, String mem_num1, String mem_num2, String email,
			String phone, String zipcode, String address, String job) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.memNum1 = mem_num1;
		this.memNum2 = mem_num2;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
		this.address = address;
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMem_num1() {
		return memNum1;
	}

	public void setMem_num1(String mem_num1) {
		this.memNum1 = mem_num1;
	}

	public String getMem_num2() {
		return memNum2;
	}

	public void setMem_num2(String mem_num2) {
		this.memNum2 = mem_num2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "TempMemberVO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", memNum1=" + memNum1
				+ ", memNum2=" + memNum2 + ", email=" + email + ", phone=" + phone + ", zipcode=" + zipcode
				+ ", address=" + address + ", job=" + job + "]";
	}

}
