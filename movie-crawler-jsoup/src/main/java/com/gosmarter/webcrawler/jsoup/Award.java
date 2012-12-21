package com.gosmarter.webcrawler.jsoup;

public class Award {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulatiry() {
		return populatiry;
	}
	public void setPopulatiry(int populatiry) {
		this.populatiry = populatiry;
	}
	public String getWikipediaSource() {
		return wikipediaSource;
	}
	public void setWikipediaSource(String wikipediaSource) {
		this.wikipediaSource = wikipediaSource;
	}
	private String name;
	private String language;
	private String year;
	private String wikipediaSource;
	private int populatiry;
	
	public Award(String name, String wikipediaSource){
		this.wikipediaSource = wikipediaSource;
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
