package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmptyBrowser {

	public static void main(String[] args) throws Throwable {
	
  WebDriver driver=new ChromeDriver();
  
  FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties.txt");
  Properties pro=new Properties();
  pro.load(fis);
  
  String URL = pro.getProperty("url");
  String USERNAME = pro.getProperty("username");
  String PASSWORD = pro.getProperty("password");
  
  driver.get(URL);
  driver.findElement(By.id("username")).sendKeys(USERNAME);
  driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
  driver.findElement(By.id("loginButton")).click();
  
  
  
	}

}
