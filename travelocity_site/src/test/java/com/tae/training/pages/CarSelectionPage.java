package com.tae.training.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarSelectionPage extends BasePage {

	public CarSelectionPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	@FindBy(how = How.ID, using="search-results")
	private WebElement carsListContainer;
	//locator for the next page
	@FindBy(how = How.ID, using = "trip-summary")
	private WebElement tripSummarySection;
	
	//book-container
	public ReviewAndBookPage selectACar(){
		/*getWait().until(ExpectedConditions.refreshed(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.tagName("li"))));*/
		List<WebElement> carsList = carsListContainer.findElements(By.className("book-container"));
		for (WebElement carOptions: carsList){
			carOptions.findElement(By.tagName("a")).click();
			break;
		}
		getWait().until(ExpectedConditions.visibilityOf(tripSummarySection));
		return new ReviewAndBookPage(getDriver());
	}

}
