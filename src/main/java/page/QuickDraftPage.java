package page;

import java.util.Random;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;




public class QuickDraftPage extends BasePage {

	WebDriver driver;
	
	public QuickDraftPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	// Elements to create QuickDraftPage
	
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Dashboard')]")
    WebElement QuickDraftTitle;
    @FindBy(how = How.ID, using = "title")
	WebElement Title;
	@FindBy(how = How.ID, using = "content")
	WebElement Content;
	@FindBy(how = How.ID, using = "save-post")
	WebElement SaveButton;
  
	// Elements to validate your recent draft
	@FindBy(how = How.XPATH, using = "//div[@class = 'drafts']/descendant::a")   //h2[contains(text(),'Your Recent Drafts')]/parent::div/descendant::a
	WebElement PostedTitle;
	@FindBy(how = How.XPATH, using = "//div[@class = 'drafts']/descendant::p") //h2[contains(text(),'Your Recent Drafts')]/parent::div/descendant::p
	WebElement PostedContent;	

	// Elements needed to validate quickdraft shows in the table
	@FindBy(how = How.XPATH, using = "//div[@class='wp-menu-image dashicons-before dashicons-admin-post']")
	WebElement Posts;
	@FindBy(how = How.LINK_TEXT, using = "//li[@id='menu-posts']/descendant::a[text()='All Posts']")
	WebElement AllPosts;
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Posts')]")
	WebElement PostsTitle;
	@FindBy(how = How.XPATH, using = "//a[@class = 'row-title']")
	WebElement DraftinTable;
	
	
	//Method to interact with the elements	
	public void waitForDraftPage() {
	       waitForElement(QuickDraftTitle, driver);
	    }
	// Method used to create a quickdraft
    public void quickDraftCreated() {
    // Method used to create a quick draft		
       Random random = new Random();     
       String eTitle = "Automation World"  + String.valueOf(random.nextInt(999));
       String eContent = "Selenium with Java" + String.valueOf(random.nextInt(999));  
       JavascriptExecutor jse = (JavascriptExecutor) driver;
	   jse.executeScript("arguments[0].scrollIntoView();", SaveButton);    
         Title.sendKeys(eTitle);
	     Content.sendKeys(eContent);
		 SaveButton.click(); 
         }
	 // Methods to validate your recent drafts
	 public boolean isDisplayed() {
		  Posts.isDisplayed();
		  return Posts.isDisplayed();
	      }
	 // Method to access the table
	 public void GotoPosts() {
	      Actions action = new Actions(driver);
	      action.moveToElement(Posts).build().perform();
	      Posts.click();
	      }
	      public void HoverOverPosts() {
	      Actions action = new Actions(driver);
	      action.moveToElement(Posts).build().perform();
	      AllPosts.click();
	      }
	  // Methods to validate table showed
	  public void waitForDraftTablePage(){
	  	  waitForElement(PostsTitle, driver);
	      }
	  // Validate the post visible in the table
	  public boolean isPostedOnTitleTable() {
		  DraftinTable.isDisplayed();
          return DraftinTable.isDisplayed(); 	   	  	   
          }
       }


		 	    	   
           
	
       

