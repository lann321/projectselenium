package automation.testsuite;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class MediamartIframe_btvnday16 extends commonBase{
	@BeforeMethod
	public void openChrome()
	{
		driver =initFirefoxDriver(CT_PageURLs.URL_MEDIAMART);
	}
	@Test
	public void VerifyIframe()
	{
		pause(10000);
		
		click(By.xpath("//div[@class='widget-preview--btn-close']"));
		pause(3000);
		WebElement iframe = driver.findElement(By.xpath("(//div[@class='zalo-chat-widget'])/descendant::iframe"));
		driver.switchTo().frame(iframe);
		WebElement chatWidget = driver.findElement(By.xpath("//div[@class='za-chat__head-box']"));
		chatWidget.click();
		assertTrue(isElementVisibility(By.xpath("//div[@class='language-change-wrapper']")));
		
	}
	@Test
	public void SendMessageVerify()
	{
		pause(10000);
		click(By.xpath("//div[text()='Gửi tin nhắn']"));
		assertTrue(isElementVisibility(By.xpath("//button[text()='Để lại tin nhắn']")));
	}
}
