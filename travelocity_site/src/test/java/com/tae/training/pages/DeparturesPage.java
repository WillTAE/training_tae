package com.tae.training.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
	
	public ReviewYourTripPage selectReturning(){
		getWait().until(ExpectedConditions.elementToBeClickable(priceDropdown));
		getWait().withTimeout(40, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(resultsListPanel));
		for(int i=0; i<resultRows.size()-1; i++){
			if(i == 2){
				WebElement panelForElement = (WebElement)resultRows.get(i);
				getWait().until(ExpectedConditions.visibilityOf(resultsListPanel));
				getWait().withTimeout(20, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(selectButton));
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
		/*String handle = getDriver().getWindowHandle();
		String subHandle = null;
		Set<String> handles = getDriver().getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while(iterator.hasNext()){
			subHandle = iterator.next();
		}
		getDriver().switchTo().window(subHandle);*/
		getWait().withTimeout(10, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(modalHotelPlusNoThanks));
		choiceNoThanks.click();
		//getDriver().switchTo().window(handle);
		
		ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
		System.out.println("Número de Tabs: "+ tabs.size());
		getDriver().switchTo().window((String) tabs.get(1));
		//getDriver().switchTo().window((String) tabs.get(0)).close();
		return new ReviewYourTripPage(getDriver()); 
	}

}
