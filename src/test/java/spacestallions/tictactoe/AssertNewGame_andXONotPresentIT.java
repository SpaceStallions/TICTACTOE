package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;




public class AssertNewGame_andXONotPresentIT {
	
	private Selenium selenium;
	private String baseUrl;
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		
		//saucelabs
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform","Linux");
		caps.setCapability("version","30");
		
		//create the connection to Sauce labs to run the tests
	
		driver = new RemoteWebDriver(
                new URL("http://spacestallions:8e0c8605-982f-4b17-8697-d3bec46d3599@ondemand.saucelabs.com:80/wd/hub"),
                caps);

        baseUrl = "http://spacestallions-staging.herokuapp.com/";
	}

	@Test
	public void testAssertNewGame_andXONotPresentIT() throws Exception {
		
		driver.get(baseUrl);
		selenium.click("id=btnReset");
		assertFalse(selenium.isElementPresent("X"));
		assertFalse(selenium.isElementPresent("O"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
