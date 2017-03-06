package com.application.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.application.model.Enquiry;
import com.application.utils.Utils;

@Repository("enquiryDao")
public class EnquiryDaoImpl implements EnquiryDao {
	
	@Override
	public List<Enquiry> getEnquiryList() {
		System.out.println("Enquiry list in dao");
		return Utils.getEnquiryList();
	}
	
}
