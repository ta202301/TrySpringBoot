package com.example.demo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class ProductForm {
	
	@NotEmpty(message="社員No is necesarry")
	@Pattern(regexp ="^[0-9]{3}$", message="半角数字、3ケタでお願いします")
	private String number;

	public String getNumber() {
	return number;
	}

	public void setNumber(String number) {
	this.number = number;
	}

}
