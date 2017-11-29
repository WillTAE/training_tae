package com.tae.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import javax.annotation.Generated;

import org.testng.annotations.Test;

import com.tae.training.pages.DeparturesPage;
import com.tae.training.pages.HomeTravelocityPage;
import com.tae.training.pages.ResultFlightsPage;
import com.tae.training.pages.ReviewYourTripPage;
import com.tae.training.pages.WhoIsTravelingPage;

public class TestTravelocity extends BaseTest {
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
		assertTrue(whoIsTraveling.verifyFormTitleIsPresent());
		assertTrue(whoIsTraveling.verifyOriginAndDestinyIsPresent());
		assertTrue(whoIsTraveling.verifyGenericPageHeaderIsPresent());
		assertTrue(whoIsTraveling.verifyDateOfTripIsPresent());
		assertTrue(whoIsTraveling.verifyTravelerNameFieldIsPresent());
	}
	
	@Test
	public void exercise2(){
		HomeTravelocityPage homeTravelocityPage = getHomeTravelocityPage();
		homeTravelocityPage.searchFlightHotelAndCar("LAS", "LAX", "28", "10");
		
	}
}
