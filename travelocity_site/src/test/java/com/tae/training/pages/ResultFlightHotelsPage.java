package com.tae.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.tae.training.pages.Utils;

public class ResultFlightHotelsPage extends BasePage {

	public ResultFlightHotelsPage(WebDriver driver) {
		super(driver);
	}
	
	Utils utils = new Utils();
	
	@FindBy(how = How.ID, using = "resultsContainer")
	private WebElement resultsContainer;
	
	@FindBy(how = How.CLASS_NAME, using = "msi-active-state")
	private WebElement hotelMenuOption;
	
	@FindBy(how = How.ID, using = "sortContainer")
	private WebElement sortContainer;
	
	//Panel to find the Origin and Destination information
	@FindBy(how = How.ID, using = "searchWizard")
	private WebElement searchWizardPanel;
	
	@FindBy(how = How.ID, using = "inpHotelNameMirror")
	private WebElement searchByPropertyNameBox;
	
	@FindBy(how = How.CLASS_NAME, using = "submitHotelName")
	private WebElement submitHotelGoButton;
	
	/*@FindBy(how = How.ID, using = "//*[@id='sortContainer']/div/div/div[2]/div/fieldset/ul/li[3]/button")
	private WebElement sortButton;*/
	
	@FindBy(how = How.CSS, using = ".btn-sort.tab")
	private WebElement sortButton;
	
	public boolean hotelMenuOptionIsSelected(){
		boolean hotelMenuOptionSelected = false;
		if(hotelMenuOption.isSelected()) hotelMenuOptionSelected = true;
		System.out.println("I did the first assert of the exercise2!");
		return hotelMenuOptionSelected;
	}
	
	public boolean sortContainerIsPresent(){
		boolean sortContainerIsPresent = false;
		if(sortContainer.isDisplayed()) sortContainerIsPresent = true;
		System.out.println("I did the second assert of the exercise2!");
		return sortContainerIsPresent;
	}
	
	public boolean searchWizardPanelIsPresent(){
		boolean wizardPanelInfoIsPresent = false;
		if(searchWizardPanel.isDisplayed()) wizardPanelInfoIsPresent = true;
		return wizardPanelInfoIsPresent;
	}
	
	public boolean searchByPropertyBoxIsPresent(){
		boolean searchByPropertyBoxIsPresent = false;
		if(searchByPropertyNameBox.isDisplayed()) searchByPropertyBoxIsPresent = true;
		return searchByPropertyBoxIsPresent;
	}
	
	public boolean submitHotelGoButtonDisabled(){
		boolean submitHotelGoButtonPresent = false;
		if(!submitHotelGoButton.isEnabled()) submitHotelGoButtonPresent = true;
		return submitHotelGoButtonPresent;
	}
	
	public void sortingHotelsByPrice(){
		sortButton.click();
		utils.waitForLoad(getDriver());
		
	}
	
	
}
