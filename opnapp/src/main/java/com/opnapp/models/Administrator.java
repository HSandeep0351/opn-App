package com.opnapp.models;

import jakarta.persistence.*;

@Entity
@Table
public class Administrator {
	@Id
	@GeneratedValue
	private Long adminId;
	
	@Column(unique=true)
	private String adminUserId;
	private String adminPassword;
	private Boolean isDeleted;
	 
	public Administrator() {this.isDeleted = false;}
	public Administrator(String adminUserId, String adminPassword) {
		this.adminUserId = adminUserId;
		this.adminPassword = adminPassword;
		this.isDeleted = false;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
