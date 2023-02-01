package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	public String getKeyAndvalue(String key) throws Throwable
	{
		
		/**
		 *This method is used to read data from the property file
		 *@param key
		 *@return
		 *@throws Throwable
		 *@author Lenovo 
		 */
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
	}

}
