package Annotation_Asserts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowser_Test {
 
  WebDriver w;
	
  @Test(priority =0 , description= "Verify Google page is on Chrome browser")
  public void chromeTest() throws Exception {
	  
	  w = new ChromeDriver();
	  w.get("https://www.google.com/");
	  Thread.sleep(2000);
	  w.close();
  }

  
  @Test(priority = 1, description = "Verify Google page is on firefox browser")
  
  public void firefoxTest() throws Exception {
	  
	  w= new FirefoxDriver();
	  w.get("https://www.google.com/");
	  Thread.sleep(2000);
	  w.close();
	  
  }
  
  
  @Test(priority = 2, description = "Verify Google page is on Edge browser")
  public void edgeDriver() throws Exception {
	  
	  w = new EdgeDriver();
	  w.get("https://www.google.com/");
	  Thread.sleep(2000);
	  w.close();
	    
  }
}

