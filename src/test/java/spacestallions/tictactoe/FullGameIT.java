package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import java.net.URL;
import static org.apache.commons.lang3.StringUtils.join;

public class FullGameIT {
	private Selenium selenium;
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "30");
        // Create the connection to Sauce Labs to run the tests
        driver = new RemoteWebDriver(
                new URL("http://spacestallions:8e0c8605-982f-4b17-8697-d3bec46d3599@ondemand.saucelabs.com:80/wd/hub"),
                caps);
        baseUrl = "http://spacestallions-staging.herokuapp.com/";   
	}

	@Test
	public void testFullGame() throws Exception {
		driver.get(baseUrl);
		/*
		WebElement element = driver.findElement(By.id("btnReset"));
		element.click();
		*/
		WebElement cell1 = driver.findElement(By.id("cell-1"));
		WebElement cell2 = driver.findElement(By.id("cell-2"));
		WebElement cell3 = driver.findElement(By.id("cell-3"));
		WebElement cell4 = driver.findElement(By.id("cell-4"));
		WebElement cell5 = driver.findElement(By.id("cell-5"));
		WebElement cell6 = driver.findElement(By.id("cell-6"));
		WebElement cell7 = driver.findElement(By.id("cell-7"));
		WebElement cell8 = driver.findElement(By.id("cell-8"));
		WebElement cell9 = driver.findElement(By.id("cell-9"));
		cell1.click();
		cell4.click();
		cell2.click();
		cell5.click();
		cell3.click();
		/*
		assertTrue(isElementPresent(By.id("btnReset")));
		assertFalse(isElementPresent(By.id("X")));
		assertFalse(isElementPresent(By.id("O")));
		*/
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	private boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}
}