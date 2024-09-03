package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;
import automation.page.RaiseFactory_day15;

public class LoginRaise_btvnDay15 extends commonBase{
	RaiseFactory_day15 login;
	RaiseFactory_day15 addclient;
	@BeforeMethod
	public void openChrome()
	{
		driver = initFirefoxDriver(CT_PageURLs.URL_RISE);
	}
	@Test(priority = 1)
	public void loginSuccessfully() throws InterruptedException
	{
		login = new RaiseFactory_day15(driver);
		login.loginRase("admin@demo.com", "riseDemo");
		//assertTrue(driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed());
		Thread.sleep(10000);
		addclient = new RaiseFactory_day15(driver);
		addclient.AddClient("Test day15", "hanoi", "01234569");
		
	}
	@Test(priority = 2)
	public void searchClient() throws InterruptedException
	{	
		login = new RaiseFactory_day15(driver);
		login.loginRase("admin@demo.com", "riseDemo");
		WebElement client = driver.findElement(By.xpath("(//a[@role='presentation'])[2]"));
		client.click();
		
		WebElement search = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));
		search.sendKeys("Test day15");
		assertTrue(driver.findElement(By.xpath("//a[text()='Test day15']")).isDisplayed());
	
	}

}
