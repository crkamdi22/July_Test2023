package Practice_Automation;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class IFB_Login_SoftAssert {
	
	WebDriver w;
	
	SoftAssert sft;
	
   @BeforeTest
   public void preCondition() {
	   
	   w = new ChromeDriver();     
   }
	 

  @Test(priority = 0, description = " Verify the test case for customer login")
  public void loginMRS () {
	  
	  sft= new SoftAssert();
	  
	  w.get("https://www.ifbappliances.com/customer/account/login");
	   
	  String loginPageTitle = w.getTitle();
	  String loginPageURL = w.getCurrentUrl();
	  String loginHomeLable = w.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
	  
	  sft.assertEquals(loginPageTitle , "IFB");
	  sft.assertEquals(loginPageURL , "https://www.ifbappliances.com/customer/account/login");
      sft.assertEquals(loginHomeLable.contains("Login"),"Login page is different from as expected");
 
      w.findElement(By.id("email")).sendKeys("rakesh_lanjewar@rediffmail.com");
      
      w.findElement(By.id("pass")).sendKeys("Waman1001#");
      
      w.findElement(By.id("send2")).click();
      
      sft.assertAll();
  }
 

  @AfterTest
  public void postCondition() {
	  
	  w.close();
  }

}
