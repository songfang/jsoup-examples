package net.gosmarter.webcrawler;

public class Movie {
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getScreenplay() {
		return screenplay;
	}
	public void setScreenplay(String screenplay) {
		this.screenplay = screenplay;
	}
	public String getStarring() {
		return starring;
	}
	public void setStarring(String starring) {
		this.starring = starring;
	}
	public String getCinematography() {
		return cinematography;
	}
	public void setCinematography(String cinematography) {
		this.cinematography = cinematography;
	}
	public String getEditing() {
		return editing;
	}
	public void setEditing(String editing) {
		this.editing = editing;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	private String director;
	private String producer;
	private String screenplay;
	private String starring;
	private String cinematography;
	private String editing;
	private String country;
	private String language;
	private String budget;
	private String imageUrl;
	private String name;
	private String source;
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
