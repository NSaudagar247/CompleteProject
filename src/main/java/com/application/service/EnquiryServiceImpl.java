package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.EnquiryDao;
import com.application.model.Enquiry;

@Service("enquiryService")
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	private EnquiryDao enquiryDao;
	
	public List<Enquiry> getEnquiryList() {
		return enquiryDao.getEnquiryList() ;
	}
	
}
