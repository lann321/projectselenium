package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterFactory {
	private WebDriver driver;
	@FindBy(xpath = "(//a[@class='btn-anis-effect'])[1]") WebElement Register1;
	@FindBy(xpath = "//button[@class='btn_pink_sm fs16']") WebElement btnRegister;
	@FindBy(id = "txtFirstname") WebElement Hoten;
	@FindBy(id = "txtEmail") WebElement Email;
	@FindBy(id = "txtCEmail") WebElement ReEnterEmail;
	@FindBy(id = "txtPassword") WebElement Pass;
	@FindBy(id = "txtCPassword") WebElement ReEnterPass;
	@FindBy(id = "txtPhone") WebElement Phone;
	@FindBy(id = "chkRight") WebElement CheckboxAccept;
	@FindBy(xpath = "//button[@class='btn_pink_sm fs16']") WebElement btnDangky;
	public RegisterFactory(WebDriver _driver)
	{
		this.driver= _driver;
		PageFactory.initElements(_driver, this);
	}
	public void RegisterFactory(String hoten, String email, String ReEmail, String pass,String RePass,String phone)
	{
		Register1.click();
		Hoten.sendKeys(hoten);
		Email.sendKeys(email);
		ReEnterEmail.sendKeys(ReEmail);
		Pass.sendKeys(pass);
		ReEnterPass.sendKeys(RePass);
		Phone.sendKeys(phone);
		CheckboxAccept.click();
		btnDangky.click();
	}
}
