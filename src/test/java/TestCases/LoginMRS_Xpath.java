package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginMRS_Xpath {

public static void main(String[] args) throws Exception {
		
		
		WebDriver w= new ChromeDriver();
		
		//Step 1: Open Browser
		
		w.get(" https://demo.openmrs.org/openmrs/login.htm ");
		
		//Step 2: Enter Username
		
		w.findElement(By.xpath("//input[@id='username']")).sendKeys("Admin");
		
		//Step 3: Enter Password
		
		w.findElement(By.xpath("//input[@name='password']")).sendKeys("Admin123");
		
		//Step 4: Select Location
		
		w.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
		
		//Step 5: Select Login
		
		w.findElement(By.xpath("//input[@id='loginButton']")).click();
		
		//Step 6: Select Logout
		
		w.findElement(By.cssSelector("li.nav-item")).click();
		
		Thread.sleep(2000);
		
        //Step 7: Close
		
		 w.close();
		 
		 System.out.println(" Login Successfully");
	}

}
