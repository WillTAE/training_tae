package com.tae.training.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.css.Counter;

public class ReviewYourTripPage extends BasePage {

	public ReviewYourTripPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	//@FindBy(how = How.XPATH, using = "'//*[@class='packagePriceTotal' and @type='hidden']'")
	//private WebElement totalPriceLabel;
	
	@FindBy(css=".tripTotalPrice.visuallyhidden")
	private WebElement totalPriceLabel;
	
	//xpath: /html/body/main/section[1]/div/div[1]/div/div/div[1]/ol
	@FindBy(how = How.CSS, using = "div.dateAndOD.cf > ol")
	private WebElement informationTable;
	
	@FindBy(how = How.CLASS_NAME, using = "priceGuarantee")
	private WebElement priceGuranteeText;
	
	@FindBy(how = How.CLASS_NAME, using = "nobullet")
	private WebElement orderedListTripInfo;
	
	@FindBy(how = How.CLASS_NAME, using = "section-header-main")
	private WebElement pageTitle;
	
	@FindBy(how = How.ID, using = "bookButton")
	private WebElement bookingButton;
	
	
	public boolean verifyTotalPriceIsPresent(){
		boolean totalPricePresent = false;
		System.out.println("Texto: "+totalPriceLabel.getText());
		if (totalPriceLabel.getText() != null){
			totalPricePresent = true;
		}
		return totalPricePresent;
	}
	
	public boolean verifyDepartAndReturnInfoIsPresent(){
		boolean departAndReturnInfoIsPresent = false;
		getWait().until(ExpectedConditions.visibilityOf(pageTitle));
		List<WebElement> tableRows = informationTable.findElements(By.className("type-300"));
		for(WebElement row: tableRows){
			if (row.findElement(By.xpath("//section[@class='flightSummaryContainer uitk-col']/div/div[1]//ol[@class='odPair nobullet']/li[1]/span[2]")).getText() != null && 
					row.findElement(By.xpath("//section[@class='flightSummaryContainer uitk-col']/div/div[1]//ol[@class='odPair nobullet']/li[2]/span[2]")).getText() != null){
				departAndReturnInfoIsPresent = true;
			}
		}
		return departAndReturnInfoIsPresent;
	}
	
	public boolean verifyPriceGuaranteeTextIsPresent(){
		boolean priceGuaranteeIsPresent = false;
		getWait().until(ExpectedConditions.visibilityOf(pageTitle));
		if(priceGuranteeText.getText() != null){
			priceGuaranteeIsPresent = true;
		}
		return priceGuaranteeIsPresent;
	}
	
	public WhoIsTravelingPage navigateToWhoIsTraveling(){
		bookingButton.click();
		return new WhoIsTravelingPage(getDriver());
	}

}
