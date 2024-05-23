package com.opnapp.utilities;

public class UserInfo {
	private Boolean isCustomer;
	private Boolean isAdministrator;
	private Long id;
	
	public UserInfo(Boolean isCustomer, Boolean isAdministrator, Long id) {
		this.isCustomer = isCustomer;
		this.isAdministrator = isAdministrator;
		this.id=id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsCustomer() {
		return isCustomer;
	}

	public void setIsCustomer(Boolean isCustomer){
		this.isCustomer = isCustomer;
	}

	public Boolean getIsAdministrator(){
		return isAdministrator;
	}

	public void setIsAdministrator(Boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}
}
