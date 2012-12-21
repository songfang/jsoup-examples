package com.gosmarter.webcrawler.jsoup;

public class AwardMovie {
	public String getAwardSource() {
		return awardSource;
	}

	public void setAwardSource(String awardSource) {
		this.awardSource = awardSource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getBestDirector() {
		return bestDirector;
	}

	public void setBestDirector(Boolean bestDirector) {
		this.bestDirector = bestDirector;
	}

	public Boolean getBestLeadHero() {
		return bestLeadHero;
	}

	public void setBestLeadHero(Boolean bestLeadHero) {
		this.bestLeadHero = bestLeadHero;
	}

	public Boolean getBestLeadHeroine() {
		return bestLeadHeroine;
	}

	public void setBestLeadHeroine(Boolean bestLeadHeroine) {
		this.bestLeadHeroine = bestLeadHeroine;
	}

	public Boolean getNominatedBestDirector() {
		return nominatedBestDirector;
	}

	public void setNominatedBestDirector(Boolean nominatedBestDirector) {
		this.nominatedBestDirector = nominatedBestDirector;
	}

	public Boolean getNominatedBestLeadHero() {
		return nominatedBestLeadHero;
	}

	public void setNominatedBestLeadHero(Boolean nominatedBestLeadHero) {
		this.nominatedBestLeadHero = nominatedBestLeadHero;
	}

	public Boolean getNominatedBestLeadHeroine() {
		return nominatedBestLeadHeroine;
	}

	public void setNominatedBestLeadHeroine(Boolean nominatedBestLeadHeroine) {
		this.nominatedBestLeadHeroine = nominatedBestLeadHeroine;
	}

	public Boolean getBestMovie() {
		return bestMovie;
	}

	public void setBestMovie(Boolean bestMovie) {
		this.bestMovie = bestMovie;
	}

	public Boolean getNominatedBestMovie() {
		return nominatedBestMovie;
	}

	public void setNominatedBestMovie(Boolean nominatedBestMovie) {
		this.nominatedBestMovie = nominatedBestMovie;
	}

	private String awardSource;
	private String name;
	private String year;
	private String language;
	private Boolean bestMovie;
	private Boolean bestDirector;
	private Boolean bestLeadHero;
	private Boolean bestLeadHeroine;
	private Boolean nominatedBestMovie;
	private Boolean nominatedBestDirector;
	private Boolean nominatedBestLeadHero;
	private Boolean nominatedBestLeadHeroine;
	public String getBestMovie1() {
		return bestMovie1;
	}

	public void setBestMovie1(String bestMovie1) {
		this.bestMovie1 = bestMovie1;
	}

	public String getBestDirector1() {
		return bestDirector1;
	}

	public void setBestDirector1(String bestDirector1) {
		this.bestDirector1 = bestDirector1;
	}

	public String getBestLeadHero1() {
		return bestLeadHero1;
	}

	public void setBestLeadHero1(String bestLeadHero1) {
		this.bestLeadHero1 = bestLeadHero1;
	}

	public String getBestLeadHeroine1() {
		return bestLeadHeroine1;
	}

	public void setBestLeadHeroine1(String bestLeadHeroine1) {
		this.bestLeadHeroine1 = bestLeadHeroine1;
	}

	private String bestMovie1;
	private String bestDirector1;
	private String bestLeadHero1;
	private String bestLeadHeroine1;

	public AwardMovie(String awardSource, String name, String year) {
		this.awardSource = awardSource;
		this.name = name;
		this.year = year;
	}
	
	public AwardMovie() {
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return awardSource + " " + name + " " + year + " " + language + " " + bestMovie + " " + bestDirector + " " + bestLeadHero + " "
				+ bestLeadHeroine + " " + nominatedBestMovie + " " + nominatedBestDirector + " " + nominatedBestLeadHero + " "
				+ nominatedBestLeadHeroine;
	}
}
