package com.tae.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tae.training.pages.DeparturesPage;
import com.tae.training.pages.FlightHotelPage;
import com.tae.training.pages.HomeTravelocityPage;
import com.tae.training.pages.ResultFlightHotelsPage;
import com.tae.training.pages.ResultFlightsPage;
import com.tae.training.pages.ReviewYourTripPage;
import com.tae.training.pages.WhoIsTravelingPage;

public class TestTravelocity extends BaseTest {
	
	SoftAssert softAssert = new SoftAssert(); 
	
	
	//@Test
	public void exercise1(){
		HomeTravelocityPage homeTravelocityPage = getHomeTravelocityPage();
		ResultFlightsPage resultFlightsPage = homeTravelocityPage.searchFlights("LAS","LAX","20","1");
		assertEquals(resultFlightsPage.getResultsPageTitle(), "Select your departure to Los Angeles");
		assertTrue(resultFlightsPage.verifyPriceDropdownIsPresent());
		//assertTrue(resultFlightsPage.verifySelectButtonsPresent());
		//assertTrue(resultFlightsPage.verifyFlightDurationLabels());
		//assertTrue(resultFlightsPage.verifyFlighDetailsAndBaggageFee());
		//assertTrue(resultFlightsPage.verifyListCorrectlySorted());
		
		DeparturesPage departuresPage = resultFlightsPage.selectingDeparture();
		
		ReviewYourTripPage reviewYourTripPage = departuresPage.selectReturning();
		assertTrue(reviewYourTripPage.verifyTotalPriceIsPresent());
		assertTrue(reviewYourTripPage.verifyDepartAndReturnInfoIsPresent());
		assertTrue(reviewYourTripPage.verifyPriceGuaranteeTextIsPresent());
		
		WhoIsTravelingPage whoIsTraveling = reviewYourTripPage.navigateToWhoIsTraveling();
		softAssert.assertTrue(whoIsTraveling.verifyFormTitleIsPresent(), "Form title in WhoIsTraveling Page is not present");
		assertTrue(whoIsTraveling.verifyOriginAndDestinyIsPresent());
		assertTrue(whoIsTraveling.verifyGenericPageHeaderIsPresent());
		assertTrue(whoIsTraveling.verifyDateOfTripIsPresent());
		assertTrue(whoIsTraveling.verifyTravelerNameFieldIsPresent());
	}
	
	@Test
	public void exercise2(){
		
		HomeTravelocityPage homeTravelocityPage = getHomeTravelocityPage();
		FlightHotelPage flightHotelPage = homeTravelocityPage.getFlightHotelPage(homeTravelocityPage.getDriver());
		ResultFlightHotelsPage resultFlightHotelsPage = flightHotelPage.searchFlightHotelAndCar("LAS", "LAX", "28", "10");
		softAssert.assertTrue(resultFlightHotelsPage.hotelMenuOptionIsSelected(), "Hotel Menu Option is not selected");
		softAssert.assertTrue(resultFlightHotelsPage.sortContainerIsPresent(), "Not able to verify Sort Container");
		softAssert.assertTrue(resultFlightHotelsPage.searchWizardPanelIsPresent(), "Not able to verify Wizard Panel with trip info");
		softAssert.assertTrue(resultFlightHotelsPage.searchByPropertyBoxIsPresent(), "Not able to verify Search Hotel input is present");
		softAssert.assertTrue(resultFlightHotelsPage.submitHotelGoButtonDisabled(), "Not able to verify if Go button is disabled");
		
		resultFlightHotelsPage.sortingHotelsByPrice();
	}
}
