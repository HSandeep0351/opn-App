package com.opnapp.utilities;

import com.opnapp.models.Address;
import com.opnapp.models.Customer;

public class CustomerAddressGroup {
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getAddress(){
		return address;
	}
	public void setAddress(Address address){
		this.address = address;
	}
	private Customer customer;
	private Address address;
}
