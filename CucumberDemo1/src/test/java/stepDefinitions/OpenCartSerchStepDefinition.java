package stepDefinitions;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import openCartObjectRepository.OpenCartFirstPage;
import openCartObjectRepository.OpenCartLoginPage;
import openCartObjectRepository.OpenCartSearchPage;
import resorces.Base;

public class OpenCartSerchStepDefinition extends Base{
	WebDriver driver;
	 OpenCartFirstPage fPage;
	 OpenCartLoginPage lPage;
	 OpenCartSearchPage sPage;
	
	 @Before
	 public void launchBrowser() throws IOException {
		 driver=initializeDriver();
		 driver.get("https://demo.opencart.com/");
		 fPage= new OpenCartFirstPage(driver);
		 lPage=new OpenCartLoginPage(driver);
		 sPage=new OpenCartSearchPage(driver);
	 }
	 @Given("^User on the Home page with login \"([^\"]*)\"$")
	    public void user_on_the_home_page_with_login_something(String strArg1){		

		boolean isdisplayed= fPage.getFeaturedElementOnFirstPage().isDisplayed();
		Assert.assertTrue(isdisplayed,"StapeFail: User is not on the Home page");
		System.out.println("StepPass: User on the Home Page");
		 
		 if(strArg1.contains("true")) {
			 fPage.getMyAccountElement().click();	
			 fPage.getLoginPagButton().click();
			 
			 isdisplayed=lPage.getLoginOptiontoCustomer().isDisplayed();
			 Assert.assertTrue(isdisplayed,"StepFail: User not on the Login Page");
			 System.out.println("StepPass: User on the Login Page");
			 
			 lPage.getUserIDElement().clear();
			 lPage.getPasswordElement().clear();
			 lPage.getUserIDElement().sendKeys("mahadikra39@gmail.com");
			 lPage.getPasswordElement().sendKeys("rahulmahadik1996");
			 lPage.getLoginButtonElement().click();			 
			 isdisplayed=lPage.getLogoutElement().isDisplayed();
			 Assert.assertTrue(isdisplayed,"StepFail: Login is unsuccessful");
			 System.out.println("StepPass: Login is successful");
			
		 }
	    }

	    @When("^clicking on the search by entering product \"([^\"]*)\" and compare product \"([^\"]*)\"$")
	    public void clicking_on_the_search_by_entering_product_something_and_compare_product_something(String strArg1, String strArg2) throws Throwable {
	    	 
	    	String product=strArg1;
	    	if(product.contains("NA")==false) {
			 fPage.getSearchFieldElement().sendKeys(product);
			 fPage.getSearchButtonElement().click();		
	    	  }
	    	else {
	    		fPage.getSearchButtonElement().click();
	    	}
	    	
			 if(strArg2.contains("true")) {
				sPage.getComparButtonElement().click();
			   boolean isdisplayed=sPage.getComparAddedSuccessMassageElement().isDisplayed();
				Assert.assertTrue(isdisplayed,"StepFail: Unable to add a product to compar");
				System.out.println("StepPass: Successfull product added to compar");				
			 }
			 	    	
	    }

	    @And("^Search the product by entering \"([^\"]*)\" in the search criteria \"([^\"]*)\"$")
	    public void search_the_product_by_entering_something_in_the_search_criteria_something(String strArg1, String strArg2) throws Throwable {
	     
	    	if(strArg2.contains("true")) {
	    		boolean isdispayed= sPage.getSearchCritariaFieldElement().isDisplayed();
	    		Assert.assertTrue(isdispayed,"StepFail: Search Critaria Field is not displayed");
	    		System.out.println("StepPass: Search Critaria Field is displayed");
	    		
	    		isdispayed=sPage.getSelectCategoryElement().isDisplayed();
	    		Assert.assertTrue(isdispayed,"StepFail: select Category is not displayed");
	    		System.out.println("StepPass: select Category  is displayed");
	    		
	    		isdispayed=sPage.getSearchInDescriptionElement().isDisplayed();
	    		Assert.assertTrue(isdispayed,"StepFail:Search in Description is not displayed");
	    		System.out.println("StepPass: Search in Description  is displayed");
	    		
	    		sPage.getSearchCritariaFieldElement().sendKeys(strArg1);
	    		sPage.getSearchCaritariaButtonElement().click();    		
	    		
	    	}
	    	
	    }

	    @And("^Bydefault products view in the list and click on the Grid \"([^\"]*)\"$")
	    public void bydefault_products_view_in_the_list_and_click_on_the_grid_something(String strArg1) throws Throwable {
	        
	    	if(strArg1.contains("true")) {
	   	    		
	    		String ClassValue=sPage.getListViewElement().getCssValue("class");
	    		Assert.assertEquals(ClassValue.contains("active"),true, "StepFail:By defoult product not in a List view on search page");
	    		System.out.println("StepPass: Bydefoult product in list view on the search page");
	    		
	    		sPage.getGridViewElement().click();	    			    		
	    		
	    	}
	    }
	    
	    @Then("^Search product \"([^\"]*)\" with two or more number \"([^\"]*)\"$")
	    public void search_product_something_with_two_or_more_number_something(String strArg1, String strArg2) throws Throwable {
	    	
	    	if(strArg1.contains("true")) {
	    		boolean isdiplayed=sPage.getSearchediMacElement().isDisplayed();
	    		Assert.assertTrue(isdiplayed,"StepFail: existing Product is not displeyed");
	    		isdiplayed=sPage.getSingleProductMacheElement().isDisplayed();
	    		Assert.assertTrue(isdiplayed,"StapFail: More than one porduct maches but single requred");
	    		
	    		System.out.println("StepPass: Product Successfully searched ");
	    	}
	    	else if(strArg2.contains("true")) {
	    		
	    		boolean isdiplayed=sPage.getSearchediMacElement().isDisplayed();
	    		Assert.assertTrue(isdiplayed,"StepFail: existing Product is not mache");
	    		isdiplayed=sPage.getMultiProductMachesElement().isDisplayed();
	    		Assert.assertTrue(isdiplayed,"StapFail: More than one porduct not maches ");
	    		
	    		System.out.println("StepPass: More than one Products Successfully searched ");
	    		
	    	}
	    	else {
	    		boolean isdisplayed=sPage.getProductNoMachesIndicationElement().isDisplayed();
	    		Assert.assertTrue(isdisplayed,"StepPass: No procut Mach massege is not displayed");
	    		System.out.println("StepPass: No Procut maches with non-existing product or with the blank search");
	    	}
	       
	    }

	    @And("^product display in the Grid view \"([^\"]*)\"$")
	    public void product_display_in_the_grid_view_something(String strArg1) throws Throwable {
	    	
	       
             if(strArg1.contains("true")) {
    	    String ClassValue=sPage.getGridViewElement().getCssValue("class");
    	    Assert.assertEquals(ClassValue.contains("active"),true, "StepFail:By defoult product not in a Grid view on search page");
    	    String ClassValue2=sPage.getListViewElement().getCssValue("class");
    		Assert.assertEquals(ClassValue2.contains("active"),false, "StepFail:Product is in a List view After selecting Grid view");
    	    
    		System.out.println("StepPass: Bydefoult product in Grid view on the search page");
             }
	    }
	    
	    @After
	    public void closeDriver() {
	    	driver.quit();
	    }


}
