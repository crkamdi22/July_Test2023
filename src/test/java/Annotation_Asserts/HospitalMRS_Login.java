package Annotation_Asserts;

import org.testng.annotations.Test; 
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HospitalMRS_Login {
	
	  WebDriver w;
	
   @BeforeTest
   public void preCondition() {
		 
		 w= new ChromeDriver();
		 
	  }
	
  @Test
  public void LoginTestMRS() {
	  
	    w.get(" https://demo.openmrs.org/openmrs/login.htm");
	
		w.findElement (By.cssSelector("input#username")).sendKeys("Admin");

		w.findElement(By.cssSelector("input#password")).sendKeys("Admin123");
		 
		w.findElement(By.cssSelector("li[value='6']")).click();
		
		w.findElement(By.cssSelector("input#loginButton")).click();
	
		w.findElement(By.cssSelector("li.nav-item")).click();
		
  }
 
  @AfterTest
  public void afterTest() {
	  
	  w.close();
  }

}
