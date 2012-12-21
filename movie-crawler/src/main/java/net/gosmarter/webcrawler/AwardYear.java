package net.gosmarter.webcrawler;

public class AwardYear {
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getWikipediaSource() {
		return wikipediaSource;
	}
	public void setWikipediaSource(String wikipediaSource) {
		this.wikipediaSource = wikipediaSource;
	}
	private String awardName;
	private String wikipediaSource;
	private String year;
	
	public AwardYear(String awardName, String wikipediaSource, String year){
		this.awardName = awardName;
		this.wikipediaSource = wikipediaSource;
		this.year = year;
	}
	
	public AwardYear(){
		
	}
}
