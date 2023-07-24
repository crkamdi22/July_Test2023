package BasicWebObject;

import org.testng.annotations.Test
;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WindowSize {
	
	WebDriver w;
	
  @BeforeTest
  public void beforeTest() {
	  
	  w = new ChromeDriver();
	  
  }
	
	
  @Test
  public void WindowSize() throws Exception {
	  

		w.get("https://www.google.co.in/");
		Thread.sleep(1000);
		
		w.manage().window().maximize();
		
		Thread.sleep(1000);
		
		//Set Window Size  (Parameter - > width , height)
		
		Dimension d=new Dimension(1600, 600);
		
		w.manage().window().setSize(d);
		
		
		
		
		
		//Dimension d=new Dimension(1600, 1200);
    //  w.manage().window().setSize(d);	
		
		
			
	  
	  
  }
  

  @AfterTest
  public void afterTest() {
  }

}
