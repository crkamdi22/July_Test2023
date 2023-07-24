package Annotation_Asserts;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AltoroMutual_Login {
	
	 WebDriver w;
	
	 @BeforeTest
	 public void preCondition() {
		  
		  w= new ChromeDriver();
	  }
	
	
  @Test(priority = 0, description = "Test case to verify Admin login functionality")
  public void adminLogin() throws Exception {
		
			w.get("http://altoromutual.com:8080/login.jsp ");
			
			w.findElement(By.id("uid")).sendKeys("admin");

			w.findElement(By.name("passw")).sendKeys("admin");
			
			w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
				
			w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font ")).click();
			
  }
			
	 @Test(priority = 1, description = "Test case to verify jSmith login functionality")
	 public void jsmithLogin() throws Exception {
				 
				 
			 w.get("http://altoromutual.com:8080/login.jsp ");
					
			 w.findElement(By.id("uid")).sendKeys("jsmith");

			 w.findElement(By.name("passw")).sendKeys("Demo1234");
					
			 w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
						
			 w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font ")).click();  //logout
			 
  }
					
					
	  @Test(priority = 2, description = "Test case to verify TestUser login functionality")
	  public void TestUserLogin() throws Exception {
					
			 w.get("http://altoromutual.com:8080/login.jsp ");
							
			 w.findElement(By.id("uid")).sendKeys("tuser");

			 w.findElement(By.name("passw")).sendKeys("tuser");
							
			 w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
								
			 w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font ")).click();
									
  }
 
  @AfterTest
  public void postCondition() {
	  
	  w.close();
  }

}
