package testPackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepositoryForHRM.AutoSuggestionPage;
import resources.Base;

public class AutoSuggestionsTest extends Base{
	WebDriver driver;
	AutoSuggestionPage aSP;
	
	@BeforeClass
	public void launchBrowserAndURL() throws IOException{
		driver=initializeDriver();
		aSP=new AutoSuggestionPage(driver);
		driver.get(prop.getProperty("AutoSuggestionURL"));
	}
	
	@Test
	public void autoSuggestionTest() {
		boolean isdisplayed=aSP.getGoogleIMElement().isDisplayed();
		Assert.assertTrue(isdisplayed,"StepFail: We are not on google search page");
		System.out.println("StepPass: We are on the google search Page");
		
		aSP.getSearchElement().sendKeys("selenium");
		
	    List<WebElement> autoElements=driver.findElements(aSP.getAutosuggetion());
	    int size= autoElements.size();
	    
	    System.out.println("Total Autosuggestions are: "+size);
	    
	    for(WebElement tempE:autoElements){
	    	String text= tempE.getText();
	    	if(text.contains("selenium webdriver")) {
	    		tempE.click();
	    		break;
	    	}
	    }
	    
	   isdisplayed= aSP.getSearchedElement().isDisplayed();
	   Assert.assertTrue(isdisplayed,"StepFail: Unable to search selected element");
	   System.out.println("StepPass: Selected element successfully search");	    	    
		
	}	

}
