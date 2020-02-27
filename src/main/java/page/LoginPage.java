package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "user_login") 
	WebElement Username;
	@FindBy(how = How.ID, using = "user_pass") 
	WebElement Password;
	@FindBy(how = How.ID, using = "wp-submit") 
	WebElement LogIn;
	
	public void login(String username, String password) {

		Username.sendKeys(username);
		Password.sendKeys(password);
		LogIn.click();
		}
        public String getPageTitle() {
	    return driver.getTitle();
       }
    }
