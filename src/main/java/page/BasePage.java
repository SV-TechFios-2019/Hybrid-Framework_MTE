package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage {
	
	   public static void waitForElement(WebElement element, WebDriver driver) {
       WebDriverWait wait = new WebDriverWait(driver, 30);
       wait.pollingEvery(2, TimeUnit.SECONDS);
	   wait.until(ExpectedConditions.visibilityOf(element));
	  }
   }
