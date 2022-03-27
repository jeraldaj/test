package keywords;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class ApplicationKeywords extends ValidationKeywords{
	
	
   public ApplicationKeywords() {
	
	   String path = System.getProperty("user.dir")+"//src//test//resources//project.properties";
        props = new Properties();
        try {
        	FileInputStream fis = new FileInputStream(path);
        	props.load(fis);
        } catch(Exception e) {
        	e.printStackTrace();
        }
	
   }

  public void login() {
		
	}
  
  public void selectDateFromCalendar() {
		
	}
  
  public void verifyStockAdded() {
		
	}
  
	
}
