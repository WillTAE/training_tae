package com.tae.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelsPage extends BasePage {

	public HotelsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.ID, using="primary-header-hotel")
	private WebElement hotelsMenuOption;

	@FindBy(how = How.ID, using="tab-hotel-tab-hlp")
	private WebElement hotelOnlyTab;
	
	@FindBy(how=How.XPATH, using=".//*[@id='gcw-hotel-form-hlp']/div[8]/label/button")
	private WebElement hotelOnlySearchButton;
	//.btn-primary.btn-action.gcw-submit
	/*@FindBy(how=How.CSS, using=".btn-primary.btn-action.gcw-submit")
	private WebElement hotelOnlySearchButton;*/
	
	@FindBy(how = How.CSS, using="#hotel-destination-hlp")
	private WebElement inputField;
	
	@FindBy(how=How.XPATH, using=".//*[@id='aria-option-0']/b[1]")
	private WebElement selectingFirsOption;
	  
	/*@FindBy(how=How.XPATH, using=".//*[@id='resultsContainer']/section/div/div[2]/div")
	private WebElement selectingFirsOption;*/
	
	@FindBy(how = How.ID, using="mer-signup-toggle-btn")
	private WebElement discountSection;
	
	public ResultsHotelOnlyPage searchOnlyHotel(String cityToSearch){
		hotelsMenuOption.click();
		hotelOnlyTab.click();
		inputField.clear();
		inputField.sendKeys(cityToSearch);
		selectingFirsOption.click();
		getWait().until(ExpectedConditions.elementToBeClickable(hotelOnlySearchButton));
		hotelOnlySearchButton.click();
		getWait().until(ExpectedConditions.visibilityOf(discountSection));
		return new ResultsHotelOnlyPage(getDriver());
	}

}
