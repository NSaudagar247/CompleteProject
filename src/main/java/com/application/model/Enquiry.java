package com.application.model;

public class Enquiry {
	
	private int enquiryId;
	private String enquiryName;
	private String enquiryEmail;
	private String enquiryType;
	private String enquiryContent;
	private long enquiryContactNo;
	private boolean isContactMobile;
	
	public int getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getEnquiryName() {
		return enquiryName;
	}
	public void setEnquiryName(String enquiryName) {
		this.enquiryName = enquiryName;
	}
	public String getEnquiryEmail() {
		return enquiryEmail;
	}
	public void setEnquiryEmail(String enquiryEmail) {
		this.enquiryEmail = enquiryEmail;
	}
	public String getEnquiryType() {
		return enquiryType;
	}
	public void setEnquiryType(String enquiryType) {
		this.enquiryType = enquiryType;
	}
	public String getEnquiryContent() {
		return enquiryContent;
	}
	public void setEnquiryContent(String enquiryContent) {
		this.enquiryContent = enquiryContent;
	}
	public long getEnquiryContactNo() {
		return enquiryContactNo;
	}
	public void setEnquiryContactNo(long enquiryContactNo) {
		this.enquiryContactNo = enquiryContactNo;
	}
	public boolean isContactMobile() {
		return isContactMobile;
	}
	public void setContactMobile(boolean isContactMobile) {
		this.isContactMobile = isContactMobile;
	}
	
}
