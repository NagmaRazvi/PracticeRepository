package TestNG;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {
	
	@Test(dataProvider="dataprovider_test")
	public void OrganisationDetails(String name,String phnum,String email) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(" http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.name("account_name")).sendKeys(phnum);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.name("button")).click();
		driver.quit();
	}
	@DataProvider
	public Object[][] dataprovider_test()
	{
		Object[][] objArr=new Object[3][3];
		
		objArr[0][0]="Aaa";
		objArr[0][1]="123456";
		objArr[0][2]="abc@gmail.com";
		
		objArr[1][0]="Bbb";
		objArr[1][1]="4567899";
		objArr[1][2]="efg@gmail.com";
		
		objArr[2][0]="Ccc";
		objArr[2][1]="123456789";
		objArr[2][2]="def@gmail.com";
		return objArr;
		
	}
	
	

}
