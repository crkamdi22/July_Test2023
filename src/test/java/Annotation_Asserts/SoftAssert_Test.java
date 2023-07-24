package Annotation_Asserts;

import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SoftAssert_Test {
	
	WebDriver w;
	
	SoftAssert sft;
	
   @BeforeTest
   public void preCondition() {
	   
	   w = new ChromeDriver();
   }
	 
	 
  @Test(priority=0, description= "Test case to verify Admin Login functionally", groups= "LoginModule")
  public void adminLogin() throws Exception {
	  
	  sft = new SoftAssert();
	  
	  w.get("http://testfire.net/login.jsp");
	  
	  
	  String loginPageTitle = w.getTitle();  //return current page title
	  String loginPageURL = w.getCurrentUrl();  //return current page URL
	  String loginPageLable = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
 
      sft.assertEquals(loginPageTitle, "Altoro Mutual");
      sft.assertEquals(loginPageURL,"http://testfire.net/login.jsp" );
      sft.assertTrue(loginPageLable.contains("Login"), "Login page Lable is different from expected");
  
      w.findElement(By.id("uid")).sendKeys("admin");

	  w.findElement(By.name("passw")).sendKeys("admin");
		
	  w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
  
	  sft.assertAll();
  }
  
	  
  @Test(priority=1, description= "Test case to verify Admin Logout functionally", groups= "LoginModule" , dependsOnMethods= "adminLogin")
  public void adminLogout() throws Exception {
	  
	  sft= new SoftAssert();
	  
	  String homePageTitle = w.getTitle();
	  String homePageLable = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
  
      sft.assertEquals(homePageTitle, "Aotoro Mutual");  //test case will fail because we use the name 'Aotoro Mutual' intentionally
      sft.assertTrue(homePageLable.contains("Admin"),"Home page lable is different");
      
      w.findElement(By.xpath("//*[@id='LoginLink']/font")).click();
      sft.assertAll();
  
  }
  
  
  @AfterTest
  public void postCondition() {
	  
	  w.close();
  }

}
