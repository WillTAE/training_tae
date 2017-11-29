package com.tae.training.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	
	/*@FindBy(how=How.XPATH, using="html/body/section/div/div/div/section/div[1]/div/div/div/form/div/section/div/div[1]/fieldset[2]/label[2]/input")
	private WebElement departureDay;
	
	@FindBy(how=How.XPATH, using="html/body/section/div/div/div/section/div[1]/div/div/div/form/div/section/div/div[1]/fieldset[2]/label[2]/input")
	private WebElement returnDay;*/
	
	@FindBy(how=How.ID, using="flight-adults-hp-flight")
	private WebElement flightAdultsSelector;
	
	@FindBy(how=How.CLASS_NAME, using="gcw-submit")
	private WebElement searchButton;
	
	@FindBy(how=How.XPATH, using="//*[@id='flight-departing-wrapper-hp-flight']/div/div/button[2]")
	private WebElement datePickerRightArrow;
	
	@FindBy(how=How.ID, using="flightSearchResultDiv")
	private WebElement PROGRESS_BAR;
	
	@FindBy(xpath="//*[@id='flight-departing-wrapper-hp-flight']/div/div/div[2]")
	private WebElement departingCalendar;
	
	@FindBy(xpath="//*[@id='flight-returning-wrapper-hp-flight']/div/div")
	private WebElement returningCalendar;
	
	//Flight + Hotel + Car locators
	
	@FindBy(how=How.ID, using="tab-package-tab-hp")
	private WebElement flightHotelTab;
	
	@FindBy(how=How.XPATH, using="//fieldset/label[2]/input[@value='flight-hotel-car']")
	private WebElement flightHotelCarOption;
	
	@FindBy(how=How.ID, using="package-origin-hp-package")
	private WebElement hotelFlightOriginField;
	
	@FindBy(how=How.ID, using="package-destination-hp-package")
	private WebElement hotelFlightDestinationField;
	
	@FindBy(how=How.ID, using="package-departing-hp-package")
	private WebElement hotelFieldDepartingCalendar;
	
	@FindBy(how=How.ID, using="package-returning-hp-package")
	private WebElement hotelFieldReturningCalendar;
	
	@FindBy(xpath="//*[@id='package-departing-wrapper-hp-package']/div/div/div[2]")
	private WebElement hotelDepartingCalendar;
	
	@FindBy(how=How.XPATH, using="//*[@id='package-returning-wrapper-hp-package']/div/div/div[3]")
	private WebElement hotelReturningCalendar;
	
	@FindBy(how=How.ID, using="search-button-hp-package")
	private WebElement hotelSearchButton;
	
	@FindBy(how=How.XPATH, using="//*[@id='package-departing-wrapper-hp-package']/div/div/button[2]")
	private WebElement hotelDatePickerRightArrow;
	
	@FindBy(how = How.ID, using = "resultsContainer")
	private WebElement resultHotelsContainer;
	
	//public static final By PROGRESS_BAR = By.id("flightSearchResultDiv");
	
	public ResultFlightsPage searchFlights(String departingTo, String arrivingTo, String departingDay, String returningDay){
		flighTab.click();
		flightTypeRoundtrip.click();
		flightOriginField.sendKeys(departingTo);
		flightDestinationField.sendKeys(arrivingTo);
		flightDepartingCalendar.clear();
		flightDepartingCalendar.click();
		datePickerRightArrow.click();
		datePickerRightArrow.click();
		List<WebElement> columns = departingCalendar.findElements(By.tagName("td"));
		for(WebElement cell: columns){
			if(cell.getText().equals(departingDay)){
				cell.click();
				break;
			}
		}
		flightReturningCalendar.clear();
		flightReturningCalendar.click();
		List<WebElement> columnsB = returningCalendar.findElements(By.tagName("td"));
		for(WebElement cell2: columnsB){
			if(cell2.getText().equals(returningDay)){
				cell2.click();
				break;
			}
		}
		searchButton.click();
		if(getDriver().getWindowHandles().toArray().length > 1){
			getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
			getDriver().close();
			getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
		}
		getWait().until(ExpectedConditions.visibilityOf(PROGRESS_BAR));
		return new ResultFlightsPage(getDriver());
	}
	
	public ResultFlightHotelsPage searchFlightHotelAndCar(String departingTo, String arrivingTo, String departingDay, String returningDay){
		flightHotelTab.click();
		flightHotelCarOption.click();
		hotelFlightOriginField.sendKeys(departingTo);
		hotelFlightDestinationField.sendKeys(arrivingTo);
		hotelFieldDepartingCalendar.clear();
		hotelFieldDepartingCalendar.click();
		hotelDatePickerRightArrow.click();
		hotelDatePickerRightArrow.click();
		List<WebElement> columns = hotelDepartingCalendar.findElements(By.tagName("td"));
		for(WebElement cell: columns){
			if(cell.getText().equals(departingDay)){
				cell.click();
				break;
			}
		}
		hotelFieldReturningCalendar.clear();
		hotelFieldReturningCalendar.click();
		List<WebElement> columnsB = hotelReturningCalendar.findElements(By.tagName("td"));
		for(WebElement cell2: columnsB){
			if(cell2.getText().equals(returningDay)){
				cell2.click();
				break;
			}
		}
		hotelSearchButton.click();
		if(getDriver().getWindowHandles().toArray().length > 1){
			getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
			getDriver().close();
			getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
		}
		//getWait().withTimeout(40, TimeUnit.SECONDS).
		getWait().until(ExpectedConditions.visibilityOf(resultHotelsContainer));
		return new ResultFlightHotelsPage(getDriver());
	}
	
}
