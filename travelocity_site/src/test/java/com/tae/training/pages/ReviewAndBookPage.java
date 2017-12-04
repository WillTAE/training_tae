package com.tae.training.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReviewAndBookPage extends BasePage {

	public ReviewAndBookPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.ID, using = "trip-summary")
	private WebElement tripSummarySection;
	
	private ArrayList<String> arrayTripInfo = new ArrayList<String>();
	public ArrayList<String> verifyTripLocationInfo(){
		List<WebElement> sectionsList = tripSummarySection.findElements(By.className("summary"));
		for(int i=0; i<=sectionsList.size(); i++){
			if (i == 0) arrayTripInfo.add(sectionsList.get(i).findElement(By.className("location-info")).getText());
			if (i == 1) arrayTripInfo.add(sectionsList.get(i).findElement(By.className("date-info")).getText());
			if (i == 2) arrayTripInfo.add(sectionsList.get(i).findElement(By.className("product-description")).getText());
			break;
		}
		return arrayTripInfo;
	}

}
