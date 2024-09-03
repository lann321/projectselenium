package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class HandleDatepicker extends commonBase
{
	@BeforeMethod
	public void openChrome()
	{
		driver =initChromeDriver(CT_PageURLs.URL_GURU99);
	}
	
	@Test
	public void inputBirtday()
	{
		WebElement bdaytime= driver.findElement(By.xpath("//input[@name='bdaytime']"));
		bdaytime.sendKeys("11022023");
		bdaytime.sendKeys(Keys.TAB);
		bdaytime.sendKeys("1100AM");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//assertTrue(false);
	}
}
