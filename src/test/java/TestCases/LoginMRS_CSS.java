package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginMRS_CSS {

	public static void main(String[] args) throws Exception{
		
		WebDriver w= new ChromeDriver();
		
		// Step 1: Open browser
		
		w.get(" https://demo.openmrs.org/openmrs/login.htm");

		//step 2: Enter UserName
		
		w.findElement (By.cssSelector("input#username")).sendKeys("Admin");

		//Step 3:Enter Password
		
		w.findElement(By.cssSelector("input#password")).sendKeys("Admin123");
		 
		Thread.sleep(2000);
		 
		//Step 4: Select location
		
		w.findElement(By.cssSelector("li[value='6']")).click();
		
		//Step 5: Login
		
		w.findElement(By.cssSelector("input#loginButton")).click();
		
		Thread.sleep(2000);
		
		//Step 6: Logout
		
		w.findElement(By.cssSelector("li.nav-item")).click();
		
		//Step 7: Close
		
		w.close();
		
		System.out.println("Login Successfully");
	}

}
