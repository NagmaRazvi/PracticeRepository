package TestNG;

import org.testng.annotations.Test;

public class TestNG_Test3 {
	
	@Test
	public void create()
	{
		System.out.println("created");
	}
	
	@Test(enabled=false)
	public void modify()
	{
		System.out.println("modified");
	}
	@Test
	public void delete()
	{
		System.out.println("deleted");
	}

}
