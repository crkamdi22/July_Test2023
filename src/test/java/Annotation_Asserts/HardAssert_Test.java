package Annotation_Asserts;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssert_Test {
	
	WebDriver w;
	
  @BeforeTest
  public void preCondition() {
	  
	  w = new ChromeDriver();
  }
	 
	 
  @Test(priority = 0, description = "Test case to verify Admin login functionality", groups = "LoginModule")
  public void adminLogin() throws Exception {
	  
	  w.get("http://testfire.net/login.jsp");
	  
	  String loginPageTitle = w.getTitle();  //return current page title
	  String loginPageURL = w.getCurrentUrl();  //return current page URL
	  String loginPageLable = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
 
      Assert.assertEquals(loginPageTitle, "Altoro Mutual");
      Assert.assertEquals(loginPageURL,"http://testfire.net/login.jsp" );
      Assert.assertTrue(loginPageLable.contains("Login"), "Login page Lable is different from expected");
  
      
      w.findElement(By.id("uid")).sendKeys("admin"); 

	  w.findElement(By.name("passw")).sendKeys("admin");
		
	  w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
  
  }
 
  @Test(priority = 1, description = "Test case to verify Admin logout functionality", groups = "LoginModule" ,dependsOnMethods ="adminLogin")
  public void adminLogout() throws Exception {
	  
	  Thread.sleep(1000);
	  
	  String homePageTitle = w.getTitle();
	  String homePageLable = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
  
      Assert.assertEquals(homePageTitle, "Aotoro Mutual");  //test case will fail because we use the name 'Aotoro Mutual' intentionally
      Assert.assertTrue(homePageLable.contains("Admin"),"Home page lable is different");
      
      w.findElement(By.xpath("//*[@id='LoginLink']/font")).click();
  }
  
  @AfterTest
  public void postCondition() {
	  
	  w.close();
  }

}
