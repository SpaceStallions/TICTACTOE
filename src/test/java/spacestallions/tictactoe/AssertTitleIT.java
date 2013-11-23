package spacestallions.tictactoe;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import java.net.URL;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AssertTitleIT 
{
    private WebDriver driver;
    private WebDriver driverSL;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception 
    {
        driver = new FirefoxDriver();
        //baseUrl = System.getenv("STAGING_SERVER");
        baseUrl = "http://spacestallions-staging.herokuapp.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Saucelabs
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "30");
        // Create the connection to Sauce Labs to run the tests
        this.driverSL = new RemoteWebDriver(
                new URL("http://spacestallions:8e0c8605-982f-4b17-8697-d3bec46d3599@ondemand.saucelabs.com:80/wd/hub"),
                caps);
    }

    @Test
    public void titleShouldBeSpaceStallionsTicTacToe() throws Exception 
    {
        driver.get(baseUrl);
        assertEquals("SpaceStallions TicTacToe", driver.getTitle());
    }

    @Test
    public void titleShouldBeSpaceStallionsTicTacToeSL() throws Exception 
    {
        driverSL.get(baseUrl);
        assertEquals("SpaceStallions TicTacToe", driverSL.getTitle());
    }


    @After
    public void tearDown() throws Exception 
    {
        driver.quit();
        driverSL.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) 
        {
            fail(verificationErrorString);
        }
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