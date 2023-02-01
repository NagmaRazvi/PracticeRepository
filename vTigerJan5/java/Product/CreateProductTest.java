package Product;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

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
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass{

	@Test(groups={"smoke","regression"})
	public void  CreateProduct()  throws Throwable {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver_win32//chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
      
		
		driver.manage().window().maximize();
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

	//	driver.get(URL);
		
	    		  
	//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		//driver.findElement(By.id("submitButton")).click();
		
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
		
		//to signout
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
