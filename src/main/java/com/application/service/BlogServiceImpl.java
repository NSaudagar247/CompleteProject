package com.application.service;

import java.util.List;

import com.application.dao.BlogDao;
import com.application.dao.BlogDaoImpl;
import com.application.model.Blog;

public class BlogServiceImpl implements BlogService {

	BlogDao blogDao = null;
	
	public BlogServiceImpl() {
		blogDao = new BlogDaoImpl();
	}
	
	@Override
	public List<Blog> getBlogList() {
		return blogDao.getBlogList();
	}

	@Override
	public Blog getBlog(Blog blog) {
		return blogDao.getBlog(blog);
	}

	@Override
	public int addBlog(Blog blog) {
		return blogDao.addBlog(blog);
	}

	@Override
	public boolean updateBlog(Blog blog) {
		return blogDao.updateBlog(blog);
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		return blogDao.deleteBlog(blog);
	}
	
}
