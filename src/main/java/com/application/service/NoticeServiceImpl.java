package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.NoticeDao;
import com.application.model.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	public List<Notice> getNoticeList() {
		return noticeDao.getNoticeList() ;
	}
	
}
