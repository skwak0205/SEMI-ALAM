package com.alam.dto;

public class LoginDto {

	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_email;
	private String member_phone;
	private String member_address;
	private String member_category;
	private String member_gender;
	private String member_grade;
	private String member_salt;
	
	public LoginDto() {
		
	}

	public LoginDto(String member_id, String member_pw, String member_name, String member_email, String member_phone,
			String member_address, String member_category, String member_gender, String member_grade, String member_salt) {
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_email = member_email;
		this.member_phone = member_phone;
		this.member_address = member_address;
		this.member_category = member_category;
		this.member_gender = member_gender;
		this.member_grade = member_grade;
		this.member_salt = member_salt;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public String getMember_category() {
		return member_category;
	}

	public void setMember_category(String member_category) {
		this.member_category = member_category;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_grade() {
		return member_grade;
	}

	public void setMember_grade(String member_grade) {
		this.member_grade = member_grade;
	}

	public String getMember_salt() {
		return member_salt;
	}

	public void setMember_salt(String member_salt) {
		this.member_salt = member_salt;
	}
	
	
	
}
