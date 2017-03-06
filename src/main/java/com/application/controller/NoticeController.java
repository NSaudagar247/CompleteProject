package com.application.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.model.Notice;
import com.application.service.NoticeService;
 
@Controller
public class NoticeController {
 
    @Autowired
    NoticeService noticeService;  
    
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public String getNoticePage() {
	  System.out.println("NoticeController controller for notice");
        return "notice";
    }
    
    @RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public ResponseEntity<List<Notice>> getNoticeList() {
		System.out.println("Notice controller to get list of data");
		List<Notice> result = noticeService.getNoticeList();		
		return new ResponseEntity<List<Notice>>(result, HttpStatus.OK);
	}
 
}