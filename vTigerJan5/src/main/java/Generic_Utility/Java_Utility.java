package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * This method is used for avoiding duplicate Value
	 * @return
	 * @author Nagma
	 */
	
	public int getRandomNum()
	
	{
		Random r=new  Random();
		int ranNum=r.nextInt(1000);
		
		return ranNum;
	}

}
