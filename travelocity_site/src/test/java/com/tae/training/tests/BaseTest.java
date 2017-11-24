package com.tae.training.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.tae.training.pages.HomeTravelocityPage;
import com.tae.training.pages.MyDriver;

public class BaseTest {
	MyDriver myDriver;
	
	private HomeTravelocityPage homeTravelocityPage;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser){
		myDriver = new MyDriver(browser);
		homeTravelocityPage = new HomeTravelocityPage(myDriver.getDriver());
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite(){
		System.out.println("Disposing");
		//homeTravelocityPage.dispose();
	}

	public HomeTravelocityPage getHomeTravelocityPage() {
		return homeTravelocityPage;
	}

}
