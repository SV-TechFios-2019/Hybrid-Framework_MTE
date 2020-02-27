package test;

import page.LoginPage;
import org.testng.Assert;
import util.BrowserFactory;
import page.QuickDraftPage;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import org.openqa.selenium.support.PageFactory;


public class LoginTest {
	        
	static WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
	driver = BrowserFactory.startBrowser();
	} 
	@Test(priority = 1)
	public void validUserShouldBeAbleToLogin() {

	// Take you to the site
	driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");

	// Calling LoginPage Class or Activate
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

 // Validate page show up using the title
 //	String expectedTitle = "Log In ‹ opensourcecms — WordPress"; // To store the actual title
 //	String actualTitle = loginPage.getPageTitle(); // To get and store the title
 //	System.out.println(actualTitle); // To print
 //	Assert.assertEquals(actualTitle, expectedTitle, "Wrong page!");
	Assert.assertEquals(loginPage.getPageTitle(), "Log In ‹ opensourcecms — WordPress", "Wrong page!");
	
	// Call the login method from the LoginPage Class
	loginPage.login("opensourcecms", "opensourcecms");

	// Validate page show up using the Explicit Wait
	QuickDraftPage quickdraftPage = PageFactory.initElements(driver, QuickDraftPage.class); // Object Reference
	quickdraftPage.waitForDraftPage();
	}

	@Test(priority = 2)
	public void invalidUserShouldNotBeAbleToLogin() throws InterruptedException {

	// Take you to the site
	driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");

	// Calling LoginPage Class or Activate
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

	// Validate page show up using the title
    String expectedTitle = "Log In ‹ opensourcecms — WordPress"; // To store the actual title
    String actualTitle = loginPage.getPageTitle(); // To get and store the title
    System.out.println(actualTitle); // To print
    Assert.assertEquals(actualTitle, expectedTitle, "Wrong page!");
	//Assert.assertEquals(loginPage.getPageTitle(), "Log In ‹ opensourcecms — WordPress", "Wrong page!");
	
	// Call the login method from the LoginPage Class - opensourcecms
	loginPage.login("invalidgmail.com", "opensourcecms");     

	// Validate QuickDarftPage did not show up using Explicit Wait try/catch
	QuickDraftPage quickdraftPage = PageFactory.initElements(driver, QuickDraftPage.class); // Object Reference
    Thread.sleep(4000);   
	//Assert.assertFalse(quickDraftPage.isQuickDraftPageDisplayed(), "Invalid User was able to login!!");
	Assert.assertEquals(loginPage.getPageTitle(), "Log In ‹ opensourcecms — WordPress", "Wrong page!");
	}
	@AfterMethod
	public void close() {
	driver.close();
	driver.quit();
    }
}	

