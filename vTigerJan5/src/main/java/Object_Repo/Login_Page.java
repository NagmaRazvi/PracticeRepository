
package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	//Initialization
		public Login_Page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		//Declration
		@FindBy(name="user_name")
		private WebElement usertextfield;
		
		@FindBy(name="user_password")
		private WebElement passwordtextfield;
		
		@FindBy (id="submitButton")
		private WebElement loginbutton;

		
		//getter method
		
		public WebElement getUsertextfield() {
			return usertextfield;
		}

		public WebElement getPasswordtextfield() {
			return passwordtextfield;
		}
		
	    public WebElement getLoginbutton() {
			return loginbutton;
		}

		// Business Logic
		public void loginToApp(String username,String password)
		{
			usertextfield.sendKeys(username);
			passwordtextfield.sendKeys(password);
			loginbutton.click();
		}
		

}
