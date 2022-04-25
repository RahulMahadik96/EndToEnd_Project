package objectRepositoryForHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HRMLoginPage {
	WebDriver driver;
	public HRMLoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(xpath="//div[text()='LOGIN Panel']")
	private WebElement loginPan;
	
	@FindBy(id="txtUsername")
	private WebElement usernameElement;
	
	@FindBy(id="txtPassword")
	private WebElement passwordElement;
	
	@FindBy(id="btnLogin")
	private WebElement loginBotton;
	
	@FindBy(xpath = "//span[normalize-space()='Invalid credentials']")
	private WebElement erreMassegElement;
	
	@FindBy(linkText = "Forgot your password?")
	private WebElement forgotPasswordElement;
	
	public WebElement getLoginPan() {
		try {
			return loginPan;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getUsernameElement() {
		try {
			return usernameElement;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getPasswordElement() {
		try {
			return passwordElement;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getLoginBotton() {
		try {
			return loginBotton;
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getErreMassegElement() {
		try {
			return erreMassegElement;
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getForgotPasswordElement() {
		try {
			return forgotPasswordElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
