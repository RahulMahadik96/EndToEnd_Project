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
import objectRepositoryForHRM.HRMHomePage;
import objectRepositoryForHRM.HRMLoginPage;

public class HRMLoginWithValidCredentialTest {
	WebDriver driver;
	
	HRMLoginPage lp;
	HRMHomePage hp;	
	
	String userid;
	String password;
	String websitURL;
	String driverPath;
	
	@BeforeTest
	public void excelData() throws EncryptedDocumentException, IOException {
		ExcelLabrary data=new ExcelLabrary();
		
		data.setData();
		userid=data.getUserList().get(0);
		password=data.getPasswordList().get(0);
		websitURL=data.getUserList().get(3);
		driverPath=data.getPasswordList().get(3);
		
	}

	@BeforeClass
	public void luanchOrangHRM() {
		System.setProperty("webdriver.chrome.driver", driverPath);
	    driver=new ChromeDriver();
		lp=new HRMLoginPage(driver);
		hp=new HRMHomePage(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(websitURL);
	}
	
	@Test
	public void testOrangHRM() {
		
		boolean panlisDisplayed= lp.getLoginPan().isDisplayed();
		Assert.assertTrue(panlisDisplayed,"StapeFail: Login Page is not Found");
		System.out.println("StapPass: We are on Login page");
		lp.getUsernameElement().sendKeys(userid);
		lp.getPasswordElement().sendKeys(password);
		lp.getLoginBotton().click();
		
		boolean homeLogoIsDisplayed= hp.getHomePageLogo().isDisplayed();
		Assert.assertTrue(homeLogoIsDisplayed, "StapeFail: Login not Successful we are not on Home Page ");
		System.out.println("StapPass: Login is Successful we are on Home page");
		
	    String userName= hp.getLoggerNameElement().getText().substring(8);
	    System.out.println("User Name is: "+userName);
	    
	    hp.getLoggerNameElement().click();
	    hp.getLoggedOutElement().click();
	    
		boolean isDisplayed= lp.getLoginPan().isDisplayed();
		Assert.assertTrue(isDisplayed,"StapFail: we are not Successfully logged out");
		System.out.println("StapPass: Successfully Logged out ");
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
	
}
