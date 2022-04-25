import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RetestingSendKey {
	WebDriver driver;
	@BeforeClass
	public void launchBrowserAndUrl() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebdriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
	}
	
	@Test
	public void launchURL() {
		boolean loginVarify=driver.findElement(By.name("login")).isDisplayed();
		Assert.assertTrue(loginVarify,"StepFail: Login page unable to open");
		System.out.println("StepPass: Login page successfully open");
		
	    WebElement idElement= driver.findElement(By.id("email"));
		idElement.sendKeys("rahul123@gmail");
		Actions action=new Actions(driver); 
		action.keyDown(Keys.CONTROL).sendKeys("a"+"c").keyUp(Keys.CONTROL).perform();
		action.sendKeys(Keys.TAB).sendKeys(Keys.CONTROL+"v").perform();
		
		
		//idElement.sendKeys(Keys.CONTROL+"c");
		//idElement.sendKeys(Keys.TAB,Keys.CONTROL+"v");
		
	}
	
	
	

}
