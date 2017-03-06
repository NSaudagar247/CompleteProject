package com.application.dao;

import java.util.List;
import com.application.model.Blog;

public interface BlogDao {
	public List<Blog> getBlogList();
	public Blog getBlog(Blog blog);
	public int addBlog(Blog blog);
	public boolean updateBlog(Blog blog);	
	public boolean deleteBlog(Blog blog);
}
