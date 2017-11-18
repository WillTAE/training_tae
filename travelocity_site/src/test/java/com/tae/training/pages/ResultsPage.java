package com.tae.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultsPage extends BasePage {

	public ResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//span[@class='title-city-text']")
	private WebElement resultsPageTitle;

	public WebElement getResultsPageTitle() {
		return resultsPageTitle;
	}
	
	

}
