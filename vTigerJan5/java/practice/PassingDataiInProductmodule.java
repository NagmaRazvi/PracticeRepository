package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PassingDataiInProductmodule {

	public static void main(String[] args) throws IOException {
WebDriver driver=new ChromeDriver();
		
		FileInputStream fis= new FileInputStream("./src/test/resources/commonData.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("url1");
		String USERNAME= pro.getProperty("username1");
		String PASSWORD= pro.getProperty("password1");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		FileInputStream efis=new FileInputStream(".//src/test/resources/WorkBook1.xlsx");
		Workbook book=WorkbookFactory.create(efis);
	
		Sheet sh=book.getSheet("Sheet");
		Row row=sh.getRow(0);
		Cell cel=row.getCell(0);
		String orgName=cel.getStringCellValue();
		driver.findElement(By.name("productname")).sendKeys(orgName);
		
	}

}
