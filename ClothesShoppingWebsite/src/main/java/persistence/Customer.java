package persistence;

import java.sql.Date;

public class Customer {
	private Integer id;
	private String name;
	private String gender;
	private Date dateOfBirth;
	private String address;
	private String phoneNumber;
	private String MXH;
	private String avatar;
	private String email;
	
	public Customer() {
	}

	

	public Customer(Integer id, String name, String gender, Date dateOfBirth, String address, String phoneNumber,
			String mXH, String avatar, String email) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		MXH = mXH;
		this.avatar = avatar;
		this.email = email;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMXH() {
		return MXH;
	}

	public void setMXH(String mXH) {
		MXH = mXH;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", MXH=" + MXH + ", avatar=" + avatar
				+ ", email=" + email + "]";
	}

	
	
}
