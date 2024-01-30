package com.chai.schoolApp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class Contact {
	
	@NotBlank(message="Name must not be blank")
	@Size(min=3, message="Name must be atleast 3 characters long")
	private String name;
	
	@NotBlank(message="Mobile Number must not be blank")
	@Pattern(regexp="(^$|[0-9]{10})", message="Mobile number must be 10 digits")
	private String mobileNum;
	
	@NotBlank(message="Email must not be blank")
	@Email(message="Please provide valid email address")
	private String email;
	
	@NotBlank(message="Subject must not be blank")
	private String subject;
	
	@NotBlank(message="Message must not be blank")
	private String message;
	

	
}
