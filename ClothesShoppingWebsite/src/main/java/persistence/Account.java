package persistence;

public class Account {
	private String email;
	private String password;
	private int role;
	private int active;
	private String verifyCode;
	
	public Account() {
	}
	
	public Account(String email, String password, int role, int active, String verifyCode) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.active = active;
		this.verifyCode = verifyCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + ", role=" + role + ", active=" + active
				+ ", verifyCode=" + verifyCode + "]";
	}
	
	
}
