package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage {

	public OrganizationCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declration
	@FindBy(xpath="//img[contains(@src,'themes/softed/images/btnL3Add.gif')]")
	private WebElement OrganisationCreateImage;
	
	@FindBy(name="accountname")
	private WebElement OrganizationNameTextField;
	
	@FindBy(name="button")
	private WebElement SaveButton;

	//Getters
	public WebElement getOrganisationCreateImage() {
		return OrganisationCreateImage;
	}

	public WebElement getOrganizationNameTextField() {
		return OrganizationNameTextField;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	//Business Logic
	/**
	 * This method is used to click + image
	 */
	public void ClickOrganizationCreateImage()
	{
		OrganisationCreateImage.click();
	}
	/**
	 * This method is used to pass valiue to organization name text field
	 */
	public void OrganizationNameTextField(String orgName)
	{
		OrganizationNameTextField.sendKeys(orgName);
	}
	/**
	 * This method is used to click on save button
	 */
	public void SaveButton()
	{
		SaveButton.click();
	}
	
	
}
