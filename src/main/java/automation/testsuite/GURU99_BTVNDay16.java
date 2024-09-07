package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class GURU99_BTVNDay16 extends commonBase{
	@BeforeMethod
	public void openFireFox()
	{
		driver = initFirefoxDriver(CT_PageURLs.URL_DEMOGURU99);
	}
	@Test
	public void AcceptAlert()
	{
		
		type(By.xpath("//input[@name='cusid']"), "12345");
		click(By.xpath("//input[@name='submit']"));
		waitAlert();
		driver.switchTo().alert().accept();
		waitAlert();
		driver.switchTo().alert().accept();
	}
}
