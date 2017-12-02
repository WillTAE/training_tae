package com.tae.training.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReturningFlightHotelPage extends BasePage {

	public ReturningFlightHotelPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	@FindBy(how = How.ID, using="flightModuleList")
	private WebElement flightsListContainer;
	
	@FindBy(how = How.NAME, using = "sort")
	private WebElement priceDropdown;
	
	public CarSelectionPage selectThirdReturningFlight(){
		getWait().until(ExpectedConditions.elementToBeClickable(priceDropdown));
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.className("flex-card-offer"))));
		List<WebElement> flightsList = flightsListContainer.findElements(By.className("flex-card-offer"));
		for (int i=0; i<flightsList.size(); i++){
			if(i == 2){
				flightsList.get(i).findElement(By.tagName("button")).click();
				break;
			}
		}
		return new CarSelectionPage(getDriver());
	}

}
