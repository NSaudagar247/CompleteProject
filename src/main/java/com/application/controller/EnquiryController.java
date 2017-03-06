package com.application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.model.Enquiry;
import com.application.service.EnquiryService;
import com.application.utils.TechStudioConstants;

@Controller
public class EnquiryController {

	@Autowired
	EnquiryService enquiryService;

	@RequestMapping(value = "/enquiry", method = RequestMethod.GET)
	public String getEnquiryListPage() {
		System.out.println("index controller for enquiry");
		return "enquiry";
	}

	@RequestMapping(value = "/enquiryForm", method = RequestMethod.GET)
	public String getEnquiryFormPage() {
		System.out.println("index controller for enquiry form");
		return "enquiryform";
	}

	@RequestMapping(value = "/enquiryList", method = RequestMethod.GET)
	public ResponseEntity<List<Enquiry>> getEnquiryList(HttpServletRequest request) {
		System.out.println("Enquiry controller to get list of data");
		HttpSession session = request.getSession();
		List<Enquiry> result = enquiryService.getEnquiryList();
		session.setAttribute(TechStudioConstants.ENQUIRY_LIST, result);
		return new ResponseEntity<List<Enquiry>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/enquiryById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Enquiry> getEnquiryDetailsById(@PathVariable("id") long id, HttpServletRequest request) {
		System.out.println("Enquiry controller to get enquiry of data by id -- >> " + id);
		HttpSession session = request.getSession();
		List<Enquiry> result = (List<Enquiry>) session.getAttribute(TechStudioConstants.ENQUIRY_LIST);
		for(Enquiry enq: result) {
			if(enq.getEnquiryId() == id) {
				return new ResponseEntity<Enquiry>(enq, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Enquiry>(HttpStatus.NOT_FOUND);
	}
}