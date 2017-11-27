package com.tae.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.tae.training.pages.DeparturesPage;
import com.tae.training.pages.HomeTravelocityPage;
import com.tae.training.pages.ResultsPage;
import com.tae.training.pages.ReviewYourTripPage;

public class TestTravelocity extends BaseTest {
	@Test
	public void exercise1(){
		HomeTravelocityPage homeTravelocityPage = getHomeTravelocityPage();
		ResultsPage resultsPage = homeTravelocityPage.searchFlights("LAS","LAX","20","1");
		assertEquals(resultsPage.getResultsPageTitle(), "Select your departure to Los Angeles");
		assertTrue(resultsPage.verifyPriceDropdownIsPresent());
		//assertTrue(resultsPage.verifySelectButtonsPresent());
//		assertTrue(resultsPage.verifyFlightDurationLabels());
//		assertTrue(resultsPage.verifyFlighDetailsAndBaggageFee());
		assertTrue(resultsPage.verifyListCorrectlySorted());
		DeparturesPage departuresPage = resultsPage.selectingDeparture();
		ReviewYourTripPage reviewYourTripPage = departuresPage.selectingReturning();
		//assertTrue(reviewYourTripPage.verifyTotalPricePresent());
	}
}
