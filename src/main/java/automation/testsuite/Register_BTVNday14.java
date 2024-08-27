package automation.testsuite;

import static org.testng.Assert.*;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;
import automation.page.EditPassword;
import automation.page.RegisterFactory;

public class Register_BTVNday14 extends commonBase{
	EditPassword EditFunction;
	RegisterFactory Register;
	@BeforeMethod
	public void openFireFox()
	{
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEAS5);
	}
	@Test
	public void RegisterSuccess() throws InterruptedException
	{
		Register = new RegisterFactory(driver);
		Thread.sleep(10000);
		Register.RegisterFactory("ATest", "TTest@gmail.com", "TTest@gmail.com", "234566", "234566", "0365476545");
		Thread.sleep(10000);
		assertTrue(driver.findElement(By.xpath("//h2[text()='Danh mục khóa học']")).isDisplayed());
	}
	@Test
	public void Chinhsua()  throws InterruptedException
	{
		EditFunction = new EditPassword(driver);
		// chỉnh sửa mật khẩu: email, mật khẩu hiện tại, mật khẩu mới, nhập lại mật khẩu mới 
		EditFunction.EditPassword("lantest@gmail.com", "123456", "012345", "012345");
		Thread.sleep(10000);
		assertTrue(driver.findElement(By.xpath("//h2[text()='Danh mục khóa học']")).isDisplayed());
		
	}
	
}
