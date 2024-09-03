package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPage;

public class LoginTest extends commonBase {
	LoginPage login;
	@BeforeMethod
	public void openChromer()
	{
		
		driver = initChromeDriver(CT_PageURLs.URL_ALADA);
		LoginPage login = new LoginPage(driver);
	}
	
	@Test
	public void loginSuccessfully()
	{
		login = new LoginPage(driver);
		login.LoginFunction("lan@mail.com","123456");
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
	}
	@Test
	public void loginFail_usernameNotExist()
	{
		login = new LoginPage(driver);
		login.LoginFunction("lan123@mail.com","123456");
		assertTrue(driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']")).isDisplayed());
	}
	
	@Test
	public void loginFail_PasswordInvalid()
	{
		login = new LoginPage(driver);
		login.LoginFunction("lan@mail.com","1234");
		assertTrue(driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']")).isDisplayed());
	}
	@Test
	public void loginFail_LeaverBlank()
	{
		login = new LoginPage(driver);
		login.LoginFunction("","");
		assertTrue(driver.findElement(By.xpath("//label[@id='txtLoginPassword-error']")).isDisplayed()
				&& driver.findElement(By.xpath("//label[@id='txtLoginUsername-error']")).isDisplayed());
	}

}
