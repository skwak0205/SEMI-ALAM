package com.alam.dto;

public class SearchDto {
	private String category;
	private String searchChoice;
	private String searchInput;
	public int startPage;
	public int endPage;
	
	
	public SearchDto() {
		
	}

	public SearchDto(String category, String searchChoice, String searchInput) {
		this.category = category;
		this.searchChoice = searchChoice;
		this.searchInput = searchInput;
	}
	
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSearchChoice() {
		return searchChoice;
	}

	public void setSearchChoice(String searchChoice) {
		this.searchChoice = searchChoice;
	}

	public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}
