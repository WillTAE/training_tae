package com.tae.training.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeparturesPage extends BasePage {

	public DeparturesPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	@FindBy(how = How.NAME, using = "sort")
	private WebElement priceDropdown;

	@FindBy(how = How.ID, using = "flightModuleList")
	private WebElement resultsListPanel;

	@FindBy(how = How.CLASS_NAME, using = "t-select-btn")
	private WebElement selectButton;
	
	@FindBy(how = How.CLASS_NAME, using = "modal-inner")
	private WebElement modalHotelPlusNoThanks;
	
	@FindBy(how = How.ID, using = "forcedChoiceNoThanks")
	private WebElement choiceNoThanks;
	
	List<WebElement> resultRows = resultsListPanel.findElements(By.className("flex-card-offer"));
	
	public ReviewYourTripPage selectingReturning(){
		getWait().until(ExpectedConditions.elementToBeClickable(priceDropdown));
		for(int i=0; i<resultRows.size()-1; i++){
			if(i == 2){
				WebElement panelForElement = (WebElement)resultRows.get(i);
				WebElement elementToSelect = panelForElement.findElement(By.className("t-select-btn"));
				System.out.println("Element to Select label: "+elementToSelect.getText());
				elementToSelect.click();
				break;
			}
			
		}
		String handle = getDriver().getWindowHandle();
		String subHandle = null;
		Set<String> handles = getDriver().getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while(iterator.hasNext()){
			subHandle = iterator.next();
		}
		getDriver().switchTo().window(subHandle);
		choiceNoThanks.click();
		getDriver().switchTo().window(handle);
		
		ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
		System.out.println("Número de Tabs: "+tabs);
		getDriver().switchTo().window((String) tabs.get(0));
		
		return new ReviewYourTripPage(getDriver()); 
	}

}
