package com.tae.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultFlightHotelsPage extends HomeTravelocityPage {

	public ResultFlightHotelsPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	@FindBy(how = How.ID, using = "resultsContainer")
	private WebElement resultsContainer;
	
	
}
