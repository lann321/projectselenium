package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.*;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class Day16_WindowPopup extends commonBase{
	@BeforeMethod
	public void openChrome()
	{
		driver =initFirefoxDriver(CT_PageURLs.URL_POPUPGURU99);
	}
	@Test
	public void handleWindow() throws InterruptedException
	{
		pause(3000);
		click(By.xpath("//a[text()='Click Here']"));
		String mainWindow =driver.getWindowHandle();
		System.out.println("Main window is:"+mainWindow);
		Set<String> listWindow =driver.getWindowHandles();
		for(String windowItem:listWindow)
		{
			System.out.println("window is: "+ windowItem);
			if(!windowItem.equals(mainWindow))
		{
			driver.switchTo().window(windowItem);
			type(By.xpath("//input[@name='emailid']"), "123@gmail.com");
			pause(3000);
			click(By.name("btnLogin"));

			assertTrue(isElementVisibility(By.xpath("//h2[text()='Access details to demo site.']")));
			driver.close();
		}

		}
		driver.switchTo().window(mainWindow);
		assertTrue(isElementVisibility(By.xpath("//a[text()='Click Here']")));
				
	}
}
