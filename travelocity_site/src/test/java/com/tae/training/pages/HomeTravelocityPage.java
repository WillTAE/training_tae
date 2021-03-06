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

	public FlightHotelPage getFlightHotelPage(WebDriver driver) {
		return new FlightHotelPage(driver);
	}
	
	public SelectedHotelPage getSelectedHotelPage(WebDriver driver){
		return new SelectedHotelPage(driver);
	}
	
	public DeparturesFlightHotelPage getDeparturesFlightHotelPage(WebDriver driver){
		return new DeparturesFlightHotelPage(getDriver());
	}
	
	public ReturningFlightHotelPage getReturningFlightHotelPage(WebDriver driver){
		return new ReturningFlightHotelPage(getDriver());
	}
	
	public CarSelectionPage getCarSelectionPage(WebDriver driver){
		return new CarSelectionPage(getDriver());
	}
	
	public ReviewAndBookPage getReviewAndBookPage(WebDriver driver){
		return new ReviewAndBookPage(getDriver());
	}
	
	public HotelsPage getHotelsPage(WebDriver driver){
		return new HotelsPage(getDriver());
	}
	
	public ResultsHotelOnlyPage getResultsHotelOnlyPage(WebDriver driver){
		return new ResultsHotelOnlyPage(getDriver());
	}
	
	public FlightsPage getFlightsPage(WebDriver driver){
		return new FlightsPage(getDriver());
	}
	
	public CruisesPage getCruisesPage(WebDriver driver){
		return new CruisesPage(getDriver());
	}
	
	public CruisesResultPage getCruisesResultPage(WebDriver driver){
		return new CruisesResultPage(getDriver());
	}
}
