package objectRepositoryForHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMForgotPassworPage {
	WebDriver driver;
	public HRMForgotPassworPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']")
	private WebElement forgotPasswordPagePanlElement;
	
	@FindBy(id = "securityAuthentication_userName")
	private WebElement forgotPasswordUsernameElement;
	
	@FindBy(xpath = "//div[@class='message warning fadable']")
	private WebElement requestmassagElement;
	
	@FindBy(xpath = "//input[@value='Reset Password']")
	private WebElement resetPasswordElement;
	
	public WebElement getForgotPasswordPagePanlElement() {
		try {
			return forgotPasswordPagePanlElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getForgotPasswordUsernameElement() {
		try {
			return forgotPasswordUsernameElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getRequestmassagElement() {
		try {
			return requestmassagElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getResetPasswordElement() {		
		try {
			return resetPasswordElement;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
