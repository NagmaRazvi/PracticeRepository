package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;

public class PassingDataInOrganisationModule {

	public static void main(String[] args) throws Throwable {
		
       WebDriver driver=new ChromeDriver();
		
		FileInputStream fis= new FileInputStream("./src/test/resources/commonData.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("url1");
		String USERNAME= pro.getProperty("username1");
		String PASSWORD= pro.getProperty("password1");
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
    driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/btnL3Add.gif')]")).click();
		
		
    Java_Utility jib=new Java_Utility();
    int ranNum=jib.getRandomNum();
    
    Excel_Utility elib=new Excel_Utility();
    String orgName = elib.getExcelData("Sheet", 0, 0)+ranNum;
   // org.OrganizationNameTextField(orgName);
    driver.findElement(By.name("accountname")).sendKeys(orgName);
    
  //to save the data
  		driver.findElement(By.name("button")).click();
   
    
    String actData = driver.findElement(By.xpath("//span[text()='"+orgName+"']")).getText();
    Assert.assertEquals(actData,orgName);
    
    driver.close();
    
		
		
		
	}

}
