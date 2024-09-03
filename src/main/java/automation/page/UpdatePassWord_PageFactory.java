package automation.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.*;

public class UpdatePassWord_PageFactory {
	private WebDriver driver;
	@FindBy(id = "UserName") WebElement textEmail;
	@FindBy(id = "Password") WebElement textPassword;
	@FindBy(xpath = "//button[text()='Đăng nhập']") WebElement buttonLogin;
	@FindBy(id = "my_account") WebElement btnAvatar;
	@FindBy(xpath = "//a[@title='Đổi mật khẩu']") WebElement btnUpdatePass;
	
	@FindBy(id = "OldPassword")WebElement txtoldPass;
	@FindBy(id = "NewPassword") WebElement txtnewPass;
	@FindBy(id = "ConfirmNewPassword") WebElement txtConfirmPass;
	@FindBy(id = "onesignal-slidedown-allow-button") WebElement cancelButton;
	@FindBy(xpath = "//input[@value='Cập nhật']") WebElement capnhat;
	
	@FindBy(xpath = "//input[@placeholder='Tìm bất cứ thứ gì mà bạn muốn']") WebElement textboxsearch;
	@FindBy(xpath = "//i[@class='fa fa-search']") WebElement search;
	
	
	public UpdatePassWord_PageFactory(WebDriver _driver)
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
	public void UpdatePassWord( String oldpass, String newpass) throws InterruptedException
	{
		Thread.sleep(10000);
		try {
			while (cancelButton.isDisplayed()) 
			{
				cancelButton.click();
			}
		} catch (Exception ex) {
			
			btnAvatar.click();
			btnUpdatePass.click();
			txtoldPass.sendKeys(oldpass);
			txtnewPass.sendKeys(newpass);
			txtConfirmPass.sendKeys(newpass);
			capnhat.click();
		}
	}
	public void Search(String text) throws InterruptedException
	{
		Thread.sleep(10000);
		try {
			while (cancelButton.isDisplayed())
			{
				cancelButton.click();
			}
		} catch (Exception ex)
		{
			textboxsearch.sendKeys(text);
			search.click();
			
		}
		
	}
	
	}



