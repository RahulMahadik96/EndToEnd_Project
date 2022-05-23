package openCartObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartLoginPage {
	WebDriver driver;
	
	public OpenCartLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement userIDElement;
	
	@FindBy(id="input-password")
	private WebElement passwordElement;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButtonElement;
	
	@FindBy(xpath = "//i[@class='fa fa-home']")
	private WebElement homeButtonElement;
	
	@FindBy(xpath = "//h2[text()='Returning Customer']")
	private WebElement loginOptiontoCustomer;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutElement;

	public WebElement getHomeButtonElement() {
		try {
			return homeButtonElement;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public WebElement setHomeButtonElement(WebElement homeButtonElement) {
		try {
			this.homeButtonElement = homeButtonElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getUserIDElement() {
		try {
			return userIDElement;
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

	public WebElement getLoginOptiontoCustomer() {
		try {
			return loginOptiontoCustomer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getLogoutElement() {
		try {
			return logoutElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	

}
