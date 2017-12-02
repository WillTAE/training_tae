package com.tae.training.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

	// Panel to find the Origin and Destination information
	@FindBy(how = How.ID, using = "searchWizard")
	private WebElement searchWizardPanel;

	@FindBy(how = How.ID, using = "inpHotelNameMirror")
	private WebElement searchByPropertyNameBox;

	@FindBy(how = How.CLASS_NAME, using = "submitHotelName")
	private WebElement submitHotelGoButton;
	
	@FindBy(how = How.CLASS_NAME, using = "flex-area-primary")
	private WebElement starsContainer;

	/*
	 * @FindBy(how = How.ID, using =
	 * "//*[@id='sortContainer']/div/div/div[2]/div/fieldset/ul/li[3]/button")
	 * private WebElement sortButton;
	 */

	@FindBy(how = How.CLASS_NAME, using = "can-we-use-modern-libraries-please")
	private WebElement hotelPricesContainer;

	@FindBy(how = How.CLASS_NAME, using = "thumbnail-container")
	private WebElement tumbnailContainer;

	public boolean hotelMenuOptionIsSelected() {
		boolean hotelMenuOptionSelected = false;
		if (hotelMenuOption.isSelected())
			hotelMenuOptionSelected = true;
		return hotelMenuOptionSelected;
	}

	public boolean sortContainerIsPresent() {
		boolean sortContainerIsPresent = false;
		if (sortContainer.isDisplayed())
			sortContainerIsPresent = true;
		return sortContainerIsPresent;
	}

	public boolean searchWizardPanelIsPresent() {
		boolean wizardPanelInfoIsPresent = false;
		if (searchWizardPanel.isDisplayed())
			wizardPanelInfoIsPresent = true;
		return wizardPanelInfoIsPresent;
	}

	public boolean searchByPropertyBoxIsPresent() {
		boolean searchByPropertyBoxIsPresent = false;
		if (searchByPropertyNameBox.isDisplayed())
			searchByPropertyBoxIsPresent = true;
		return searchByPropertyBoxIsPresent;
	}

	public boolean submitHotelGoButtonDisabled() {
		boolean submitHotelGoButtonPresent = false;
		if (!submitHotelGoButton.isEnabled())
			submitHotelGoButtonPresent = true;
		return submitHotelGoButtonPresent;
	}

	public void clickOnSortByPrice() {
		List<WebElement> listOrderOptions = sortContainer.findElements(By.tagName("button"));
		for (WebElement order : listOrderOptions) {
			if (order.getText().contains("Price")) {
				order.click();
				break;
			}
		}
		utils.waitForLoad(getDriver());
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(hotelPricesContainer)));
	}

	public boolean verifyListPricesIsCorrectlyOrdered() {
		boolean listCorrectlySorted = true;
		clickOnSortByPrice();
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.className("can-we-use-modern-libraries-please"))));
		List<Integer> listOfPrices = new ArrayList<>();
		List<WebElement> listHotelPrices = resultsContainer
				.findElements(By.className("can-we-use-modern-libraries-please"));
		System.out.println("Tamaño de la listHotelPrices: " + listHotelPrices.size());
		for (int i = 0; i < listHotelPrices.size(); i++) {
			WebElement currentElement = (WebElement) listHotelPrices.get(i);
			String currentPrice = currentElement.findElement(By.cssSelector("li.actualPrice.price.fakeLink")).getText();
			int lenghtPrice = currentPrice.length();
			String cPrice = currentPrice.substring(1, lenghtPrice);
			int cleanPrice = Integer.parseInt(cPrice);
			listOfPrices.add(cleanPrice);
		}
		for (int i = 1; i < listOfPrices.size() && (listCorrectlySorted); i++) {
			listCorrectlySorted = listCorrectlySorted && listOfPrices.get(i) >= listOfPrices.get(i - 1);
		}
		return listCorrectlySorted;
	}
	
	public void selectThreeStarsHotel(){
		List<WebElement> listOfStarPanels = resultsContainer.findElements(By.className("value-title"));
		System.out.println("Number of star Panels: "+listOfStarPanels.size());
		for(WebElement moreThanThreeStars: listOfStarPanels){
			String numOfStars = moreThanThreeStars.getAttribute("title").toString();
			float starsNumber = Float.parseFloat(numOfStars);
			System.out.println("Number in float: "+starsNumber);
			if(starsNumber >= 3){
				moreThanThreeStars.click();
				break;
			}
		}
	}

}
