package com.chai.schoolApp.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;

//import org.hibernate.annotations.;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name="contact_msg")
public class Contact extends baseEntity{
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "contact_id")
    //column annotation is not necessary here.
	private int contactId;
	
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
	
	private String status;
	

	

	
}
