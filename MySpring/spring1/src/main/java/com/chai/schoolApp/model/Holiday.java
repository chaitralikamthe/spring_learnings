package com.chai.schoolApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="holidays")
public class Holiday extends baseEntity {
	
	@Id
	private String day;
	
	
	private String reason;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	public enum Type{
		FESTIVAL,FEDERAL
	}
}
	
//	public Holiday(String day,String reason, Type type) {
//		this.day=day;
//		this.reason=reason;
//		this.type=type;
//	}
//
//	public String getDay() {
//		return day;
//	}
//
//	public String getReason() {
//		return reason;
//	}
//
//	public Type getType() {
//		return type;
//	}
	
	

