package com.tae.training.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tae.training.pages.Utils;

public class FlightHotelPage extends BasePage {

	public FlightHotelPage(WebDriver driver) {
		super(driver);
		
	}
		Utils utils = new Utils();
	
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
		
		public ResultFlightHotelsPage searchFlightHotelAndCar(String departingTo, String arrivingTo, String departingDay, String returningDay){
			if(getDriver().getWindowHandles().toArray().length > 1){
				getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]).close();
				getDriver().close();
				getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]).close();
			}
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
			//getWait().withTimeout(40, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(resultHotelsContainer));
			utils.waitForLoad(getDriver());
			return new ResultFlightHotelsPage(getDriver());
		}

}
