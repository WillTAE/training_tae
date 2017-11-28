package com.tae.training.pages;

import static org.testng.Assert.expectThrows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WhoIsTravelingPage extends BasePage {

	public WhoIsTravelingPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "location-info")
	private WebElement originAndDestinyInfo;
	
	@FindBy(how = How.CLASS_NAME, using = "totalPriceForTrip")
	private WebElement totalPriceForTrip;
	
	@FindBy(how = How.CLASS_NAME, using = "generic-header")
	private WebElement genericPageHeader;
	
	@FindBy(className= "faceoff-module-title")
	private WebElement formTitle;
	
	public boolean verifyFormTitleIsPresent(){
		boolean formTitlePresent = false;
		getWait().until(ExpectedConditions.visibilityOf(genericPageHeader));
		if(formTitle.getText()!=null) formTitlePresent = true;
		return formTitlePresent; 
	}
	
	public boolean verifyOriginAndDestinyIsPresent(){
		boolean formTitlePresent = false;
		getWait().until(ExpectedConditions.visibilityOf(genericPageHeader));
		if(originAndDestinyInfo.getText()!=null) formTitlePresent = true;
		return formTitlePresent; 
	}
	
	public boolean verifyGenericPageHeaderIsPresent(){
		boolean formTitlePresent = false;
		getWait().until(ExpectedConditions.visibilityOf(genericPageHeader));
		if(genericPageHeader.getText()!=null) formTitlePresent = true;
		return formTitlePresent; 
	}

}
