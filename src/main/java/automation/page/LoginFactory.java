package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.*;

public class LoginFactory {
	private WebDriver driver;
	@FindBy(id = "email") WebElement textEmail;
	@FindBy(id = "password") WebElement textPassword;
	@FindBy(name = "signin") WebElement buttonLogin;
	public LoginFactory(WebDriver _driver)
	{
		this.driver= _driver;
		PageFactory.initElements(_driver, this);
	}
	public void LoginFuntion(String email, String pass)
	{
		textEmail.sendKeys(email);
		textPassword.sendKeys(pass);
		buttonLogin.click();
	}
}
