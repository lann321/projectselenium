package automation.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;
import automation.page.Edit;
import automation.page.RegisterFactory;

public class Register_BTVNday14 extends commonBase{
	Edit EditFunction;
	RegisterFactory Register;
	@BeforeMethod
	public void openFireFox()
	{
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEAS5);
	}
	@Test
	public void RegisterSuccess()
	{
		Register = new RegisterFactory(driver);
		Register.RegisterFactory("AbcTest", "12abc@gmail.com", "12abc@gmail.com", "234566", "234566", "0365476545");
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
	}
	@Test
	public void Chinhsua()
	{
		EditFunction = new Edit(driver);
		// chỉnh sửa mật khẩu: email, mật khẩu hiện tại, mật khẩu mới, nhập lại mật khẩu mới 
		EditFunction.Edit("lantest@gmail.com", "123456", "012345", "012345");
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
		
	}
	
}
