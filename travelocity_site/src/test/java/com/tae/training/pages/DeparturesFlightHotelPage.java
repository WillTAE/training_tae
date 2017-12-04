package com.tae.training.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeparturesFlightHotelPage extends BasePage {

	public DeparturesFlightHotelPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	@FindBy(how = How.ID, using="flightModuleList")
	private WebElement flightsListContainer;
	
	@FindBy(how = How.NAME, using = "sort")
	private WebElement priceDropdown;
	
	@FindBy(how=How.ID, using="flightSearchResultDiv")
	private WebElement PROGRESS_BAR;
	
	@FindBy(how=How.ID, using="loaderForEmailAlertMenu")
	private WebElement pageActiveLoader;
	
	public ReturningFlightHotelPage selectFirstDepartingFlight(){
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(pageActiveLoader)));
		/*getWait().until(ExpectedConditions.refreshed(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.className("flex-card"))));*/
		List<WebElement> flightsList = flightsListContainer.findElements(By.tagName("li"));
		for (WebElement flightOptions: flightsList){
			flightOptions.findElement(By.tagName("button")).click();
			break;
		}
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(priceDropdown)));
		return new ReturningFlightHotelPage(getDriver());
	}
}
