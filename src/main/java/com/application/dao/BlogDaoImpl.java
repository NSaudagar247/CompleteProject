package com.application.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.ArrayList;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.application.model.Blog;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class BlogDaoImpl implements BlogDao{

	static String filepath="";
	public BlogDaoImpl() {
				try {
//			filepath = System.getProperty("user.dir")+"/src/main/webapp/resources/modules/blog/blogs.json";

			String path = this.getClass().getClassLoader().getResource("").getPath();
			String fullPath = URLDecoder.decode(path, "UTF-8");
			String pathArr[] = fullPath.split("/WEB-INF/classes/");
			fullPath = pathArr[0].substring(1);
			filepath = fullPath.concat("/resources/modules/blog/blogs.json");
			
			System.out.println(new File(filepath).exists());
		} 
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}	

	@Override
	public List<Blog> getBlogList() {

		com.fasterxml.jackson.databind.ObjectMapper bmapper = new com.fasterxml.jackson.databind.ObjectMapper();
		List<Blog> blogList = new ArrayList<Blog>();

	 	try {
	 		blogList = bmapper.readValue(new FileInputStream(filepath),
	 				TypeFactory.defaultInstance().constructCollectionType(List.class,  
	 				   Blog.class));
	 		System.out.println("All Blogs : "+blogList);
	 	}
	 	catch(Exception e){
	 		e.printStackTrace();
	 	}
		return blogList;
	}

	@Override
	public Blog getBlog(Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addBlog(Blog blog) {
		System.out.println("Inside AddBlog method of DAO.");
		File myfile = new File(filepath);
		ObjectMapper mapper = new ObjectMapper();
		int flag = 0;

		if(myfile.exists()){
			System.out.println("File Present @ "+ myfile.getAbsolutePath());
			List<Blog> list = getBlogList();
			 
			for (Blog existingblog : list) {
				if(existingblog.getTitle().equals(blog.getTitle())){
					flag = 2;
					break;
				}
			}
				 
			if(flag==2){
				System.out.println("Blog already present");
			}
			else{
				list.add(blog);
				try {
					String json2 = mapper.writeValueAsString(list);
					Files.write(myfile.toPath(), Arrays.asList(json2), StandardOpenOption.WRITE);
					System.out.println("New Blog Inserted");
					flag = 1;
				} 
				catch (IOException e) {
					e.printStackTrace();
					System.out.println("Problem in inserting new blog in json file");
				}
			}
		}
		else{
			System.out.println("File not Present @ "+myfile.getAbsolutePath() +myfile.getName());
			List<Blog> list = new ArrayList<Blog>();
			list.add(blog);
			String json2;
			try {
				json2 = mapper.writeValueAsString(list);
				Files.write(myfile.toPath(), Arrays.asList(json2), StandardOpenOption.CREATE);
				System.out.println("New Blog Inserted");
				flag = 1;
			} 
			catch (IOException e) {
				e.printStackTrace();
				System.out.println("Problem in creating new blog in json file");
			}
		}
		
		getBlogList();
		return flag;
	}

	@Override
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

}
