package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class LoginTestCase {

	public static void main(String[] args) throws Exception{
		
		
		
	//WebDriverManager.chromedriver().setup();
		
		WebDriver w = new ChromeDriver();  //means open blank browser

		
		//step 1: open application with url
		
		w.get("http://altoromutual.com:8080/login.jsp ");
		
		//step 2: Enter Username
		
		w.findElement(By.id("uid")).sendKeys("admin");
		
		//step3: Enter password
		
		w.findElement(By.name("passw")).sendKeys("admin");
		
		//step 4: Click Login
		
		w.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
			
		//step 5: Click Logout
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font ")).click();
		
		//step 6: close
		
		w.close();
		
		System.out.println("Admin login Successfully");
	}

}
