package com.tae.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReviewYourTripPage extends BasePage {

	public ReviewYourTripPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "packagePriceTotal")
	private WebElement totalPriceLabel;
	
	@FindBy(how = How.CSS, using = "span.airport.type-300")
	private WebElement departureInformation;
	
	@FindBy(how = How.CSS, using = "span.airport.type-300")
	private WebElement returningInformation;
	
	@FindBy(how = How.CSS, using = "div.dateAndOD.cf > ol")
	private WebElement informationTable;
	
	@FindBy(how = How.CLASS_NAME, using = "priceGuarantee")
	private WebElement priceGuranteeText;
	
	@FindBy(how = How.ID, using = "bookButton")
	private WebElement bookingButton;
	
	public boolean verifyTotalPricePresent(){
		boolean totalPricePresent = false;
		if (totalPriceLabel.getText() != null){
			totalPricePresent = true;
		}
		return totalPricePresent;
	}
	
	public WhoIsTravelingPage navigateToWhoIsTraveling(){
		
		return new WhoIsTravelingPage(getDriver());
	}

}
