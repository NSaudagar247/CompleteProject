package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.application.model.Login;
import com.application.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
    LoginService loginService;
	
	@RequestMapping(value = "/")
	public ModelAndView sayHello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Hello, world!");
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "/loginValidate", method = RequestMethod.POST)
	public ResponseEntity<Boolean> validateUser(@RequestBody Login login) {
		System.out.println("login controller");
		System.out.println("login username -- " + login.getUsername());
		System.out.println("login password -- " + login.getPassword());
		boolean result = loginService.validateUser(login);
		System.out.println(result);
		if (!result) {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	public ModelAndView userPage() {
		System.out.println("index method called --- >> ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
}