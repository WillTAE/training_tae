package com.tae.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
	
	@FindBy(how = How.ID, using="partialHotelBooking-flp-fh")
	private WebElement onlyHotelCheckbox;

    @FindBy(how = How.ID, using="package-checkin-flp-fh")
	private WebElement checkinDepartingDate;
	
    @FindBy(how = How.ID, using="package-checkout-flp-fh")
	private WebElement checkoutArrivingDate;
    
    @FindBy(how = How.ID, using="search-button-flp-fh")
	private WebElement searchFlightsButton;
    
    @FindBy(how = How.CSS, using=".datepicker-cal-month")
	private WebElement flyingFromCalendar;
    
    @FindBy(xpath="//*[@id='package-departing-wrapper-flp-fh']/div/div/div[2]")
	private WebElement fliyingFromCalendar;
	
	@FindBy(xpath="//*[@id='package-returning-wrapper-flp-fh']/div/div")
	private WebElement fliyingToCalendar;
	
	
    
	public ResultOnlyFlightsPage searchFlight(String flyingFrom, String flyingTo, String departingDay, String returningDay, String checkinDay, String checkoutDay){
		flightMenuOption.click();
		flightPlusHotelTab.click();
		flyingFromField.clear();
		flyingFromField.sendKeys(flyingFrom);
		flyingToField.clear();
		flyingToField.sendKeys(flyingTo);
		onlyHotelCheckbox.click();
		
		
		
		
		return new ResultOnlyFlightsPage(getDriver());
	}

}
