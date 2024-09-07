package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class seleniumpractise_BTVNDay16 extends commonBase{
	@BeforeMethod
	public void openFireFox()
	{
		driver = initFirefoxDriver(CT_PageURLs.URL_SELENIUMPRACTISE);
	}
	@Test
	public void ClickTryIt()
	{
		click(By.xpath("//button[@onclick='myFunction()']"));
		waitAlert();
		String actualmessage =driver.switchTo().alert().getText();
		assertEquals(actualmessage, "Welcome to Selenium WebDriver Tutorials");
		driver.switchTo().alert().accept();
	}

}
