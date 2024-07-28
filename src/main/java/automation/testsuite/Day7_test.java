package automation.testsuite;

import automation.common.commonBase;
import org.testng.annotations.*;

public class Day7_test extends commonBase{
	@BeforeMethod
	public void openBrowser()
	{
		System.out.println("This methos to open chrome browser");
		
	}
	@Test
	public void testcase_1()
	{
		System.out.println("This method to test case 1:");
	}
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("this method to close chrome browser");
	}

}
