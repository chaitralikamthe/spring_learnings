package com.chai.schoolApp.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class baseEntity {
	
	private LocalDateTime createdAt;
	private String createdBy;
	private LocalDateTime updatedAt;
	private String updatedBy;
	
}
