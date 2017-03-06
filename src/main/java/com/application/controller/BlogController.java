package com.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.application.model.Blog;
import com.application.service.BlogService;
import com.application.service.BlogServiceImpl;

@Controller
@RequestMapping("/blog")
public class BlogController {  

	BlogService blogService = null;
	public BlogController() {
		blogService = new BlogServiceImpl(); 
	}
	
	@RequestMapping(value = "/getAllBlogs",  method = RequestMethod.GET)
	public @ResponseBody List<Blog> getBlogList() {
		List<Blog> blogList = blogService.getBlogList();
		return blogList;
	}	
	
	@RequestMapping(value = "/addBlog", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addBlog(@RequestBody Blog blog) {
		System.out.println("Inside addBLog method of Controller. Blog = "+blog );
		int result = blogService.addBlog(blog);
		if (result == 0) {
			return new ResponseEntity<String>("Problem for inserting new Blog. Please try after some time.", HttpStatus.NOT_IMPLEMENTED);
		}
		else if(result == 1){
			return new ResponseEntity<String>("Blog added Successfully.", HttpStatus.OK);
		}
		else  if(result == 2){
			return new ResponseEntity<String>("Blog already present with this title.", HttpStatus.CONFLICT);
		}
		else
			return new ResponseEntity<String>("Problem for inserting new Blog. Please try after some time.", HttpStatus.NOT_IMPLEMENTED);
	}
	
//	 @RequestMapping(value = "/addBlog/{Blog}", method = RequestMethod.POST)
//	    public @ResponseBody void addBlog(@PathVariable("Blog") String Blog) {
//	        blogService.addBlog(Blog);
//	    }
//
//	    @RequestMapping(value = "/removeBlog/{Blog}", method = RequestMethod.DELETE)
//	    public @ResponseBody void removeBlog(@PathVariable("Blog") String Blog) {
//	        blogService.deleteBlog(Blog);
//	    }
//
//	    @RequestMapping(value = "/removeAllBlogs", method = RequestMethod.DELETE)
//	    public @ResponseBody void removeAllBlogs() {
//	        blogService.deleteAll();
//	    }	
	
	
	
//	@RequestMapping(value = "/getAllBlogs", method = RequestMethod.GET)
//	public ModelAndView sayHello() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("message", "Hello, world!");
//		mav.setViewName("index");
//		return mav;
//	}
	
	
}