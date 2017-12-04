package com.tae.training.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectedHotelPage extends BasePage {

	public SelectedHotelPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.ID, using = "hotel-name")
	private WebElement hotelNameLabel;
	
	@FindBy(how = How.CLASS_NAME, using = "star-rating-wrapper")
	private WebElement starsWrapper;
	
	@FindBy(how = How.ID, using = "rooms-and-rates")
	private WebElement hotelRoomsContainer;
	
	public String getHotelNameLabel(){
		getWait().until(ExpectedConditions.visibilityOf(hotelNameLabel));
		return hotelNameLabel.getText();
	}
	
	public String getStarsNumber(){
		getWait().until(ExpectedConditions.visibilityOf(starsWrapper));
		return starsWrapper.findElement(By.className("value-title")).getAttribute("title").toString();
	}
	
	public DeparturesFlightHotelPage selectFirstRoom(){
		getWait().until(ExpectedConditions.refreshed(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.className("room-above-fold"))));
		List<WebElement> roomPanel = hotelRoomsContainer.findElements(By.className("room-above-fold"));
		for(WebElement room: roomPanel){
			room.findElement(By.className("book-button-wrapper")).click();
			break;
		}
		return new DeparturesFlightHotelPage(getDriver());
	}
}
