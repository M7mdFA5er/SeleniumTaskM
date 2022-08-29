package seleniumInterview;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;

public class InterviewTest {

	public WebDriver driver;
	String _url = "https://arielkiell.wixsite.com/interview";

	@BeforeSuite
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "..\\Drivers\\chromedriver.exe");
		// Initiating your chromedriver
		driver = new ChromeDriver();
		// Applied wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// maximize window
		driver.manage().window().maximize();
		System.out.print("Test Started");
		driver.get(_url);
	}

	@Test
	public void verifyCheckout() {
		JavascriptExecutor js   = (JavascriptExecutor) driver;
		TakesScreenshot scrShot = (TakesScreenshot)    driver;
		Actions  action;
		
		// verify that landingPage is loaded and have title
		String _title = "Home | interview";
		String title = driver.getTitle();
		AssertJUnit.assertEquals(_title, title);
		
		// verify that shop link is displayed and click it
		WebElement ele = driver.findElement(By.linkText("Shop"));
		AssertJUnit.assertTrue(ele.isDisplayed());

		//Screen Shoot at each stage
		File screenshotFile=scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile , new File(".\\ScreenShoots\\"+ new Date()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Go to Shop Link and click it
		ele.click();
		

		// Scroll down to list of products
		
		WebElement productListDiv = driver.findElement(By.cssSelector("ul[data-hook=product-list-wrapper]"));
		List<WebElement> products = productListDiv.findElements(By.cssSelector("li[data-hook=product-list-grid-item]"));
		
		
		// Scrolling down the page till the product number 4 is found
		js.executeScript("arguments[0].scrollIntoView();", products.get(3));
		
		//SELECT THE 4th product 
		products.get(3).click();
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		//Hover over quantity input arrow and increase to 3 , pick any color
		WebElement quantity = driver.findElement(By.cssSelector("input[data-hook=number-input-spinner-input"));
		
		action = new Actions(driver);
		action.moveToElement(quantity).perform();
		//action.click().build().perform();
		
		
		
		WebElement quantity_Increase_Value = driver.findElement(By.className("_11lkb")); 
		action = new Actions(driver);
		action.moveToElement(quantity_Increase_Value).perform();
		action.click().build().perform();
		action.click().build().perform();
		
		//SELECT COLOR
		
		List<WebElement> ColorPickersRadioButtons = driver
				.findElements(By.className("RadioButton1077346691__root"));
		
		action = new Actions(driver);
		action.moveToElement(ColorPickersRadioButtons.get(0)).perform();
		action.click().build().perform();
		
		
		//Click add to cart button
		WebElement addToCartButton = driver.findElement(By.className("buttonnext3581011660__root"));
		addToCartButton.click();
		
	}

}
