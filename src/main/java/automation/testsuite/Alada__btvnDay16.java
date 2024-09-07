package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPage_alada;
import automation.page.RegisterFactory;

public class Alada__btvnDay16 extends commonBase{
	RegisterFactory login;
	RegisterFactory Edit;
	
	@BeforeMethod
	public void openChrome()
	{
		driver = initFirefoxDriver(CT_PageURLs.URL_ALADA);
	}
	@Test
	public void CapNhatThongTin() throws InterruptedException
	{
	{
		login = new RegisterFactory(driver);
		login.Login("lan@mail.com", "123456");
		login.EditpassFunction("lan@mail.com", "123456", "1234567");
		waitAlert();
		driver.switchTo().alert().accept();
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		driver.quit();		
	}
}
}