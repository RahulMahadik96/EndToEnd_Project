package testPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excelLabrary.ExcelLabrary;

public class FBSignUpTest {
	
	WebDriver driver;
	String pasword;
	String sname;
	String fname;
	
	@BeforeTest
	public void getDataFromExcel() throws EncryptedDocumentException, IOException {
		ExcelLabrary data=new ExcelLabrary();
		data.setData();
		fname=data.getUserList().get(1);
		sname=data.getPasswordList().get(1);
		pasword=data.getPasswordList().get(2);
		
	}
		
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	
	@BeforeClass
	public void launchFaceBookLogin() {
		driver.get("https://www.facebook.com/");
		boolean isDisplayed=driver.findElement(By.xpath("//img[@alt='Facebook']")).isDisplayed();
		Assert.assertEquals(isDisplayed, true, "StapFailled: We are not on FB Login Or Singup Page");
		System.out.println("StapPass: FB Login or Sign Up page Successfully Open");
	}
	
	@Test  
	public void openSingUp() {
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		boolean isDisplayed=driver.findElement(By.xpath("//div[text()='Sign Up']")).isDisplayed();
		Assert.assertEquals(isDisplayed,true,"StapeFailed: SignUp Popup Not opened");
		System.out.println("StapePass: Signup Popup successfully open");
	}
	
	
	@Test (dependsOnMethods = "openSingUp")
	public void sendInput() {
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(sname);
		driver.findElement(By.name("reg_email__")).sendKeys("7758972804");
		driver.findElement(By.name("reg_passwd__")).sendKeys(pasword);
	}
	
	@Test (dependsOnMethods = "openSingUp")
	public void setBirthDate() {
		WebElement dateElement=driver.findElement(By.id("day"));
		Select select=new Select(dateElement);
		select.selectByIndex(8);
		
		dateElement=driver.findElement(By.id("month"));
		select=new Select(dateElement);
		select.selectByVisibleText("Jun");
		
		dateElement=driver.findElement(By.id("year"));
		select=new Select(dateElement);
		select.selectByValue("1998");
	}
	
	@Test (dependsOnMethods = "openSingUp", invocationCount = 2)
	public void setGender() throws InterruptedException {
		WebElement male=driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
		male.click();
		boolean isSelected=male.isSelected();
		Assert.assertTrue(isSelected,"StapeFail: Male RedioBotton is not selected After clicking");
		System.out.println("StepPass: Male RedioBotton is Selected after clicking ");
		
		isSelected=driver.findElement(By.xpath("//label[text()='Female']")).isSelected();
		Assert.assertFalse(isSelected,"StapFail: Female ReidioBotton is Enable After Clicking on Male ");
		System.out.println("StapePass: Gender Female is Disable After clicling");
		
		isSelected=driver.findElement(By.xpath("//label[text()='Custom']")).isSelected();
		Assert.assertFalse(isSelected,"StapFail: Custom ReidioBotton is Enable After clicking on male ReidioBotton");
		System.out.println("StapePass: Gender Custom is Disable After clicling");
	}
	
	@AfterTest
	public void closeDriver() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	

}
