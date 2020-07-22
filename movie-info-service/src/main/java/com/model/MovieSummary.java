package com.model;

public class MovieSummary {
	
	private String id;
	private String original_title;
	private String overview;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public MovieSummary(String id, String original_title, String overview) {
		super();
		this.id = id;
		this.original_title = original_title;
		this.overview = overview;
	}
	public MovieSummary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
