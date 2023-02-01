package TestNG;

import org.testng.annotations.Test;

public class TestNG_Test5 {
	
	@Test(invocationCount=2)
	public void create()
	{
		System.out.println("Created");
	}
	
	@Test(invocationCount=2)
	public void delete()
	{
		System.out.println("deleted ");
	}
	@Test
	public void modify()
	{
		System.out.println("modified ");
	}

}
