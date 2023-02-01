package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreatePage 
{


//Initiallization
public ProductCreatePage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

//Declaratiom
@FindBy(xpath="//img[@alt='Create Product...']")
private WebElement ProductcreateImage;

@FindBy(xpath="productname")
private WebElement ProductNameTextField;

@FindBy(name="button")
private WebElement SaveButton;

//Getters
public WebElement getProductcreateImage() {
	return ProductcreateImage;
}

public WebElement getProductNameTextField() {
	return ProductNameTextField;
}

public WebElement getSaveButton() {
	return SaveButton;
}

//Business class logic

public void clickProductcreateImage()
{
	ProductcreateImage.click();
}

public void ProductNameTextField(String productName)
{
	ProductNameTextField.sendKeys(productName);
}

public void SaveButton()
{
	SaveButton.click();
}



}
