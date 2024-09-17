package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class DienmayHungAnh_btvnday18 extends commonBase{
	@BeforeMethod
	@Parameters("browser")
	public void openFirefox(String browserName)
	{
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_DIENMAYHUNGANH);
		//driver =initFirefoxDriver(CT_PageURLs.URL_DIENMAYHUNGANH);
	}
	@Test
	public void CallZalo()
	{
		click(By.xpath("(//div[@class='phone-vr-img-circle'])[2]"));
		pause(3000);
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			if(!mainWindow.equals(windows)){
				driver.switchTo().window(window);
				}
		}
		assertTrue(isElementVisibility(By.xpath("//button[@class='button medium']")));
	}
}
