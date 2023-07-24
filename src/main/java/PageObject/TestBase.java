package PageObject;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBase {
	
	//inside this call all reuse methods are store

	String baseURL= "https://www.moneycontrol.com/personal-finance/tools/education-loan-emi-calculator.html";
	
	 WebDriver w;
	 
	 public void openBrowser(String br) {
		 
		 if(br.equalsIgnoreCase("chrome")) {
			 w= new ChromeDriver();
			 
		 } else if (br.equalsIgnoreCase("firefox")) {
				w = new FirefoxDriver();
			} else if (br.equalsIgnoreCase("edge")) {
				w = new EdgeDriver();
			} else {
				System.out.println("Select browser not installed ");
			}

			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		}

		public void closeBrowser() {

			w.quit();
		}

		public void openApplicationUrl(String HTMLpage) {

			w.get(HTMLpage);
		}

		public void handleInputEvent(WebElement we, String value) {

			we.clear();
			we.sendKeys(value);
		}

		public void handleClickEvent(WebElement we) {

			we.click();
		}

		public void handleDropDown(WebElement we, String value) {

			Select sel = new Select(we);
			sel.selectByVisibleText(value);

		}

		public void waitForSecond(int sec) {

			try {
				Thread.sleep(sec * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void handleAlert() {

			try {
				w.switchTo().alert().accept();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void handleRandomObject(WebElement we) {

			try {
				we.click();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void scrollPageDown() {
			
			JavascriptExecutor js=(JavascriptExecutor)w;
			js.executeScript("window.scrollBy(0,200)");	

		}

		public void scrollPageUp() {

			JavascriptExecutor js=(JavascriptExecutor)w;
			js.executeScript("window.scrollBy(0,-200)");	
		}
		
		public String readDataFromConfigFile(String Key) throws Exception{
			
			FileInputStream fi = new FileInputStream(".\\TestConfig\\config.properties");

			Properties prop = new Properties();

			prop.load(fi);// properties file -> to open (load) -> at fi path

			String value=prop.getProperty(Key);
			
			fi.close();
			
			return value;
		 }
	 }

