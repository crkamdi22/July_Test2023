package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedDeposit_pageObject extends TestBase {

	

	@FindBy(id = "principal")
	public WebElement principalTextBox;

	@FindBy(id = "interest")
	public WebElement interestTextBox;

	@FindBy(css = "input#tenure")
	public WebElement tenureTextBox;

	@FindBy(id = "frequency")
	public WebElement frequencyDropDown;
	
	@FindBy(name="tenurePeriod")
	public WebElement tenurePeriodDropDown;
	
	@FindBy(xpath = "//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement calculateBtn;

	@FindBy(name = "resp_matval")
	public WebElement Maturity_Value;
	
	@FindBy(id="wzrk-cancel")
	public WebElement cancelBtn;
	
	
	public void exportPageObject() {
		
		PageFactory.initElements(w, this);
		
	}
			
	

}
