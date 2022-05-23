package openCartObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartSearchPage {
	WebDriver driver;
	
	public OpenCartSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[text()='Search Criteria']")
	private WebElement searchCriteriaElement;
	
	@FindBy(xpath = "//a[text()='iMac']")
	private WebElement searchediMacElement;
	
	@FindBy(xpath = "//button[@data-original-title='Compare this Product']")
	private WebElement comparButtonElement;
	
	@FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
	private WebElement comparAddedSuccessMassageElement;
	
	@FindBy(id = "input-search")
	private WebElement searchCritariaFieldElement;
	
	@FindBy(xpath = "//select[@name='category_id']")
	private WebElement selectCategoryElement;
	
	@FindBy(xpath = "//input[@name='sub_category']")
	private WebElement selectSubCategoryElement;
	
	@FindBy(xpath = "//input[@name='description']")
	private WebElement searchInDescriptionElement;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement searchCaritariaButtonElement;
	
	@FindBy(id = "list-view")
	private WebElement listViewElement;
	
	@FindBy(id="grid-view")
	private WebElement gridViewElement;
	
	@FindBy(xpath = "//p[contains(text(),'no product that matches')]")
	private WebElement productNoMachesIndicationElement;
	
	@FindBy(xpath = "//div[contains(text(),'1 of 1')]")
	private WebElement singleProductMacheElement;
	
	@FindBy(xpath = "//div[contains(text(),'4 of 4')]")
	private WebElement multiProductMachesElement;


	public WebElement getSearchCriteriaElement() {
		try {
			return searchCriteriaElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getSearchediMacElement() {
		try {
			return searchediMacElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getComparButtonElement() {
		try {
			return comparButtonElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getComparAddedSuccessMassageElement() {
		try {
			return comparAddedSuccessMassageElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getSearchCritariaFieldElement() {
		try {
			return searchCritariaFieldElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getSelectCategoryElement() {
		try {
			return selectCategoryElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getSelectSubCategoryElement() {
		try {
			return selectSubCategoryElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getSearchInDescriptionElement() {
		try {
			return searchInDescriptionElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getSearchCaritariaButtonElement() {
		try {
			return searchCaritariaButtonElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getListViewElement() {
		try {
			return listViewElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getGridViewElement() {
		try {
			return gridViewElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getProductNoMachesIndicationElement() {
		try {
			return productNoMachesIndicationElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getSingleProductMacheElement() {
		try {
			return singleProductMacheElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement getMultiProductMachesElement() {
		try {
			return multiProductMachesElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	

}
