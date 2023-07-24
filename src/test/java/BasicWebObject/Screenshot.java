package BasicWebObject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Screenshot {
	 
   WebDriver w;
	
   @BeforeTest
   public void beforeTest() {
	   
	   w= new ChromeDriver();
	   w.manage().window().minimize();
   }
	  
  @Test
  public void Code_For_Screenshot() throws Exception {
	  
	  w.get("https://www.selenium.dev/");
	  
        //	1. Press printscreen
		//	2. paint / doc paste
		//	3. save c:/ d :/ e :/
			
			
	  
	  Thread.sleep(1000);
	  
	  TakesScreenshot ts= (TakesScreenshot)w;
	  File f= ts.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(f, new File (".\\ScrenShot\\SeleniumPage.png"));
	  //meaning of .double slash is Project Path - > .\\ 
	  
	  /* 
	   * For FileUtils add dependencies in pom.xml.
	   
	  <dependency>
	  
	   <groupId>commons-io</groupId>
	 <artifactId>commons-io</artifactId> 
	 <version>2.6</version>
	 
	    </dependency>
	    
	    */
  }
  
 
  @AfterTest
  public void afterTest() {
	  
	  w.quit();
  }

}
