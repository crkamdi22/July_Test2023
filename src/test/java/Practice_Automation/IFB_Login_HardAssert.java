package Practice_Automation;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class IFB_Login_HardAssert {
	
	WebDriver w;
	
  @BeforeTest
  public void beforeTest() {
	  
	  w = new ChromeDriver();
  }
	
  @Test(priority = 0 , description = " Test case to verity the coustemer login")
  public void IFBlogin() {
	  
	  w.get("https://www.ifbappliances.com/customer/account/login");
	  
	  String loginPageTitle = w.getTitle();
	  String loginPageURL = w.getCurrentUrl();
	  String loginPageLable = w.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
	  //String loginPageLable = w.findElement(By.xpath("//*[@id=\"html-body\"]/div[3]/header/div[2]/a/img")).getText(); 
	  
	  Assert.assertEquals( loginPageTitle, "Customer Login");
	  Assert.assertEquals(loginPageURL, "https://www.ifbappliances.com/customer/account/login");
	  Assert.assertTrue(loginPageLable.contains("Login" ), "Login page lable contain different lable as expected");
	 // Assert.assertTrue(loginPageLable.contains("IFB"), "Login page lable is different as expected");
	  
	  w.findElement(By.id("email")).sendKeys("rakesh_lanjewar@rediffmail.com");
	  w.findElement(By.id("pass")).sendKeys("Waman1001#");
	  w.findElement(By.id("send2")).click();
  }
  

  @AfterTest
  public void afterTest() {
	  
	  w.close();
  }

}
