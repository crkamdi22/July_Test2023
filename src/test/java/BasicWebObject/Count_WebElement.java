package BasicWebObject;

import org.testng.annotations.Test;
 
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Count_WebElement {
	
	WebDriver w;
	
  @BeforeTest
  public void beforeTest() {
	  
	  w= new ChromeDriver();
	  w.manage().window().maximize();
  }
  
  
  @Test(priority = 0, description = "Count Links")
  public void CountWebElements() throws Exception {
	  
	  w.get("https://demo.automationtesting.in/Register.html");
	  
	  List<WebElement> links = w.findElements(By.tagName("a"));

		System.out.println("Number of links : " + links.size());
		
  }
  
  
  @Test(priority = 1, description = "Count radioButton")
	public void countradioButton() {

		List<WebElement> radiooptions = w.findElements(By.name("radiooptions"));

		System.out.println("Number of radiooptions : " + radiooptions.size());

  }
  
  
  @Test(priority = 2,description = "Count checkBox")
	public void countcheckBox() {
		
	 List <WebElement>checkBox=w.findElements(By.cssSelector("input[type='checkbox']"));
	 System.out.println("Number of checkBox : "+checkBox.size());
	 
  }
  
  
  @Test(priority = 3, description = "Count DropDown")
	public void countDropDown() {

		List<WebElement> DropDown = w.findElements(By.tagName("select"));

		System.out.println("Number of DropDown : " + DropDown.size());

  }
  
  @AfterTest
  public void afterTest() {
	  
	  
	  
  }

}
