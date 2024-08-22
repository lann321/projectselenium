package automation.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.*;
import org.testng.annotations.BeforeMethod;

import automation.constant.CT_PageURLs;

public class Logout_Codestar {
	private WebDriver driver;
	@FindBy(id = "dropdownMenuLink") WebElement btnAdmin;
	@FindBy(xpath = "(//button[text()='Đăng xuất'])[1]") WebElement btnLogout;
	@FindBy(xpath = "(//button[text()='Đăng xuất'])[2]") WebElement btnLogout2;
	@FindBy(xpath = "//div[@class='toast-title") WebElement toastmessage;
	public Logout_Codestar(WebDriver _driver)
	{
		this.driver= _driver;
		PageFactory.initElements(_driver, this);
	}
	public void LogoutFunction()
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		btnAdmin.click();;
		btnLogout.click();
		btnLogout2.click();
}
}
	
