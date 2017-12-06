package com.tae.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tae.training.pages.CarSelectionPage;
import com.tae.training.pages.DeparturesFlightHotelPage;
import com.tae.training.pages.DeparturesPage;
import com.tae.training.pages.FlightHotelPage;
import com.tae.training.pages.FlightsPage;
import com.tae.training.pages.HomeTravelocityPage;
import com.tae.training.pages.HotelsPage;
import com.tae.training.pages.ResultFlightHotelsPage;
import com.tae.training.pages.ResultFlightsPage;
import com.tae.training.pages.ResultsHotelOnlyPage;
import com.tae.training.pages.ReturningFlightHotelPage;
import com.tae.training.pages.ReviewAndBookPage;
import com.tae.training.pages.ReviewYourTripPage;
import com.tae.training.pages.SelectedHotelPage;
import com.tae.training.pages.WhoIsTravelingPage;

public class TestTravelocity extends BaseTest {
	
	SoftAssert softAssert = new SoftAssert(); 
	
	
	@Test
	public void exercise1(){
		HomeTravelocityPage homeTravelocityPage = getHomeTravelocityPage();
		ResultFlightsPage resultFlightsPage = homeTravelocityPage.searchFlights("LAS","LAX","20","1");
		assertEquals(resultFlightsPage.getResultsPageTitle(), "Select your departure to Los Angeles");
		assertTrue(resultFlightsPage.verifyPriceDropdownIsPresent());
		softAssert.assertTrue(resultFlightsPage.verifySelectButtonsPresent(), "Not able to validate Select Buttons");
		softAssert.assertTrue(resultFlightsPage.verifyFlightDurationLabels(), "Not able to validate Flight Durations");
		softAssert.assertTrue(resultFlightsPage.verifyFlighDetailsAndBaggageFee(), "Not able to validate BaggageFee");
		softAssert.assertTrue(resultFlightsPage.verifyListCorrectlySorted(), "Not able to validate Flights list correctly sorted");
		
		DeparturesPage departuresPage = resultFlightsPage.selectingDeparture();
		
		ReviewYourTripPage reviewYourTripPage = departuresPage.selectReturning();
		assertTrue(reviewYourTripPage.verifyTotalPriceIsPresent());
		assertTrue(reviewYourTripPage.verifyDepartAndReturnInfoIsPresent());
		assertTrue(reviewYourTripPage.verifyPriceGuaranteeTextIsPresent());
		
		WhoIsTravelingPage whoIsTraveling = reviewYourTripPage.navigateToWhoIsTraveling();
		softAssert.assertTrue(whoIsTraveling.verifyFormTitleIsPresent(), "Form title in WhoIsTraveling Page is not present");
		softAssert.assertTrue(whoIsTraveling.verifyOriginAndDestinyIsPresent(), "Not able to verify Origin And Destiny Label");
		softAssert.assertTrue(whoIsTraveling.verifyGenericPageHeaderIsPresent(),"Not able to verify Page Header is Present");
		softAssert.assertTrue(whoIsTraveling.verifyDateOfTripIsPresent(), "Not able to verify Date of Trip");
		softAssert.assertTrue(whoIsTraveling.verifyTravelerNameFieldIsPresent(), "Not able to verify Traveler Name");
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
		
		softAssert.assertTrue(resultFlightHotelsPage.verifyListPricesIsCorrectlyOrdered(), "List of Hotel prices is not properly sorted");
		
		resultFlightHotelsPage.selectThreeStarsHotel();
		SelectedHotelPage selectedHotelPage = homeTravelocityPage.getSelectedHotelPage(homeTravelocityPage.getDriver());
		softAssert.assertTrue(resultFlightHotelsPage.getHotelNameLabel().equals(selectedHotelPage.getHotelNameLabel()), "Hotel Selected Names does not match");
		softAssert.assertTrue(resultFlightHotelsPage.getNumOfStars().equals(selectedHotelPage.getStarsNumber()), "Hotel Selected Stars Number does not match");
		selectedHotelPage.selectFirstRoom();
		
		DeparturesFlightHotelPage departuresFlightHotelPage = homeTravelocityPage.getDeparturesFlightHotelPage(homeTravelocityPage.getDriver());
		departuresFlightHotelPage.selectFirstDepartingFlight();
		
		ReturningFlightHotelPage returningFlightHotelPage = homeTravelocityPage.getReturningFlightHotelPage(homeTravelocityPage.getDriver());
		returningFlightHotelPage.selectThirdReturningFlight();
		
		CarSelectionPage carSelectionPage = homeTravelocityPage.getCarSelectionPage(homeTravelocityPage.getDriver());
		carSelectionPage.selectACar();
		
		ReviewAndBookPage reviewAndBookPage = homeTravelocityPage.getReviewAndBookPage(homeTravelocityPage.getDriver());
		softAssert.assertTrue(reviewAndBookPage.verifyTripLocationInfo().get(0).equals("Las Vegas (LAS) to Los Angeles (LAX)"), "Unable to verify Trip Location");
		softAssert.assertTrue(reviewAndBookPage.verifyTripLocationInfo().get(1).equals("Feb 28, 2018 - Mar 10, 2018"), "Unable to verify Trip Date");
		softAssert.assertTrue(reviewAndBookPage.verifyTripLocationInfo().get(2).equals("1 ticket: 1 adult"), "Unable to verify Trip Date");
	}
	
	@Test
	public void exercise3(){
		HotelsPage hotelsPage = homeTravelocityPage.getHotelsPage(homeTravelocityPage.getDriver());
		hotelsPage.searchOnlyHotel("Montevideo, Uruguay");
		
		ResultsHotelOnlyPage resultsHotelOnlyPage = homeTravelocityPage.getResultsHotelOnlyPage(homeTravelocityPage.getDriver());
		
		softAssert.assertTrue(resultsHotelOnlyPage.discountSectionIsDisplayed(), "No option of receive a discount is displayed");
		softAssert.assertTrue(resultsHotelOnlyPage.sponsoredShownFirst(), "Sponsored Hotels not shown first");
	}
	
	@Test
	public void exercise4(){
		FlightsPage flightsPage = homeTravelocityPage.getFlightsPage(homeTravelocityPage.getDriver());
	}
}
