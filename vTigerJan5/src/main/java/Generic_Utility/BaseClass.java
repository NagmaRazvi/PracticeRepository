package Generic_Utility;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;

import Object_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest(groups= {"smoke","regression"})
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	//@org.testng.annotations.Parameters("BROWSER")
	@BeforeClass(groups= {"Smoke","regression"})
	public void BC() throws Throwable
	{
		System.out.println("opening the browser");
		 File_Utility flib=new File_Utility();
	 String BROWSER=flib.getKeyAndvalue("browser");
	//public void BC(String BROWSER )
	//{
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver(); 
		 }
		 else
		 {
			 driver=new ChromeDriver();
		 }
	}
        
	    @BeforeMethod(groups= {"smoke","regression"})
	    public void BM() throws Throwable
	    {
	    	System.out.println("Login to application");
	    	File_Utility fib=new File_Utility();
			String URL = fib.getKeyAndvalue("url1");
			String USERNAME = fib.getKeyAndvalue("username1");
			String PASSWORD = fib.getKeyAndvalue("password1");
			driver.get(URL);
			
			//Fetching data from login Page Pom class
			Login_Page login=new Login_Page(driver);
			login.loginToApp(USERNAME, PASSWORD);
	    }
	    
	    @AfterMethod
	    public void AM()
	    	{
	    	System.out.println("logout the application");	
	    	}
	    	
	    @AfterClass
	    public void AC()
	    {
	    	System.out.println("close browser");
	    }
	    
	   @AfterTest
	   public void AT()
	    {
	    	System.out.println("Execution done");
	    }
	   
	   @AfterSuite
	   public void AS()
	   {
		   System.out.println("DataBase closed");
	   }
	    	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
