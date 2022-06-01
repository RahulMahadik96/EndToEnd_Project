package testPackage;


import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepositoryForHRM.FbLoginPage;
import resources.Base;

public class SendKeysTest extends Base{
	public WebDriver driver;
	   FbLoginPage flPage;
	@BeforeClass
	public void launchBrowserAndURL() throws IOException {
		driver=initializeDriver();	
		driver.get("https://en-gb.facebook.com/");
		flPage=new FbLoginPage(driver);		
	}
	
	@Test
	public void sendKeysTest() throws InterruptedException {
		
		boolean isdisplyaed=flPage.getLoginFormElement().isDisplayed();
		Assert.assertTrue(isdisplyaed,"StepFail: We are not on login page");
		System.out.println("StepPass: We are on login page");
		
		 WebElement uIElement= flPage.getUseridElement();
		uIElement.sendKeys("UserRahul");
		uIElement.sendKeys(Keys.CONTROL+"A"+"C");
		uIElement.sendKeys(Keys.TAB+""+ Keys.CONTROL+"V");	
		flPage.getLoginButtonElement().click();
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}
