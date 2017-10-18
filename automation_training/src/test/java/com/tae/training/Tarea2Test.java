package com.tae.training;

<<<<<<< HEAD
public class Tarea2Test {
	
	System.out.println("Algo");
=======
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
>>>>>>> 54bc52798f17a3ee864dabb25c49381af6e9b7a6

public class Tarea2Test {
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("Before Suite");
	}
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test");
	}
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class");
	}
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before Method");
	}
	@BeforeGroups
	public void beforeGroups(){
		System.out.println("Before Groups");
	}
	@AfterGroups
	public void afterGroups(){
		System.out.println("After Groups");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Method");
	}
	@AfterClass
	public void afterClass(){
		System.out.println("After Class");
	}
	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}
	@AfterSuite
	public void afterSuite(){
		System.out.println("After Suite");
	}
	
	@DataProvider(name="numbers")
	public Object[][] getNumbers(){
		return new Object[][] {
			{new Integer(4), new Integer(7)},
			{new Integer(6), new Integer(25)},
			{new Integer(12), new Integer(8)}
			};
		}
	
	@SuppressWarnings("rawtypes")
	@DataProvider(name = "words")
	   private Object [][] getWords(ArrayList[][] array) { 
	       /*return new Object[][]{
	    	{"s1", "Testing"},
	       	{"s2", "Automation"},
	       	{"s3", "Engineer"}
	       	}; */
		Object[][] getWords = new Object[1][3];
		getWords[0][0] = "Testing";
		getWords[0][1] = "Automation";
		getWords[0][2] = "Engineer";
		getWords[0][3] = "Rocks";
		return getWords;
	    }
	
	@Test(groups={"Regression","Smoke"}, dataProvider="numbers")
	public void Test1(int a, int b){
		System.out.println("Result mult: "+ a*b);
	}
	
	@Test(groups={"Regression", "Smoke"}, dataProvider="words")
	public void Test2(ArrayList<String>array[][]){
		
		System.out.println("Concatenated words: "+array[0][0]+" "+array[0][1]+" "+array[0][2]);
	}
}
