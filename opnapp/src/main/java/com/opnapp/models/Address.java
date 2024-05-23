package com.opnapp.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long addressId;
	    
	    @NotBlank
	    @Pattern(regexp = "^[0-9]+$", message = "House number should contain only numbers")
		private String houseNo;
	    
	    @NotBlank(message = "Colony is required")
		private String colony;
	    
	    @NotBlank(message = "City is required")
		private String city;
	    
	    @NotBlank(message = "State is required")
		private String state;
	    
	    @NotBlank(message = "PIN code is required")
	    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid Indian PIN code")
		private int pincode;
	    
	    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
	    private Customer customer;
		
		
		public Address(Long addressId, String houseNo, String colony, String city, String state, int pincode) {
			this.addressId = addressId;
			this.houseNo = houseNo;
			this.colony = colony;
			this.city = city;
			this.state = state;
			this.pincode = pincode;
		}
		public Address() {
		}
		public Long getAddressId() {
			return addressId;
		}
		public void setAddressId(Long addressId) {
			this.addressId = addressId;
		}
		public String getHouseNo() {
			return houseNo;
		}
		public void setHouseNo(String houseNo) {
			this.houseNo = houseNo;
		}
		public String getColony() {
			return colony;
		}
		public void setColony(String colony) {
			this.colony = colony;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			state = state;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}
		public void setCustomer(Customer customer){
			this.customer=customer;
		}
}
