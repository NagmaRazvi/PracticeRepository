package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void CreateContact()
	{
	System.out.println("step-1");
	System.out.println("step-2");
	 //HardAssert
	Assert.assertEquals(false, true);
	//                 (acual,expected)
	System.out.println("step3");
	System.out.println("step4");
	}
	
	@Test
	public void ModifyContact()
	{
		System.out.println("step5");
		System.out.println("step6");
	}

}
