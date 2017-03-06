package com.application.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Blog {

	private String title;
	private String story;
	private String writer;
	private Date writtenOn;

	public Blog() {
		this.title = null;
		this.story = null;
	}
	
	@JsonCreator
	public Blog(@JsonProperty("name") String title, @JsonProperty("name") String story,@JsonProperty("writer") String writer, @JsonProperty("writtenOn") Date writtenOn) {
		this.title = title;
		this.story = story;
		this.writer = writer;
		this.writtenOn = writtenOn;
	}
	
	@Override
	public String toString() {
		return ("Title = "+title+", Story = "+story+ ", Writer = "+writer+", Written On = "+writtenOn);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWrittenOn() {
		return writtenOn;
	}
	public void setWrittenOn(Date writtenOn) {
		this.writtenOn = writtenOn;
	}
}
