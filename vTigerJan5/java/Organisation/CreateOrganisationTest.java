package Organisation;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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

import com.beust.jcommander.Parameters;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Object_Repo.Home_page;
import Object_Repo.Login_Page;
import Object_Repo.OrganizationCreatePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest extends BaseClass{
	
	@Test(groups="smoke")
      
	public void CreateOrganisation() throws Throwable {
		
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver_win32//chromedriver.exe");
		// WebDriver driver=new ChromeDriver();
		 
	//	 File_Utility flib=new File_Utility();
	//	 String BROWSER=flib.getKeyAndvalue("browser");
    //		 WebDriver driver ;
		  
	//	 if(BROWSER.equalsIgnoreCase("chrome"))
	//	 {
	//		 WebDriverManager.chromedriver().setup();
	//		 driver=new ChromeDriver();
	//	 }
	//	 else if(BROWSER.equalsIgnoreCase("firefox"))
	//	 {
	//		 WebDriverManager.firefoxdriver().setup();
	//		 driver=new FirefoxDriver();
	//	 }
	//	 else if(BROWSER.equalsIgnoreCase("edge"))
	//	 {
	//		 WebDriverManager.edgedriver().setup();
	//		 driver=new EdgeDriver(); 
	//	 }
	//	 else
	//	 {
	//		 driver=new ChromeDriver();
	//	 }
		 
		 
			driver.manage().window().maximize();
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//FileInputStream fis= new FileInputStream("./src/test/resources/commonData.properties.txt");
			//Properties pro=new Properties();
			//pro.load(fis);
			
			//String URL = pro.getProperty("url1");
			//String USERNAME= pro.getProperty("username1");
			//String PASSWORD= pro.getProperty("password1");
			
			//fetching data from File_Utility
		//	File_Utility fib=new File_Utility();
		//	String URL = fib.getKeyAndvalue("url1");
		//	String USERNAME = fib.getKeyAndvalue("username1");
		//	String PASSWORD = fib.getKeyAndvalue("password1");
		//	
		//	driver.get(URL);
			//Fetching data from login Page Pom class
		//	Login_Page login=new Login_Page(driver);
		//	login.loginToApp(USERNAME, PASSWORD);
			
			//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			//driver.findElement(By.id("submitButton")).click();
			
		//Fetching data from homepage
			//Home_page hp=new Home_page(driver);
			//hp.getOrganisationLinkText();
		driver.findElement(By.linkText("Organizations")).click();
		
		OrganizationCreatePage org=new OrganizationCreatePage(driver);
		org.ClickOrganizationCreateImage();
		
	   // driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/btnL3Add.gif')]")).click();
			
	        //To avoid duplicates
	  		//Random ran=new Random();
	  		//int ranNum=ran.nextInt(1000);
	    
	  //Calling Metod java_Utility
	    Java_Utility jib=new Java_Utility();
	     int ranNum=jib.getRandomNum();
	  		
		//fetching data from excel sheet
		//	FileInputStream efis=new FileInputStream(".//src/test/resources/OrganisationModuleData.xlsx");
		//   Workbook book=WorkbookFactory.create(efis);
		//	Sheet sh=book.getSheet("Sheet1");
		//	Row row=sh.getRow(0);
		//	Cell cel=row.getCell(0);
		//	String orgName=cel.getStringCellValue()+ranNum;
	      
	     //fetching data from Excel_Utility
	      Excel_Utility elib=new Excel_Utility();
	      String orgName = elib.getExcelData("Sheet", 0, 0)+ranNum;
	      
	        org.OrganizationNameTextField(orgName);
			//driver.findElement(By.name("accountname")).sendKeys(orgName);
			
			org.SaveButton();
			//to save the data
			//driver.findElement(By.name("button")).click();
			
			//String actData= driver.findElement(By.id("mouseArea_Organization Name")).getText();
			//if(actData.contains(orgName))
			//{
				//System.out.println("Validation pass");
			//}
			//else
			//{
				//System.out.println("validation fail");
			//}
			
			//to signout
			Thread.sleep(1000);
		
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			
		
	}
	
//	@Test
//	public void m1()
//	{
//		System.out.println("m1 is running");
//	}

}
