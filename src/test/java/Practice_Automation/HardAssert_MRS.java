package Practice_Automation;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssert_MRS {
	
	WebDriver w;
		
  @BeforeTest
  public void preCondition() {
	  
	  w = new ChromeDriver();
  }
  
	
  @Test(priority = 0, description = "Verify Admin Login Page functionally" , groups= "loginModule")
  public void adminlogin () throws Exception {
	  
	  w.get("https://demo.openmrs.org/openmrs/login.htm");
	  
	  String loginPageTitle= w.getTitle();
	  String loginPageURL = w.getCurrentUrl();
	  String loginPageLable= w.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/header/div/a/img")).getText();
	  
	  
	  Assert.assertEquals(loginPageTitle, "Login");
	  Assert.assertEquals(loginPageURL, "https://demo.openmrs.org/openmrs/login.htm");
	  Assert.assertTrue(loginPageLable.contains("OpenMRS"), "Login Page lable is different from as expected");
	  
	  
	  w.findElement(By.id("username")).sendKeys("Admin");
	  w.findElement(By.id("password")).sendKeys("Admin123");
	  w.findElement(By.xpath("//*[@id=\"Inpatient Ward\"]")).click();
	  w.findElement(By.id("loginButton")).click();
	     
  }
  
  @AfterTest
  public void postCondition() {
	  
	  w.close();
  }

}
