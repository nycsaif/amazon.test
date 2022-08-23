package modularDrivenFrameWork00;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Config {


//Launch Browser
	//Set Driver
	//URL
	//Database Connecton
	//WaitPack (implicit)
	// Maximize Page
	//static WebDriver driver = null;
	// public void chrome
	//public void edge
	//public void firefox
	
	//public static void main (String [] args) throws InterruptedException {
	
	@BeforeSuite
		public void beforeSuite() {
		//System.out.println("Before Suite:");
		log.debug("Before Suite"); 
	}//Copy this line to ao Syso
	@AfterSuite
	public void aftersuite() {
		log.info("After Suite");
		//System.out.println("After Suite");
		}
	@Parameters({"url","browser"})
	
	@BeforeMethod
	public void browserInit(String url, String browser) throws InterruptedException{
		
		if (browser.equalsIgnoreCase("Chrome")) {
			log.info("Chrome Browser Start ");
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver103.exe");
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("FireFox")) {
			log.info("Fire Fox Browser Start ");
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver102.exe");
			driver = new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("Edge")) {
			log.info("Edge Browser Start ");
			System.setProperty("webdriver.edge.driver", "driver/msedgedriver103.exe");
			driver = new EdgeDriver();

		} else {
			log.info("No Browser found ");
			throw new IllegalArgumentException("Broswer not found");
			//System.out.println("Browser Name Not Found - Enter Chrome, FireFox Or Edge only");
		}
		maximizePage();
		log.info("URL Launch ");
		driver.get(url);
		Thread.sleep(3000);
	}
	@AfterMethod
	public void closeBrowser() { 
		log.info("Browser Close ");
		driver.close();
	}
	
}