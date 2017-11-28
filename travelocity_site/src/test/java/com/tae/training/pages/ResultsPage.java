package com.tae.training.pages;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class ResultsPage extends BasePage {

	public ResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CLASS_NAME, using = "title-city-text")
	private WebElement resultsPageTitle;

	@FindBy(how = How.NAME, using = "sort")
	private WebElement priceDropdown;

	@FindBy(how = How.ID, using = "flightModuleList")
	private WebElement resultsListPanel;

	@FindBy(how = How.CLASS_NAME, using = "t-select-btn")
	private WebElement selectButton;

	@FindBy(how = How.CLASS_NAME, using = "primary duration-emphasis")
	private WebElement flightDurationLabel;

	@FindBy(how = How.CLASS_NAME, using = "btn-label")
	private WebElement selectFlightPlusHotelLabel;

	List<WebElement> resultRows = resultsListPanel.findElements(By.className("flex-card-offer"));

	public String getResultsPageTitle() {
		return resultsPageTitle.getText();
	}

	public boolean verifyPriceDropdownIsPresent() {
		getWait().until(ExpectedConditions.visibilityOf(resultsListPanel));
		return priceDropdown.isDisplayed();
	}

	public boolean verifySelectButtonsPresent() {
		boolean selectsPresent = false;
		getWait().until(ExpectedConditions.visibilityOf(resultsListPanel));
		getWait().until(ExpectedConditions.elementToBeClickable(priceDropdown));
		getWait().withTimeout(40, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(selectButton));
		List<WebElement> resultRows = resultsListPanel.findElements(By.className("flex-card-offer"));
		System.out.println("número de panels: " + resultRows.size());
		if (resultRows.size() > 0)
			selectsPresent = true;
		for (WebElement panelRow : resultRows) {
			if (panelRow.findElement(By.className("t-select-btn")) != null) {
				selectsPresent = true;
			}
		}
		return selectsPresent;
	}

	public boolean verifyFlightDurationLabels() {
		boolean flightDurationIsPresent = false;
		getWait().until(ExpectedConditions.visibilityOf(resultsListPanel));
		List<WebElement> resultRows = resultsListPanel.findElements(By.className("flex-card-offer"));
		if (resultRows.size() > 0)
			flightDurationIsPresent = true;
		for (WebElement panelRow : resultRows) {
			if (panelRow.findElement(By.className("duration-emphasis")) != null) {
				flightDurationIsPresent = true;
			}
		}
		return flightDurationIsPresent;
	}

	public boolean verifyFlighDetailsAndBaggageFee() {
		boolean flighDetailIsPresent = false;
		getWait().until(ExpectedConditions.visibilityOf(resultsListPanel));
		for (WebElement panelRow : resultRows) {
			if (panelRow.findElements(By.className("show-flight-details")) != null) {
				flighDetailIsPresent = true;
			}
		}
		return flighDetailIsPresent;
	}

	public boolean verifyListCorrectlySorted(){
		boolean listCorrectlySorted = false;
		Duration lastDuration = Duration.ZERO;
		getWait().withTimeout(50, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(priceDropdown));
		getWait().until(ExpectedConditions.visibilityOf(resultsListPanel));
		Select selectDropdown = new Select(priceDropdown);
		selectDropdown.selectByIndex(2);
		if(getDriver().getWindowHandles().toArray().length > 1){
			getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
			getDriver().close();
			getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
		}
		getWait().until(ExpectedConditions.visibilityOf(resultsListPanel));
		List<WebElement> resultRows = resultsListPanel.findElements(By.className("flex-card-offer"));
		System.out.println("ResultRows size: "+resultRows.size());
		for(int i = 0; i<resultRows.size()-1; i++){
			WebElement webElement = (WebElement)resultRows.get(i);
			WebElement nextWebElement = null;
			if(i != resultRows.size()){
				nextWebElement = (WebElement)resultRows.get(i+1);
			}
			if(nextWebElement != null){
				String currentTime = webElement.findElement(By.className("duration-emphasis")).getText();
				int posH = currentTime.indexOf("h");
				int posM = currentTime.indexOf("m");
				String numCurrentHours = currentTime.substring(0, posH).trim();
				String numCurrentMins = currentTime.substring(3, posM).trim();
				
				int hours = Integer.parseInt(numCurrentHours);
				int mins = Integer.parseInt(numCurrentMins);
				Duration duration =	Duration.ofMinutes( hours * 60 + mins);
			 	if ( duration.compareTo(lastDuration)< 0 ){
						 listCorrectlySorted = false;
						 break;
					 }
				lastDuration = duration;
			}
			listCorrectlySorted = true;
		}
		return listCorrectlySorted;
		
	}
	
	public DeparturesPage selectingDeparture(){
		getWait().until(ExpectedConditions.elementToBeClickable(priceDropdown));
		List<WebElement> resultRows = resultsListPanel.findElements(By.className("flex-card-offer"));
		for(int i=0; i<resultRows.size()-1; i++){
			if(i == 0){
				WebElement panelForElement = (WebElement)resultRows.get(i);
				WebElement elementToSelect = panelForElement.findElement(By.className("t-select-btn"));
				System.out.println("Element to Select label: "+elementToSelect.getText());
				elementToSelect.click();
				if(getDriver().getWindowHandles().toArray().length > 1){
					getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
					getDriver().close();
					getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
				}
				break;
			}
			
		}
		
		return new DeparturesPage(getDriver()); 
	}

}

/*if(getDriver().getWindowHandles().toArray().length > 1){
getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
getDriver().close();
getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
}*/
