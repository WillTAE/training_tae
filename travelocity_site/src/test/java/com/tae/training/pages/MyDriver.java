package com.tae.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
	private WebDriver driver;

	public MyDriver(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.firefox.marionette", "C:\\ToolsQA\\drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\ToolsQA\\drivers\\chrome\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("test-type");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
			driver = new ChromeDriver();
		default:
			break;
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
	
}
