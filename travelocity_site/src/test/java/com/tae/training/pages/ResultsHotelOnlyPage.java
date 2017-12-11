package com.tae.training.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultsHotelOnlyPage extends BasePage {

	public ResultsHotelOnlyPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "mer-signup-toggle-btn")
	private WebElement discountSection;

	@FindBy(how = How.ID, using = "resultsContainer")
	private WebElement resultHotelsContainer;
	
	List<WebElement> listOfHotels = resultHotelsContainer.findElements(By.tagName("article"));
	ArrayList<Integer> arraySponsoredPositions = new ArrayList<>();

	public boolean discountSectionIsDisplayed() {
		boolean discountSectionDisplayed = false;
		if (discountSection != null)
			discountSectionDisplayed = true;
		return discountSectionDisplayed;
	}

	public int getTotalsOfSponsorsInResults() {
		int numOfSponsored = 0;
		int sponsoredPosition = 0;
		System.out.println("Size of Results List: " + (listOfHotels.size() - 1));
		for (WebElement sponsoredArticle : listOfHotels) {
			if (sponsoredArticle.getAttribute("id").contains("sponsored")) {
				numOfSponsored++;
				System.out.println("Sponsored located at position: " + sponsoredPosition);
				arraySponsoredPositions.add(sponsoredPosition);
			}
			sponsoredPosition++;
		}
		System.out.println("Number of Sponsored Results: " + numOfSponsored);
		return numOfSponsored;
	}

	public boolean sponsoredShownFirst() {
		boolean sponsoredFirst = false;
		int totalOfSponsored = getTotalsOfSponsorsInResults();
		if(totalOfSponsored > 1){
			int currentPosValue = arraySponsoredPositions.get(0).intValue();
			int nextPosValue = arraySponsoredPositions.get(1).intValue();
			if(currentPosValue == nextPosValue){ 
				  sponsoredFirst = true; 
			  }
		}
		return sponsoredFirst;
	}

}
