package com.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.LoginDao;
import com.application.model.Login;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao loginDao;
	
	public boolean validateUser(Login login) {
		System.out.println("value  -------- ");
		return loginDao.validateUser(login) ;
	}
	
}
