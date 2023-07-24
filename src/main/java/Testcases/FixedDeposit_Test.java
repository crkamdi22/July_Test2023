package Testcases;

import org.testng.annotations.Test;

import PageObject.FixedDeposit_pageObject;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class FixedDeposit_Test {
	FixedDeposit_pageObject fd = new FixedDeposit_pageObject();

	DataFormatter df;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;
	XSSFCell principle, roi, tenure, frequency;

	@BeforeTest
	public void preCondition() throws Exception {

		String br = fd.readDataFromConfigFile("browser");
		fd.openBrowser(br);
		fd.exportPageObject();

		df = new DataFormatter();
		fi = new FileInputStream(".\\TestData\\FDCal.xlsx");
		wb = new XSSFWorkbook(fi);
		sht = wb.getSheetAt(0);

	}

	@Test
	public void fixedDepositTest() throws Exception {

		String url = fd.readDataFromConfigFile("domainURL");

		fd.openApplicationUrl(
				url + "fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		fd.handleRandomObject(fd.cancelBtn);

		fd.waitForSecond(2);

		fd.scrollPageUp();
		
		
		int rowCount=sht.getLastRowNum();	 
		
		for(int i=1;i<=rowCount;i++) {
		
			//i -> representing rows
			row=sht.getRow(i);
			
					
			principle=row.getCell(0);
			roi=row.getCell(1);
			tenure=row.getCell(2);
			frequency=row.getCell(3);
			

		fd.handleInputEvent(fd.principalTextBox, df.formatCellValue(principle));

		fd.handleInputEvent(fd.interestTextBox, df.formatCellValue(roi));

		fd.handleInputEvent(fd.tenureTextBox, df.formatCellValue(tenure));

		fd.handleDropDown(fd.tenurePeriodDropDown, "year(s)");

		fd.handleDropDown(fd.frequencyDropDown, df.formatCellValue(frequency));

		fd.handleClickEvent(fd.calculateBtn);

		fd.waitForSecond(2);

		String maturityValue = fd.Maturity_Value.getText();
		System.out.println("For Principle Amount : "+principle+" | Maturity Value : " + maturityValue);

		fd.waitForSecond(2);
		
		
		}
		

	}

	@AfterTest
	public void postCondition() {

		fd.closeBrowser();
	}

}



