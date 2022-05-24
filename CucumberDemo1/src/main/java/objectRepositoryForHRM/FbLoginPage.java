package objectRepositoryForHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPage {
	WebDriver driver;
	public FbLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//form[@data-testid='royal_login_form']")
	private WebElement loginFormElement;
	
	@FindBy(id = "email")
	private WebElement useridElement;
	
	@FindBy(id="pass")
	private WebElement passwordElement;
	
	@FindBy(xpath = "//button[@name='login']")
	private WebElement loginButtonElement;
	
	
	public WebElement getLoginFormElement() {
		try {
			return loginFormElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getUseridElement() {
		try {
			return useridElement;
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

	public WebElement getLoginButtonElement() {
		try {
			return loginButtonElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
