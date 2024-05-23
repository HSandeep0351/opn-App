package com.opnapp.services;

import com.opnapp.utilities.UserInfo;

public interface LoginService {

	UserInfo authUser(String userType, String username, String password);

}
