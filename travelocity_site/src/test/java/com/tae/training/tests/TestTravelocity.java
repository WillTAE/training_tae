package com.tae.training.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.tae.training.pages.HomeTravelocityPage;
import com.tae.training.pages.ResultsPage;

public class TestTravelocity extends BaseTest {
	@Test
	public void testSearchFlight(){
		HomeTravelocityPage homeTravelocityPage = getHomeTravelocityPage();
		ResultsPage resultsPage = homeTravelocityPage.searchFlights();
		System.out.println("Page Title:" +resultsPage.getResultsPageTitle());
		assertEquals(resultsPage.getResultsPageTitle(), "Select your departure to Los Angeles");
	}
}
