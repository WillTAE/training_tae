package com.tae.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class HomeTravelocityPage extends BasePage{

	public HomeTravelocityPage(WebDriver driver) {
		super(driver);
		driver.get("https://www.travelocity.com/");
		driver.manage().window().maximize();
	}
	
	@FindBy(how=How.ID, using="tab-flight-tab-hp")
	private WebElement flighTab;
	
	@FindBy(how=How.ID, using="flight-type-roundtrip-label-hp-flight")
	private WebElement flightTypeRoundtrip;
	
	@FindBy(how=How.ID, using="flight-origin-hp-flight")
	private WebElement flightOriginField;
	
	@FindBy(how=How.ID, using="flight-destination-hp-flight")
	private WebElement flightDestinationField;
	
	@FindBy(how=How.ID, using="flight-departing-hp-flight")
	private WebElement flightDepartingCalendar;
	
	@FindBy(how=How.ID, using="flight-returning-hp-flight")
	private WebElement flightReturningCalendar;
	
	@FindBy(how=How.XPATH, using="html/body/section/div/div/div/section/div[1]/div/div/div/form/div/section/div/div[1]/fieldset[2]/label[2]/input")
	private WebElement departureDay;
	
	@FindBy(how=How.XPATH, using="html/body/section/div/div/div/section/div[1]/div/div/div/form/div/section/div/div[1]/fieldset[2]/label[2]/input")
	private WebElement returnDay;
	
	@FindBy(how=How.ID, using="flight-adults-hp-flight")
	private WebElement flightAdultsSelector;
	
	@FindBy(how=How.CLASS_NAME, using="btn-primary")
	private WebElement searchButton;
	
	public ResultsPage searchFlights(){
		flighTab.click();
		flightTypeRoundtrip.click();
		flightOriginField.sendKeys("LAS");
		flightDestinationField.sendKeys("LAX");
		searchButton.click();
		return new ResultsPage(getDriver());
	}
}
