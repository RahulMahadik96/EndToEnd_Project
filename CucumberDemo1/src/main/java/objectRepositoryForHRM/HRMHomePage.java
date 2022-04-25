package objectRepositoryForHRM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HRMHomePage {
	WebDriver driver;
	public HRMHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'default/images/logo.png')]")
	private WebElement HomePageLogo;
	
	@FindBy(id="welcome")
	private WebElement loggerNameElement;
	
	@FindBy(linkText = "Logout") 
	private WebElement loggedOutElement;
	public WebElement getHomePageLogo() {
		try {
			return HomePageLogo;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getLoggerNameElement() {
		try {
			return loggerNameElement;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getLoggedOutElement() {
		try {
			return loggedOutElement;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return null;
	}
	
	

}
