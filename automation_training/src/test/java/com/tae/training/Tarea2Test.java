package com.tae.training;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

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
	
	@DataProvider(name = "words")
	   private Object [][] getWords() { 
		return new Object[][]{
			{"Testing","Automation","Engineer"},
			{"One","Two","Three"},
			{"Programming","Object","Oriented"},
			{"Second","Test","Solved"}
		};
	    }
	
	@Test(groups={"Regression","Smoke"}, dataProvider="numbers")
	public void Test1(int a, int b){
		System.out.println("Result mult: "+ a*b);
	}
	
	@Test(groups={"Regression", "Smoke"}, dataProvider="words")
	public void Test2(String s1, String s2, String s3){
		
		System.out.println("Concatenated words: "+s1 + " "+ s2+ " "+s3);
	}
	
	/*@Parameter(names="incomingDate")
	@Test(groups={"Smoke"})
	public void Test3(String incomingDate){
		String day = incomingDate.substring(0, 1);
		String month = incomingDate.substring(3, 4);
		String year = incomingDate.substring(6, 10);
		System.out.println("Date in format YYYY/MM/DD: "+year+"/"+month+"/"+day);
		System.out.println("IncomingDate: "+incomingDate);
	}*/

}
