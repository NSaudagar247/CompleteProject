package com.application.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.application.model.Notice;
import com.application.utils.Utils;

@Repository("noticeDao")
public class NoticeDaoImpl implements NoticeDao {
	
	@Override
	public List<Notice> getNoticeList() {
		System.out.println("Notice list in dao");
		return Utils.getNoticeList();
	}
	
}
