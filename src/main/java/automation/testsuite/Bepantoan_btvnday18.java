package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class Bepantoan_btvnday18 extends commonBase{
	@BeforeMethod
	@Parameters("browser")
	public void openFirefox(String browserName)
	{
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_BEPANTOAN);
		//driver =initFirefoxDriver(CT_PageURLs.URL_BEPANTOAN);
	}
	@Test
	public void CallMessage()
	{
		click(By.xpath("(//span[text()='Chat với chúng tôi'])[1]"));
		pause(3000);
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			if(!mainWindow.equals(windows)){
				driver.switchTo().window(window);
				}
		}
		pause(5000);
		assertTrue(isElementVisibility(By.xpath("//h2[text()='Kết nối với những người bạn yêu quý.']")));
	}
}
