package automation.testsuite;

import static org.testng.Assert.*;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

import automation.page.RegisterFactory;

public class Register_BTVNday14 extends commonBase{

	RegisterFactory Register;
	RegisterFactory login;
	RegisterFactory Editfunction;
	RegisterFactory logout;
	
	
	@BeforeMethod
	public void openFireFox()
	{
		driver = initChromeDriver(CT_PageURLs.URL_ALADA);
	}
	@Test(priority = 1)
	public void RegisterSuccess() throws InterruptedException
	{
		Register = new RegisterFactory(driver);
		Thread.sleep(10000);
		Register.RegisterFunction("123@", "123a@gmail.com", "123a@gmail.com", "123456", "123456", "0365476545");
		Thread.sleep(10000);
		assertTrue(driver.findElement(By.xpath("//h2[text()='Danh mục khóa học']")).isDisplayed());
	}
	@Test  (priority = 2)
	public void Chinhsua()  throws InterruptedException
	{
		login = new RegisterFactory(driver);
		login.Login("123a@gmail.com", "123456");
		Thread.sleep(10000);
		Editfunction = new RegisterFactory(driver);
		Editfunction.EditpassFunction("123a@gmail.com", "123456", "012345");
		
	}
	@Test (priority = 3)
	public void login() throws InterruptedException
	{
		login = new RegisterFactory(driver);
		login.Login("123a@gmail.com", "012345");
		Thread.sleep(10000);
		assertTrue(driver.findElement(By.xpath("//h2[text()='Danh mục khóa học']")).isDisplayed());
	}
	
}
