package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.commonBase;
import automation.constant.CT_PageURLs;

public class ThietBiNhaBep extends commonBase {
	@BeforeMethod
	public void openFireFox()
	{
		driver =initFirefoxDriver(CT_PageURLs.URL_BEPANTOAN);
	}
	@Test (priority = 1)
	public void LoctheoDanhmuc()
	{
		click(By.xpath("//a[text()=' Thiết Bị Nhà Bếp Khác ']"));
		pause(2000);
	}

}
