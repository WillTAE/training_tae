package com.tae.training.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightsPage extends BasePage {

	public FlightsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.ID, using="primary-header-flight")
	private WebElement flightMenuOption;
	
	@FindBy(how = How.ID, using="tab-flightHotel-tab-flp-fh")
	private WebElement flightPlusHotelTab;
	
	@FindBy(how = How.ID, using="package-origin-flp-fh")
	private WebElement flyingFromField;
	
	@FindBy(how = How.ID, using="package-destination-flp-fh")
	private WebElement flyingToField;
	
	@FindBy(how = How.ID, using="package-departing-flp-fh")
	private WebElement departingDate;
	
	@FindBy(how = How.ID, using="package-returning-flp-fh")
	private WebElement arrivingDate;
	
	@FindBy(how = How.ID, using="partialHotelBooking-flp-fh")
	private WebElement onlyHotelCheckbox;

    @FindBy(how = How.ID, using="package-checkin-flp-fh")
	private WebElement checkinDepartingDate;
	
    @FindBy(how = How.ID, using="package-checkout-flp-fh")
	private WebElement checkoutArrivingDate;
    
    @FindBy(how = How.ID, using="search-button-flp-fh")
	private WebElement searchFlightsButton;
    
    @FindBy(xpath="//*[@id='package-departing-wrapper-flp-fh']/div/div/div[2]")
	private WebElement flyingFromCalendar;
	
	@FindBy(xpath="//*[@id='package-returning-wrapper-flp-fh']/div/div")
	private WebElement flyingToCalendar;
	
	@FindBy(xpath="//*[@id='package-checkin-wrapper-flp-fh']/div/div/div[2]")
	private WebElement checkinCalendar;
	
	@FindBy(xpath="//*[@id='package-checkout-wrapper-flp-fh']/div/div")
	private WebElement checkoutCalendar;
	
	@FindBy(how=How.XPATH, using="//*[@id='package-departing-wrapper-flp-fh']/div/div/button[2]")
	private WebElement datePickerRightArrow;
	
	@FindBy(how = How.CLASS_NAME, using="error-link")
	private WebElement errorLinkMessage;
    
	public ResultOnlyFlightsPage searchFlight(String flyingFrom, String flyingTo, String departingDay, String returningDay, String checkinDay, String checkoutDay){
		flightMenuOption.click();
		flightPlusHotelTab.click();
		flyingFromField.clear();
		flyingFromField.sendKeys(flyingFrom);
		flyingToField.clear();
		flyingToField.sendKeys(flyingTo);
		
		departingDate.clear();
		departingDate.click();
		datePickerRightArrow.click();
		datePickerRightArrow.click();
		List<WebElement> columns = flyingFromCalendar.findElements(By.tagName("td")); 
		for(WebElement cells: columns){
			if(cells.getText().equals(departingDay)){
				cells.click();
				break;
			}
		}
		arrivingDate.clear();
		arrivingDate.click();
		List<WebElement> columnsB = flyingToCalendar.findElements(By.tagName("td"));
		for(WebElement cell2: columnsB){
			if(cell2.getText().equals(returningDay)){
				cell2.click();
				break;
			}
		}
		onlyHotelCheckbox.click();
		
		getWait().until(ExpectedConditions.elementToBeClickable(checkinDepartingDate));
		checkinDepartingDate.clear();
		checkinDepartingDate.click();
		List<WebElement> columnsCheckIn = checkinCalendar.findElements(By.tagName("td")); 
		for(WebElement cells: columnsCheckIn){
			if(cells.getText().equals(checkinDay)){
				cells.click();
				break;
			}
		}
		checkoutArrivingDate.clear();
		checkoutArrivingDate.click();
		List<WebElement> columnsCheckout = checkoutCalendar.findElements(By.tagName("td")); 
		for(WebElement cells: columnsCheckout){
			if(cells.getText().equals(checkinDay)){
				cells.click();
				break;
			}
		}
		
		searchFlightsButton.click();
		
		
		return new ResultOnlyFlightsPage(getDriver());
	}
	
	public boolean isErrorMessageDisplayed(){
		getWait().until(ExpectedConditions.visibilityOf(errorLinkMessage));
		return errorLinkMessage.isDisplayed();
	}
	
	public String getErrorMessageText(){
		if(!isErrorMessageDisplayed()){
			new Exception("The Error message was not shown on only Flight reserve");  
		}
		return errorLinkMessage.getText();
	}

}
