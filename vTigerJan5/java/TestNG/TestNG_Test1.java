package TestNG;

import org.testng.annotations.Test;

public class TestNG_Test1 {
	
	@Test
	public void create()
	{
		System.out.println("m1 is running");
	}
	
	@Test
	public void delete()
	{
		System.out.println("m2 is running ");
	}
	@Test
	public void modify()
	{
		System.out.println("m3 is running ");
	}

}
