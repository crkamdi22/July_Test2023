package Annotation_Asserts;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class AllAnnotationCode {
	
  @Test
  public void Test1() {
	  
	  System.out.println("--------.........---------Test_1");
  }
  @Test
  public void Test2() {
	  
	  System.out.println("---------........---------Test_2");
  }

  @Test
  public void Test3() {
	  
	  System.out.println("----------........---------Test_3");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println(".........BeforeMethod");
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println(".........AfterMethod");
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println(".........BeforeClass");
	  
  }
  
  @AfterClass
  public void afterClass() {
	  
	  System.out.println(".........AfterClass");
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println(".........Beforetest");
	  
  }
  
  @AfterTest
  public void afterTest() {
	  
	  System.out.println(".........afterTest");
  }
  
  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println(".........BeforeSuite");
	  
  }
  
  @AfterSuite
  public void afterSuite() {
	  
	  System.out.println(".........AfterSuite");
  }
  }
  
  


