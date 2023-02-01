package Campaigns;



import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductTest extends BaseClass{

	@Test
	public void CreateCampaignWithProductTest()   throws Throwable {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver_win32//chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
        driver.manage().window().maximize();
  
		
		
		 
		//Fetching Data from WebDriver_Utility
		WebDriver_Utility wlib=new WebDriver_Utility();
		  wlib.maximizeScreen(driver);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  // wlib.waitForPageToLoad(driver);
		
		//FileInputStream fis= new FileInputStream("./src/test/resources/commonData.properties.txt");
		//Properties pro=new Properties();
		//pro.load(fis);
        //String URL = pro.getProperty("url1");
		//String USERNAME= pro.getProperty("username1");
		//String PASSWORD= pro.getProperty("password1");

        //fetching data from File_Utility
		//File_Utility fib=new File_Utility();
		//String URL = fib.getKeyAndvalue("url1");
		//String USERNAME = fib.getKeyAndvalue("username1");
		//String PASSWORD = fib.getKeyAndvalue("password1");
		
		//driver.get(URL);
		
    // 	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    //driver.findElement(By.id("submitButton")).click();
		
		//Fetching data from loginPage(POM) class
		//Login_Page login=new Login_Page(driver);
		//login.loginToApp(USERNAME, PASSWORD);
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		//To avoid duplicates
		//Random ran=new Random();
		//int ranNum=ran.nextInt(1000);
		
		 //Calling Metod java_Utility
	       Java_Utility jib=new Java_Utility();
	      int ranNum=jib.getRandomNum();
		
		//fetching data from Excel sheet
	    //FileInputStream efis=new FileInputStream(".//src/test/resources/WorkBook1.xlsx");
	    //Workbook book=WorkbookFactory.create(efis);
		//Sheet sh=book.getSheet("Sheet");
		//Row row=sh.getRow(0);
		//Cell cel=row.getCell(0);
		//String productName=cel.getStringCellValue()+ranNum;
		
		 //fetching data from Excel_Utility
	      Excel_Utility elib=new Excel_Utility();
	      String productName = elib.getExcelData("Sheet", 0, 1)+ranNum;
		driver.findElement(By.name("productname")).sendKeys(productName);
		
		//to save the data
		driver.findElement(By.name("button")).click();
		
		//Campaign Module
		driver.findElement(By.linkText("More")).click();
		
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		//FileInputStream efis1=new FileInputStream(".//src/test/resources/CampaignDataSheet.xlsx");
		//Workbook book1=WorkbookFactory.create(efis1);

		//Sheet sh1=book1.getSheet("Sheet1");
		//Row row1=sh1.getRow(0);
		//Cell cel1=row1.getCell(0);
		//String campaignName=cel1.getStringCellValue()+ranNum;
		//driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		
		 //fetching data from Excel_Utility
	      Excel_Utility elib1=new Excel_Utility();
	      String campaignName = elib1.getExcelData("Sheet", 0, 2)+ranNum;
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);

		// to click plus sign in campaign module
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		
		// window switching
		//Set<String> allId = driver.getWindowHandles(); //1,2,3 windows are open so browser get confused
		//Iterator<String> it = allId.iterator(); //stores add of all win
        // while(it.hasNext())   //any window is present or not if present it give
        // {
        //	 String wid = it.next();
        //	 
        //	 driver.switchTo().window(wid);
        //	String title = driver.getTitle();
        //	if(title.contains("Products&action"))
        //	{
        //		break;
        //	}
        //	}
        
		wlib.switchToWindow(driver, "Products&action");
		
        driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
        
        //window switch back
  //      Set<String> allId1= driver.getWindowHandles();//1,2,3 windows are open so browser get confused
  //   	Iterator<String> it1 = allId1.iterator();//stores add of all win
    //     while(it1.hasNext())//any window is present or not if present it give
      //   {
        //	 String wid = it1.next();
        	 
      //  	 driver.switchTo().window(wid);
        //	String title = driver.getTitle();
        	//if(title.contains("Products&action"))
       // 	{
        //		break;
        	//}
      //  	}
        wlib.switchToWindow(driver, "Products&action");
        
        
        
      
       //to save the data
 		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 		//to signout
 				Thread.sleep(1000);
 				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
 				driver.findElement(By.linkText("Sign Out")).click();
 		
       
	}
	
	}


