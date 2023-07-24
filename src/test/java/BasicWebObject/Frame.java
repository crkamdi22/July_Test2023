package BasicWebObject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Frame {
	
	WebDriver w;
	
  @BeforeTest
  public void beforeTest() {
	  
	  w = new ChromeDriver();
  }
  
  @Test
  public void Frame () throws Exception {
	  
	  w.get("https://demo.automationtesting.in/Frames.html");
		
		
		w.switchTo().frame("singleframe");
		
    w.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Selenium");
	}
	  
  
  @AfterTest
  public void afterTest() {
  }

}
