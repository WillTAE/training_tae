package com.tae.training.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReturningFlightHotelPage extends BasePage {

	public ReturningFlightHotelPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.ID, using="flightModuleList")
	private WebElement flightsListContainer;
	
	@FindBy(how = How.NAME, using = "sort")
	private WebElement priceDropdown;
	
	@FindBy(how = How.CLASS_NAME, using = "loader-animated")
	private WebElement carsActiveLoader;
	//price-button-wrapper
	public CarSelectionPage selectThirdReturningFlight(){
		getWait().withTimeout(80, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(priceDropdown));
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.className("price-button-wrapper"))));
		List<WebElement> flightsList = flightsListContainer.findElements(By.className("price-button-wrapper"));
		int i = 0;
		for (WebElement flight: flightsList){
			if(i == 2){
				flight.findElement(By.className("t-select-btn")).click();
				break;
			}
			i++;
		}
		getWait().until(ExpectedConditions.invisibilityOf(carsActiveLoader));
		return new CarSelectionPage(getDriver());
	}

}
