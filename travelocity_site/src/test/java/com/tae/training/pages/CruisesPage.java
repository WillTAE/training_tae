package com.tae.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CruisesPage extends BasePage {

	public CruisesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "primary-header-cruise")
	private WebElement cruiseMenuOption;

	@FindBy(how = How.ID, using = "cruise-destination-cruiselp")
	private WebElement selectGoingTo;

	@FindBy(how = How.ID, using = "cruise-departure-month-cruiselp")
	private WebElement selectDepartureDate;

	@FindBy(how = How.CLASS_NAME, using = "gcw-submit")
	private WebElement cruiseSearchButton;

	public CruisesResultPage searchCruisers() {
		cruiseMenuOption.click();
		getWait().until(ExpectedConditions.elementToBeClickable(selectGoingTo));
		Select selectGoing = new Select(selectGoingTo);
		selectGoing.selectByIndex(6);
		Select selectDepart = new Select(selectDepartureDate);
		getWait().until(ExpectedConditions.elementToBeClickable(selectDepartureDate));
		selectDepart.selectByIndex(5);
		cruiseSearchButton.click();
		return new CruisesResultPage(getDriver());
	}

}
