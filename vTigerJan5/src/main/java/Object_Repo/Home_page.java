package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	public Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(linkText="Products")
	private WebElement productLinkText;
	
	@FindBy(linkText="More")
	private WebElement moreLinkText;
	
	@FindBy(name="Campaigns")
	private WebElement campaignLinkText;
	
	
    @FindBy(linkText="Organizations")
    private WebElement organisationLinkText;
    
    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement signoutImg;
    
    @FindBy(linkText="Sign Out")
    private WebElement signoutLinkText;
    
    //Getters method
	public WebElement getProductLinkText() {
		return productLinkText;
	}

	public WebElement getMoreLinkText() {
		return moreLinkText;
	}

	public WebElement getCampaignLinkText() {
		return campaignLinkText;
	}

	public WebElement getOrganisationLinkText() {
		return organisationLinkText;
	}

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getSignoutLinkText() {
		return signoutLinkText;
	}


      //Business Logic For product
      public void clickProductLink()
      {
    	  productLinkText.click(); 
      }
      //Business Logic For more
      public void moreLink()
      {
    	  moreLinkText.click();
      }
      
      //Campaign
      public void clickCampaignLinkText()
      {
    	  campaignLinkText.clear(); 
      }
      //organisation
      public void clickOrganisationLinkText()
      {
    	  organisationLinkText.click();
      }
     //signoutImage
      public void clicksignoutImg()
      {
    	  signoutImg.click();
      }

      //signoutlink
      
      public void clickSignoutLink()
      {
    	  signoutLinkText.click(); 
      }





















}




