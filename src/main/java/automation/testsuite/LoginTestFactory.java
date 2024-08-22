package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginFactory;
import automation.page.Logout_Codestar;

public class LoginTestFactory extends commonBase{
	//ctrl + a => ctrrl + shift+ f
	LoginFactory LoginFactory;
	Logout_Codestar Logout_Codestar;
	@BeforeMethod
	public void openFireFox()
	{
		driver=initFirefoxDriver(CT_PageURLs.URL_SELENIUMEAS7);
	}
	@Test
	public void loginSuccess() throws InterruptedException
	{
		LoginFactory = new LoginFactory(driver);
		LoginFactory.LoginFuntion("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
		Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Logout_Codestar = new Logout_Codestar(driver);
		Logout_Codestar.LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
		
	
	}
	
}
