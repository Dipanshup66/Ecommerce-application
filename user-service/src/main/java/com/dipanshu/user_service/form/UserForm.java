package com.dipanshu.user_service.form;

import com.dipanshu.common.controller.BaseEntity;
import com.dipanshu.common.controller.BaseForm;
import com.dipanshu.user_service.model.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserForm extends BaseForm {

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Email is mandatory")
	@Pattern(regexp = "^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$", message = "LoginId Is Dose Not Match This Formate")
	private String email;

	@NotBlank(message = "Password is mandatory")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$", message = "Password must be 8+ chars with uppercase, lowercase, number & special char")
	private String password;

	@NotBlank(message = "Mobile is mandatory")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
	private String mobile;

	@NotBlank(message = "Address is mandatory")
	private String address;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public BaseEntity getDto() {
		User dto = initEntity(new User());
		dto.setName(name);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setMobile(mobile);
		dto.setAddress(address);
		return dto;
	}

}
