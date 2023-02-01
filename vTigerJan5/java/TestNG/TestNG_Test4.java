package TestNG;

import org.testng.annotations.Test;

public class TestNG_Test4 {

	@Test
	public void create()
	{
	 int[] arr= {1,2,3};
	 System.out.println(arr[5]);
	}
	
	@Test(dependsOnMethods="create")
	public void delete()
	{
		System.out.println("deleted ");
	}
	@Test(dependsOnMethods="create")
	public void modify()
	{
		System.out.println("modified ");
	}

}
