package com.opnapp.services;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.opnapp.DAO.AdministratorDAO;
import com.opnapp.DAO.CustomerDAO;
import com.opnapp.models.Administrator;
import com.opnapp.models.Customer;
import com.opnapp.utilities.UserInfo;
 
@Service
public class LoginServiceImpl implements LoginService {
	private final AdministratorDAO administratorDao;
	private final CustomerDAO customerDao;
 
	@Autowired
	public LoginServiceImpl(AdministratorDAO administratorDAO, CustomerDAO customerDao) {
		this.administratorDao = administratorDAO;
		this.customerDao = customerDao;
	}
 
	@Override
	public UserInfo authUser(String userType, String email, String password) {
		UserInfo userInfo = new UserInfo(false, false,null);
		if (userType.equals("administrator")) {
			Administrator admin = administratorDao.getAdministratorByUsername(email);
			if ( admin != null) {
				userInfo.setIsAdministrator(true);
				userInfo.setId(admin.getAdminId());
			}
		} else if (userType.equals("customer")) {
			Customer customer= customerDao.getCustomerByEmail(email);
			if ( customer != null) {
				userInfo.setId(customer.getId());
				userInfo.setIsCustomer(true);
			}
		}
		return userInfo;
	}
}