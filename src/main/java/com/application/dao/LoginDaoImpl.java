package com.application.dao;
import org.springframework.stereotype.Repository;
import com.application.model.Login;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean validateUser(Login login) {
		try {
			if(login.getUsername().equals(login.getPassword())) {
				return true;
			} else {
				return false;
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
}
