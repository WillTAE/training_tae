package com.tae.training.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CruisesResultPage extends BasePage {

	public CruisesResultPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.ID, using = "destination-select")
	private WebElement selectedGoingTo;
	
	@FindBy(how = How.ID, using = "departure-month-select")
	private WebElement selectedDepartureDate;
	
	@FindBy(how = How.ID, using = "length-10-14")
	private WebElement cruiseLenghtRadioButton;
	
	@FindBy(how = How.CLASS_NAME, using = "nobullet")
	private WebElement sortByPanel;
	
	@FindBy(how = How.ID, using = "main-results")
	private WebElement panelCruiseResults;
	
	private List<String> cruisesPriceList = new ArrayList<>();
	//strikeout-price-card
	//card-price
	//flex-card panel individual de cruceros en el panel de resultados
	
	public String getGoingToSelected(){
		getWait().until(ExpectedConditions.visibilityOf(selectedGoingTo));
		if(!selectedGoingTo.equals("Europe")){
			new Exception("The Selected Going To does not match");
		}
		return selectedGoingTo.getText();
	}
	
	public String getDepartureDateSelected(){
		getWait().until(ExpectedConditions.visibilityOf(selectedDepartureDate));
		if(!selectedGoingTo.equals("Europe")){
			new Exception("The Selected Departure Date does not match");
		}
		return selectedDepartureDate.getText();
	}
	
	public void selectCruisesLenght(){
		getWait().until(ExpectedConditions.elementToBeClickable(cruiseLenghtRadioButton));
		cruiseLenghtRadioButton.click();
		getWait().until(ExpectedConditions.visibilityOf(sortByPanel));
	}
	
	public boolean cruisesWithAndWithoutDiscount(){
		boolean areWithAndWithoutDiscountCruises = false;
		boolean pricesWithoutDiscount = false;
		boolean pricesWithDiscount = false;
		//selectCruisesLenght();
		getWait().withTimeout(5, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(cruiseLenghtRadioButton));
		List<WebElement> cruisesPanelList = panelCruiseResults.findElements(By.className("flex-card"));
		for(WebElement cruise: cruisesPanelList){
			Boolean strikePriceIsPresent = cruise.findElements(By.className("strikeout-price-card")).size() > 0;
			if(strikePriceIsPresent){
				pricesWithoutDiscount = true;
			}
			if(cruise.findElement(By.className("card-price")).getText() != null){
				pricesWithDiscount = true;
				cruisesPriceList.add(cruise.findElement(By.className("card-price")).getText());
			}
			if(!strikePriceIsPresent) continue;
		}
		if(!(pricesWithDiscount && pricesWithoutDiscount)){
			new Exception("One of both are missing prices with or without discount");
		}
		areWithAndWithoutDiscountCruises = true;
		//selectLowestCostCruise();
		return areWithAndWithoutDiscountCruises;
	}
	
	public void selectLowestCostCruise(){
		List<Float> floatPricesList = new ArrayList<>();
		for(String priceString: getCruisesPriceList()){
			String onlyValueString = priceString.substring(1, priceString.length());
			String validFloat = onlyValueString.replace(",", "");
			float onlyValueFloat = Float.parseFloat(validFloat);
			System.out.println("Cruise Value: "+onlyValueFloat);
			floatPricesList.add(onlyValueFloat);
		}
		floatPricesList.sort(Comparator.naturalOrder());
		for(int i=0; i<floatPricesList.size()-1; i++){
			System.out.println("Valores ordenados: "+floatPricesList.get(i));
			
		}
	}

	public List<String> getCruisesPriceList() {
		return cruisesPriceList;
	}
	
	

}
