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
	
	//book-container
	public ReviewAndBookPage selectACar(){
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.className("listing-wrapper"))));
		List<WebElement> carsList = carsListContainer.findElements(By.className("listing-wrapper"));
		for (WebElement carOptions: carsList){
			carOptions.findElement(By.tagName("a")).click();
			break;
		}
		return new ReviewAndBookPage(getDriver());
	}

}
