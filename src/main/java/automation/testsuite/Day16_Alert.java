package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class Day16_Alert extends commonBase{

	@BeforeMethod
	public void openChrome()
	{
		driver =initFirefoxDriver(CT_PageURLs.URL_AUTOMATIONTESTING);
	}
	@Test(priority = 1)
	public void verifyAlertMessage()
	{
		click(By.xpath("//a[text()='Alert with Textbox ']"));
		click(By.xpath("//button[@class='btn btn-info']"));
		waitAlert();
		String actualMessage =driver.switchTo().alert().getText();
		assertEquals(actualMessage, "Please enter your name");
		
	}
	@Test(priority = 2)
	public void PressOKonAlert()
	{
		click(By.xpath("//a[text()='Alert with Textbox ']"));
		click(By.xpath("//button[@class='btn btn-info']"));
		waitAlert();
		driver.switchTo().alert().sendKeys("lan");
		driver.switchTo().alert().accept();
		WebElement hellolabel = getElementPresentDOM(By.id("demo1"));
		assertEquals(hellolabel.getText(), "Hello lan How are you today");
	}
	@Test(priority = 3)
	public void PressCancelonAlert()
	{
		click(By.xpath("//a[text()='Alert with Textbox ']"));
		click(By.xpath("//button[@class='btn btn-info']"));
		waitAlert();
		driver.switchTo().alert().sendKeys("lan");
		driver.switchTo().alert().dismiss();
		//WebElement hellolabel = getElementPresentDOM(By.id("demo1"));
		//assertEquals(hellolabel.getText(), null);
		assertFalse(isElementVisibility(By.id("demo1")));
	}
}
