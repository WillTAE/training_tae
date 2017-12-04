package com.tae.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		this.driver = pDriver;
		wait = new WebDriverWait(pDriver, 10);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}
	
	public void dispose(){
		if(driver != null){
			driver.quit();
		}
	}
	
}
