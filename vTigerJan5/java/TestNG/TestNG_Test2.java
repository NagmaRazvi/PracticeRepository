package TestNG;

import org.testng.annotations.Test;

public class TestNG_Test2 {

	@Test(priority=1)
	public void create()
	{
		System.out.println("Created");
	}
	
	@Test(priority=2)
	public void delete()
	{
		System.out.println("deleted ");
	}
	@Test(priority=3)
	public void modify()
	{
		System.out.println("modified ");
	}
}
