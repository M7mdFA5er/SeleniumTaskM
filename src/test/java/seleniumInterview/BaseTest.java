package seleniumInterview;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {

	public WebDriver driver;
	String _url = "https://arielkiell.wixsite.com/interview";

	/*
	 * @BeforeSuite public void setUp() {
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "..\\Drivers\\chromedriver.exe"); // Initiating your chromedriver driver =
	 * new ChromeDriver(); // Applied wait time
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // maximize
	 * window driver.manage().window().maximize(); System.out.print("Test Started");
	 * driver.get(_url); }
	 */
	
	/*
	 * @AfterSuite public void close() { driver.close();
	 * System.out.print("Test Finished"); }
	 */
}
