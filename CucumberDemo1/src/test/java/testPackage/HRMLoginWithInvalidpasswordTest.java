package testPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excelLabrary.ExcelLabrary;
import objectRepositoryForHRM.HRMForgotPassworPage;
import objectRepositoryForHRM.HRMHomePage;
import objectRepositoryForHRM.HRMLoginPage;

public class HRMLoginWithInvalidpasswordTest {
	WebDriver driver;
	HRMLoginPage lp;
	HRMHomePage hp;
	HRMForgotPassworPage fp;
	
	String username;
	String password;	
	String driverPath;
	String websitURL;
	@BeforeTest
	public void data() throws EncryptedDocumentException, IOException {
		ExcelLabrary testdata=new ExcelLabrary();
		testdata.setData();
		
		username= testdata.getUserList().get(4);
		password= testdata.getPasswordList().get(4);		
		websitURL= testdata.getUserList().get(3);
		driverPath= testdata.getPasswordList().get(3);
	}
	
	@BeforeClass
	public void luanchHRM() {
		System.setProperty("webdriver.chrome.driver", driverPath);
	    driver=new ChromeDriver();
		lp=new HRMLoginPage(driver);
		hp=new HRMHomePage(driver);
		fp=new HRMForgotPassworPage(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get(websitURL);
	}
	
	@Test
	public void hrmLoginTestWithInvalidPassword() {
		
		boolean lpIsDisplayed= lp.getLoginPan().isDisplayed();
		Assert.assertTrue(lpIsDisplayed, "StapFail: Login Page is not Opened");
		System.out.println("StapPass: Login Page successfuly opened");
		
		lp.getUsernameElement().sendKeys(username);
		lp.getPasswordElement().sendKeys(password);
		lp.getLoginBotton().click();
		
		boolean hlisDisplayed=false;
		
		 try {		
			 	hlisDisplayed= hp.getHomePageLogo().isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		Assert.assertFalse(hlisDisplayed,"StapFail: Login Successful with invalid Password");
		System.out.println("StapPass: Login unsuccessful with invalid password");
		
		String etext=lp.getErreMassegElement().getText();
		Assert.assertEquals(etext, "Invalid credentials","StapFail: Invalid credentials masseg Not displayed");
		System.out.println("StapPass: Invalid credentials masseg is displayed");
		
		lp.getForgotPasswordElement().click();
		boolean FppIsDisplayed=fp.getForgotPasswordPagePanlElement().isDisplayed();
		Assert.assertTrue(FppIsDisplayed,"StapFail: Forgot Password Page Not opened");
		System.out.println("StapPass: Forgot password page successfully opened");
		
		fp.getForgotPasswordUsernameElement().sendKeys(username);
		fp.getResetPasswordElement().click();
		
		boolean rmIsDisplayed= fp.getRequestmassagElement().isDisplayed();
		Assert.assertTrue(rmIsDisplayed,"StepFail: Requst Conform masseg not displayed");
		System.out.println("StepPass: Requst conform masseg is displayed");
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
