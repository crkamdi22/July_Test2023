package BasicWebObject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Basic_Web_ObjectTest {
	
	WebDriver w;
	
  @BeforeTest
  public void beforeTest() {
	  
	  w= new ChromeDriver();
	  w.get("https://demo.automationtesting.in/Register.html");
 }
	  
  @Test(priority = 0, description ="Handle textbox field" )
  public void textboxTest() {
	  
	  w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Steve");
	  
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
	  w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Jones");
	  
	  String pageLabel=w.findElement(By.xpath("//*[@id=\"section\"]/div/h2")).getText();
  	  Assert.assertEquals(pageLabel, "Register");
  	  
  	  String username=w.findElement(By.cssSelector("input[ng-model='FirstName']")).getAttribute("value");
  	  Assert.assertEquals(username, "Steve");
  	  
  }
  
  @Test(priority = 1,description ="Handle textArea field")
  public void textAreaTest() {
	  
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).clear();
	  w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("123 Sample Address");
	  
	 
  }

  @Test(priority = 2,description ="Handle radiobutton and checkbox field")
  public void radiobuttonCheckboxText() throws Exception {
	  
	w.findElement(By.cssSelector("input[value='FeMale']")).click();
	
	w.findElement(By.id("checkbox1")).click();
	
	Thread.sleep(1000);
	
	w.findElement(By.id("checkbox3")).click();
	  
	 
  }
  

  @Test(priority = 3,description ="Handle drop-down field")
  public void dropDownText() throws Exception {
	  
	  WebElement skillsDropDown=w.findElement(By.id("Skills")); 
	 
	  
	  Select sel=new Select(skillsDropDown);
	  
	 // sel.selectByIndex(2);
	  
	 // sel.selectByValue("Configuration");
	  
	  sel.selectByVisibleText("Java");
	  
	  
	  WebElement monthDropDown=w.findElement(By.cssSelector("select[ng-model='monthbox']"));
	  Select sel_month=new Select(monthDropDown);	  
	  sel_month.selectByVisibleText("July");
	  
	  System.out.println("\n");
	  
	 List <WebElement> valuefromDropDown=sel_month.getOptions();
	 
	 int elementsPresent=valuefromDropDown.size();
	 
	 for(int i=1;i<elementsPresent;i++) {
		 
		System.out.println(valuefromDropDown.get(i).getText());
		 
	 }
	  
	  
  }
 
  @AfterTest
  public void afterTest() {
  }

}
