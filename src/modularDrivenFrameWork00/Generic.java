package modularDrivenFrameWork00;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Generic {
	
	//Initialize the Driver
	//Individual Method for Each Task
	
	
	public static WebDriver driver = null;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
		// initialize driver
		// maximize page method
		// implicit Wait
		// explicit wait
		// fluentWait

	//=======================LaunchBrowser=============================================//
		public static void LaunchBrowser(String browserName) {
			
				
				// String browserName = "Chrome"; // initialize browserName;
						System.out.println("Enter a Browser Name To Launch:     |Chrome|FireFox|Edge| ");

						Scanner sc = new Scanner(System.in);
						browserName = sc.next();

						if (browserName.equalsIgnoreCase("Chrome")) {
							System.setProperty("webdriver.chrome.driver", "driver/chromedriver102.exe");
							driver = new ChromeDriver();

						}

						else if (browserName.equalsIgnoreCase("FireFox")) {
							System.setProperty("webdriver.gecko.driver", "driver/geckodriver31.exe");
							driver = new FirefoxDriver();

						}

						else if (browserName.equalsIgnoreCase("Edge")) {
							System.setProperty("webdriver.edge.driver", "driver/msedgedriver101.exe");
							driver = new EdgeDriver();

						} else {
							System.out.println("Browser Name Not Found - Enter Chrome, FireFox Or Edge only");
						}
		}
		
		//=============================maximizePage=======================================//
		
		public static void maximizePage() {
			try {
				driver.manage().window().maximize();
			} catch (Exception e) {
				System.err.println("Error Encountered with ==> " + e.getMessage());
			}
		}
		//==========================navigateTo==========================================//
		public static void navigateTo(String url) {
			try {
				driver.navigate().to(url);
			} catch (Exception e) {
				System.err.println("Error Encountered with ==> " + e.getMessage());
			}
		}
		//============================typeByXpath========================================//
		public static void typeByXpath(String locator, String values) {
			try {
				driver.findElement(By.xpath(locator)).clear();
				driver.findElement(By.xpath(locator)).sendKeys(values);

			} catch (Exception e) {
				System.err.println("Error Encountered with ==>" + e.getMessage());
			}
		}
		//==============================clickByXpath======================================//
		public static void clickByXpath(String locator) {
			try {
				driver.findElement(By.xpath(locator)).click();
				

			} catch (Exception e) {
				System.err.println("Error Encountered with ==> " + e.getMessage());
			}
		}
		//============================dropDownMenu========================================//
		/*public static void dropDownMenu(String xpath, String linktext) {
			Select select = new Select(driver.findElement(By.xpath(xpath)));
			select.selectByVisibleText(linktext);
		}*/
		//=============================calendarDatePicker=======================================//
		public static void calendarDatePicker(String calendarXpath, String dateXpath) {

			WebElement calendar = driver.findElement(By.xpath(calendarXpath));

			
			driver.findElement(By.xpath(dateXpath)).click();

			List<WebElement> row = calendar.findElements(By.xpath(""));
			List<WebElement> col = calendar.findElements(By.xpath(""));

		}
		//============================calendarDatePicker========================================//
		public static void DragNDrop(String fromXpath, String toXpath) {
			// Drag and Drop
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

			driver.get("https://jqueryui.com/droppable/");
			driver.switchTo().frame(0);
			WebElement drag = driver.findElement(By.xpath(fromXpath));
			WebElement drop = driver.findElement(By.xpath(toXpath));
			Actions actions = new Actions(driver);
			actions.dragAndDrop(drag, drop).build().perform();
		}
		//============================ExplicitWait========================================//
		/*public static void ExplicitWait(long sec, String linkText) {

			// Explicit Wait will wait until Become Appointed becomes visible
			WebDriverWait explicitWait = new WebDriverWait(driver, sec);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText))).click();

		}*/

		//============================HoverOver ICW Agent Broker========================================//
		public static void HoverOver(String elementXpath) {

			try {
				
				WebElement agentBrokerZoneDdMenu = driver.findElement(By.xpath(elementXpath));
				Actions action = new Actions(driver);
				action.moveToElement(agentBrokerZoneDdMenu).perform();

			} catch (Exception e) {
				System.err.println(" Exception Found ===>> " + e.getMessage());

			}

		}
		//==============================implicitWait======================================//
		@SuppressWarnings("deprecation")
		public static void implicitWait(int sec) {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		}
		//===========================MouseClickOnce=========================================//
		public static void MouseClickOnce(String xPath) {
			// One Click
			Actions mouseAction = new Actions(driver);
			WebElement oneClick = driver.findElement(By.xpath(xPath));
			mouseAction.sendKeys(oneClick, Keys.values()).build().perform();
		}
		//=============================MouseClickDouble=======================================//
		public static void MouseClickDouble(String xPath) {
			Actions mouseAction = new Actions(driver);
			WebElement rightClick = driver.findElement(By.xpath(xPath));
			mouseAction.contextClick(rightClick).build().perform();
		}
		//=============================VerifyLinks=======================================//
		public static void VerifyLinks() {
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Total links are " + links.size());
			for (int i = 0; i < links.size(); i++) {
				WebElement ele = links.get(i);
				String url = ele.getAttribute("href");
				verifyLinkActive(url);
			}
		}
		//============================verifyLinkActive========================================//
		private static void verifyLinkActive(String url) {
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Total links are " + links.size());
			for (int i = 0; i < links.size(); i++) {
				WebElement ele = links.get(i);
				String url1 = ele.getAttribute("href");
				verifyLinkActive(url1);
			}
		}
			
}
	
//==========================END OF GENERIC==========================================//
//====================================================================//










/*	public static void maxPage() {
		try {
			
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.err.println("Error Encountered with "+e.getMessage());
		}	
	}
	
	public static void navigateTo (String webPageName) {
		try {
			driver.navigate().to(webPageName);
		}catch (Exception e) {
			System.out.println("Error Encountered with "+e.getMessage());
		}
	}
	public static void typeByXpath(String locators, String values) {
		try {
			driver.findElement(By.xpath(locators)).clear();
			driver.findElement(By.xpath(locators)).sendKeys(values);
		}
		catch (Exception e) {
			System.out.println("Error Encountered with "+e.getMessage());
		
		}
	}
	public static void clickByXpath(String locators, String values) {
		try {
			driver.findElement(By.xpath(locators)).click();
		}
		catch (Exception e) {
			System.out.println("Error Encountered with "+e.getMessage());
		}
	public static void explicitWait(Duration sec, String linkText) {

			// Explicit Wait
			WebDriverWait explicitWait = new WebDriverWait(driver, sec);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText))).click();

		}
	public static void hoverOver(String elementXpath) {

			try {
				// Hover Over
				WebElement agentBrokerZoneDdMenu = driver.findElement(By.xpath(elementXpath));
				Action action = new Action(driver);
				action.moveToElement(agentBrokerZoneDdMenu).perform();

			} catch (Exception e) {
				System.err.println("Showing Exception: " + e.getMessage());

			}

		}
	}
}   */
