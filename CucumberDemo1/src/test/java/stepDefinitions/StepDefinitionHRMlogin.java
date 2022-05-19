package stepDefinitions;

import java.time.Duration;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefinitionHRMlogin {
	   
	WebDriver driver;
	
	  @Given("^User is on the Login Page$")
	    public void user_is_on_the_login_page() throws Throwable {
		  
		    String basPath=System.getProperty("user.dir");
		    String path=basPath+"\\chromedriver.exe";
	        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
	        driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	        boolean isDisplayed= driver.findElement(By.id("logInPanelHeading")).isDisplayed();
	        if(isDisplayed) 
	        	System.out.println("StepPass: Login page is successfully open");	        
	        else 
	        	System.out.println("StepFail: Login page is unable to open");
	        
	    }

	  @When("^User clicks on Login by entering username(.+) and password(.+)$")
	    public void user_clicks_on_login_by_entering_username_and_password(String userid, String passwords) throws Throwable {
	     
	    	
	    	driver.findElement(By.id("txtUsername")).sendKeys(userid);
	    	driver.findElement(By.id("txtPassword")).sendKeys(passwords);
	    	driver.findElement(By.id("btnLogin")).click();

	    }

	  @Then("^Login successful \"([^\"]*)\"$")
	    public void login_successful_something(boolean methodstat) throws Throwable {
	       boolean homeisDisplayed=false;
		try {
			homeisDisplayed = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	      if (methodstat) {	
	        if (homeisDisplayed) 
			 System.out.println("StepPass: Login is successful Home page is opened with valid credentials");
	        else 
			 System.out.println("StepFail: Login unsuccessful Home page is not open with valid credentials");
	      }  
	     else {
	    	 if (homeisDisplayed==false) 
				 System.out.println("StepPass: Login is unsuccessful with invalid password");
		        else 
				 System.out.println("StepFail: Login is successful Home page opened with invalid password");
		 }
	    }

	  @And("^Username is displayed \"([^\"]*)\"$")
	    public void username_is_displayed_something(boolean methodstat) throws Throwable {
	    
	     if(methodstat) {
	       WebElement welcomElement=driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"));
	       String userName=welcomElement.getText().substring(8);
	       System.out.println("Login User Name is: "+userName);
	       welcomElement.click();
	       driver.findElement(By.partialLinkText("Logout")).click();
	     }
	    
	    driver.quit();
	    }
	    
	   


}
