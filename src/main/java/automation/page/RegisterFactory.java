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
	
	@FindBy(id ="txtLoginUsername") WebElement loginusername;
	@FindBy(id ="txtLoginPassword") WebElement loginpassword;
	@FindBy(xpath = "(//button[text()='ĐĂNG NHẬP'])[3]") WebElement btnlogin;
	
	@FindBy(xpath = "//ul[@class='menu fright marbot0']//li[@id='showsub']//a[@class='fleft w100per headcate']") WebElement Submenu;
	@FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']") WebElement Edit;
	@FindBy(xpath = "//input[@class='maxwidth']") WebElement Tendangnhap;
	@FindBy(id ="txtpassword") WebElement Oldpass;
	@FindBy(id ="txtnewpass") WebElement Newpass;
	@FindBy(id ="txtrenewpass") WebElement Renewpass;
	@FindBy(xpath ="//button[text()='Lưu mật khẩu mới']") WebElement btnsavenewpass;
	@FindBy(xpath = "//a[text()='Thoát']") WebElement Logout;
	
	
	public RegisterFactory(WebDriver _driver)
	{
		this.driver= _driver;
		PageFactory.initElements(_driver, this);
	}
	public void RegisterFunction(String hoten, String email, String ReEmail, String pass,String RePass,String phone)
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
	public void Login(String email, String password)
	{
		loginusername.sendKeys(email);
		loginpassword.sendKeys(password);
		btnlogin.click();
	}
	public void EditpassFunction(String username, String oldpass, String newpass) throws InterruptedException
	{
		Submenu.click();
		Edit.click();
		Thread.sleep(10000);
		Tendangnhap.sendKeys(username);
		Oldpass.sendKeys(oldpass);
		Newpass.sendKeys(newpass);
		Renewpass.sendKeys(newpass);
		btnsavenewpass.click();
		
	}
	
	public void logout() throws InterruptedException
	{
		Submenu.click();
		Thread.sleep(10000);
		Logout.click();
	}
	
}
