package com.application.dao;

import com.application.model.Login;

public interface LoginDao {
	public boolean validateUser(Login login);
}
