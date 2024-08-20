package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPage_Day13_bai2;

public class BTVNday13_Login2 extends commonBase{
	LoginPage_Day13_bai2 login;
	@BeforeMethod
	public void openChrome()
	{
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEAS7);
		LoginPage_Day13_bai2 login = new LoginPage_Day13_bai2(driver);
	}
	@Test
	public void LoginSuccess()
	{
		login = new LoginPage_Day13_bai2(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//a[text()='Tài khoản của tôi']")).isDisplayed());
	}
	@Test
	public void LoginUsernameInvalid()
	{
		login = new LoginPage_Day13_bai2(driver);
		login.LoginFunction("admin123@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}
	@Test
	public void LoginPasswordInvalid()
	{
		login = new LoginPage_Day13_bai2(driver);
		login.LoginFunction("admin123@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}
	@Test
	public void LoginLeaverBlank()
	{
		login = new LoginPage_Day13_bai2(driver);
		login.LoginFunction("", "");
		assertTrue(driver.findElement(By.xpath("//span[text()='Không được để trống trường này']")).isDisplayed());
	}
}
