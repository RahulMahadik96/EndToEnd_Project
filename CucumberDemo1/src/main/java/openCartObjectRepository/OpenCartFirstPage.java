package openCartObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartFirstPage {
	WebDriver driver;
	public OpenCartFirstPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountElement;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginPagButton;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchFieldElement;
	
	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement searchButtonElement;
	
	@FindBy(xpath = "//h3[text()='Featured']")
	private WebElement featuredElementOnFirstPage;
	
	public WebElement getMyAccountElement() {
		try {
			
			return myAccountElement;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getLoginPagButton() {
		try {
			return loginPagButton;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getSearchFieldElement() {
		try {
			return searchFieldElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getSearchButtonElement() {
		try {
			return searchButtonElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getFeaturedElementOnFirstPage() {
		try {
			return featuredElementOnFirstPage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	

}
