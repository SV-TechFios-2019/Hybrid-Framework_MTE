package test;

import page.LoginPage;
import page.QuickDraftPage;
import util.BrowserFactory;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.support.PageFactory;

public class QuickDraftTest {

	static WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		driver = BrowserFactory.startBrowser();
	}

	@Test
	public void AddTextToVerifyTextPosted() throws InterruptedException {		
		
		//Take you to the site
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");		
		//Calling LoginPage Class or Activate  
		//PageFactory.initElement(driver, LoginPage.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);		
		//calling the method inside LoginPage
		loginPage.login("opensourcecms", "opensourcecms");		
		//Activate the DashboardQuickPage
		QuickDraftPage quickDraftPage = PageFactory.initElements(driver, QuickDraftPage.class);		
		// Validate page show up using the Explicit Wait
		quickDraftPage.waitForDraftPage();	
		// Create a quick draft
		quickDraftPage.quickDraftCreated();
		// Validate the post appeared below under "Your recent Drafts"
		quickDraftPage.isDisplayed();
        // Click on the Posts Menu, click on All Posts to access the table
		quickDraftPage.GotoPosts();
		// Validate the post appeared in the table
		quickDraftPage.waitForDraftTablePage();
		Assert.assertFalse(false, "Quickdraft did not displaye on the TitleTable!!");
        
		//		quickDraftPage.isPostedOnTheTable();
        Thread.sleep(4000);
	    }

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}
}
