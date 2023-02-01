package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateContactWithOrganisatin {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties.txt");
        Properties pro=new Properties();
        pro.load(fis);
        
        String URL = pro.getProperty("url1");
        String USERNAME = pro.getProperty("username");
        String PASSWORD = pro.getProperty("password1");
        
        driver.get(URL);
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//To avoid duplicates
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		
		//Fetching data from Excel sheet
		FileInputStream efis=new FileInputStream(".//src/test/resources/ContactData.xlsx");
		Workbook book=WorkbookFactory.create(efis);

		Sheet sh=book.getSheet("Sheet1");
		Row row=sh.getRow(0);
		Cell cel=row.getCell(0);
		String LastName=cel.getStringCellValue()+ranNum;
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		// window switching
		Set<String> allId = driver.getWindowHandles(); //1,2,3 windows are open so browser get confused
		Iterator<String> it = allId.iterator(); //stores add of all win
         while(it.hasNext())   //any window is present or not if present it give
         {
        	 String wid = it.next();
        	 
        	 driver.switchTo().window(wid);
        	String title = driver.getTitle();
        	if(title.contains("Accounts&action"))
        	{
        		break;
        	}
        	}
         driver.findElement(By.id("1")).click();
         
         //window switch back
         Set<String> allId1= driver.getWindowHandles();//1,2,3 windows are open so browser get confused
 		Iterator<String> it1 = allId1.iterator();//stores add of all win
          while(it1.hasNext())//any window is present or not if present it give
          {
         	 String wid = it1.next();
         	 
         	 driver.switchTo().window(wid);
         	String title = driver.getTitle();
         	if(title.contains("Products&action"))
         	{
         		break;
         	}
         	}
          driver.findElement(By.name("button")).click();
        //to signout
			Thread.sleep(1000);
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();

	}

}
