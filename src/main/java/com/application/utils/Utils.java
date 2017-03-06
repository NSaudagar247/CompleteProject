package com.application.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.application.model.Blog;
import com.application.model.Enquiry;
import com.application.model.Notice;

public class Utils {

//	public static List<Blog> getBlogList() {
//		List<Blog> blogList = new ArrayList<>();
//		Blog blog1= new Blog();
//		blog1.setBlogId(1);
//		blog1.setBlogTitle("blog1");
//		blog1.setBlogStory("<b>Blog Story about Blog 1</b>: <p> This story gives the information about the first blog</p>");
//		
//		Blog blog2= new Blog();
//		blog2.setBlogId(2);
//		blog2.setBlogTitle("blog2");
//		blog2.setBlogStory("<b>Blog Story about Blog 2</b>: <p> This story gives the information about the second blog</p>");
//		
//		blogList.add(blog1);
//		blogList.add(blog2);
//		
//		return blogList;
//	}
	
	public static List<Notice> getNoticeList() {
		List<Notice> noticeList = new ArrayList<>();
		Notice notice1= new Notice();
		notice1.setNoticeId(1000);
		notice1.setNoticeTitle("Notice 1000");
		notice1.setNoticeContent("Notice Story about Notice 1:  This story gives the information about the Notice");
		Date noticeDate1 = new Date(115, 0, 1);
		notice1.setNoticeDate(noticeDate1);
		
		Notice notice2= new Notice();
		notice2.setNoticeId(1001);
		notice2.setNoticeTitle("Notice New");
		notice2.setNoticeContent("Notice Story about Notice 2:  This story gives the information about the Another Notice");
		Date noticeDate2 = new Date(116, 1, 1);
		notice2.setNoticeDate(noticeDate2);
		
		Notice notice3= new Notice();
		notice3.setNoticeId(1002);
		notice3.setNoticeTitle("Notice New One");
		notice3.setNoticeContent("Notice Story about Notice 3:  This story gives the information about the Another New Notice");
		Date noticeDate3 = new Date(117, 2, 2);
		notice3.setNoticeDate(noticeDate3);
		
		noticeList.add(notice1);
		noticeList.add(notice2);
		noticeList.add(notice3);
		
		return noticeList;
	}
	
	public static List<Enquiry> getEnquiryList() {
		
		List<Enquiry> enquiryList = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			Enquiry enquiry = new Enquiry();
			enquiry.setEnquiryId(i);
			Long phoneNum = 9867115870L + i;
			enquiry.setEnquiryContactNo(phoneNum);
			enquiry.setEnquiryName("enquiryName"+i);
			enquiry.setEnquiryContent("enquiryContent_enquiryContent"+i);
			enquiry.setEnquiryEmail("email" + i + "@test.net");
			enquiry.setContactMobile(i%2 == 0);
			enquiry.setEnquiryType((i%2==0) ? "Course":"Facilities");
			enquiryList.add(enquiry);			
		}
		return enquiryList;
	}
}
