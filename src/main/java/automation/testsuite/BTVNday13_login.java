package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPage;
import automation.page.LoginPage_btvnday13;

public class BTVNday13_login extends commonBase{
	LoginPage_btvnday13 login;
	@BeforeMethod
	public void openChrome()
	{
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEAS6);
		LoginPage login =new LoginPage(driver);
	}
	@Test
	public void case1_loginSuccessfull()
	{
		login = new LoginPage_btvnday13(driver);
		login.LoginFunction("admin@example.com", "123456");
		assertTrue(driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed());
	}
	@Test
	public void case2_LoginUsernameFail()
	{
		login = new LoginPage_btvnday13(driver);
		login.LoginFunction("admin123@example.com", "123456");
		assertTrue(driver.findElement(By.xpath("//span[text()='Invalid login credentials']")).isDisplayed());
	}
	@Test
	public void case3_LoginPasswordFail()
	{
		login = new LoginPage_btvnday13(driver);
		login.LoginFunction("admin@example.com", "123456789");
		assertTrue(driver.findElement(By.xpath("//span[text()='Invalid login credentials']")).isDisplayed());
	}
	@Test
	public void case4_LoginFailLeaverBlank()
	{
		login = new LoginPage_btvnday13(driver);
		login.LoginFunction("", "");
		assertTrue(driver.findElement(By.xpath("//strong[text()='The email field is required when phone is not present.']")).isDisplayed());
	}
}
