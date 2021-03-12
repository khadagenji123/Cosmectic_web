package model;

public class Account {
	private String username;
	private String password;
	private String name;
	private String birthday;
	private String gender;
	private String address;
	private String number_phone;
	private String email;
	private int checkuser;
	
	public Account(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	
	public Account(String username, String password, String name, String birthday,
			String gender, String address,String number_phone, int checkuser) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.number_phone = number_phone;
		this.checkuser = checkuser;
	}
	
	public Account(String email,String password,String name,String birthday,
			String gender,String address,String number_phone) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.number_phone = number_phone;
	}
	
	public int getCheckuser() {
		return checkuser;
	}


	public void setCheckuser(int checkuser) {
		this.checkuser = checkuser;
	}


	public String getNumber_phone() {
		return number_phone;
	}

	public void setNumber_phone(String number_phone) {
		this.number_phone = number_phone;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
