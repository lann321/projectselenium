package automation.common;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

public class commonBase {
	public WebDriver driver;
	public int initWaitTime = 60;
	public int minisecondinitwaitime;

	public WebDriver initChromeDriver(String URL) {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(initWaitTime));
		return driver;
}
	public WebDriver initFirefoxDriver(String URL) {
		FirefoxOptions options = new FirefoxOptions();
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(initWaitTime));
		return driver;
	}
	public WebElement getElementPresentDOM(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				WebElement element = driver.findElement(locator);
				return element;
	}
	
	
	public List<WebElement> getListWebElements(By locator)
	{ List<WebElement> elementlist =null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		elementlist = driver.findElements(locator);
		return elementlist;
		}
		catch(Exception ex)
		{
			return elementlist;
		}
		
	}
	
	
	
	public void clickJavScript(By locator)
	{
		WebElement element = getElementPresentDOM(locator);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	public void typeJavaScriptByValue(By locator, String text)
	{
		WebElement element = getElementPresentDOM(locator);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		try {
		js.executeScript("arguments[0].value ='"+text+"'", element);
	}
		catch(StaleElementReferenceException ex)
		{
			typeJavaScriptByValue(locator, text);
		}
	}
	public void click(By locator)
	{
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	public void type(By locator, String value)
	{
		WebElement element = getElementPresentDOM(locator);
		element.sendKeys(value);
	}
	public void scrollToElement(By locator)
	 {
			WebElement element = getElementPresentDOM(locator);
			JavascriptExecutor js =(JavascriptExecutor) driver;
			try {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
			catch(StaleElementReferenceException ex)
			{
				pause(5000);
				scrollToElement(locator);
			}
			
		}
	public void pause(int minisecondinitwaitime)
	{ 
	try {
		Thread.sleep(minisecondinitwaitime);}
	catch(InterruptedException e){
			e.printStackTrace();}
	}
	public void waitAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public boolean isElementVisibility(By locator)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
			}
			catch(TimeoutException ex)
			{
				return false;
			}
	}
	
}

