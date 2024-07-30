package automation.testsuite;

import automation.common.commonBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day7 extends commonBase{
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
