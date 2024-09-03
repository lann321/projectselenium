package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RaiseFactory_day15 {
	private WebDriver driver;
	@FindBy(id = "email") WebElement Email;
	@FindBy(id = "password") WebElement Password;
	@FindBy(xpath = "(//div[@class='rc-anchor-center-container'])[1]") WebElement CheckBoxNotRobot;
	
	@FindBy(xpath = "//button[text()='Sign in']") WebElement btnSignIn;
	
	@FindBy(xpath = "//span[text()='Clients']") WebElement submenuClient;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[3]") WebElement addclient;
	@FindBy(id = "type_organization") WebElement checkboxOrganization;
	@FindBy(id ="company_name") WebElement CompanyName;
	@FindBy(id = "s2id_created_by") WebElement dropdownOwner;
	@FindBy(id ="address") WebElement Address;
	@FindBy(id ="city") WebElement City;
	@FindBy(id ="state") WebElement State;
	@FindBy(id ="zip") WebElement Zip;
	@FindBy(id ="country") WebElement Country;
	@FindBy(id ="phone") WebElement Phone;
	@FindBy(xpath = "//button[@type='submit']")WebElement btnSaveClient;
	@FindBy(xpath = "//input[@class='form-control form-control-sm']") WebElement searchClient;

	public RaiseFactory_day15(WebDriver _driver)
	{
		this.driver= _driver;
		PageFactory.initElements(_driver, this);
	}
	 public void loginRase(String email, String pass) throws InterruptedException
	 {
		
		 Email.clear();
		 Password.clear();
		 Thread.sleep(10000);
		 CheckBoxNotRobot.click();
		 Email.sendKeys(email);
		 Password.sendKeys(pass);
		 btnSignIn.click();
	 }
		 
	 public  void AddClient(String companyname,String address, String phone) throws InterruptedException
	 {
		 
		 submenuClient.click();
		 addclient.click();
		CompanyName.sendKeys(companyname);
		Address.sendKeys(address);
		Phone.sendKeys(phone);
		Thread.sleep(10000);
		Select dropdown = new Select(dropdownOwner);
		dropdown.selectByVisibleText("Michael Wood");
		Thread.sleep(10000);
		btnSaveClient.click();
		
	 }
	 
	
}
	
	
