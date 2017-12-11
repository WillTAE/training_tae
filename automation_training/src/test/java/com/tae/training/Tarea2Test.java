package com.tae.training;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tarea2Test{
	
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
	
	@Test(groups={"Regression","Smoke"}, dataProvider="numbers", dataProviderClass=DataProvidersSource.class)
	public void test1(int a, int b){
		System.out.println("Result mult: "+ a*b);
	}
	
	@Test(groups={"Regression", "Smoke"}, dataProvider="words", dataProviderClass=DataProvidersSource.class)
	public void test2(String s1, String s2, String s3){
		
		System.out.println("Concatenated words: "+s1 + " "+ s2+ " "+s3);
	}
	
	@Parameters({"incomingDate"})
	@Test(groups={"Smoke"})
	public void test3(String incomingDate) throws ParseException{
		final String OLD_FORMAT = "dd/MM/yyyy";
		final String NEW_FORMAT = "yyyy/MM/dd";
		String newDateString;
		
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d = sdf.parse(incomingDate);
		sdf.applyPattern(NEW_FORMAT);
		newDateString = sdf.format(d);
		System.out.println("Date in format YYYY/MM/DD: "+newDateString);
	}
	
	@Parameters({"Envs"})
	@Test(groups={"Smoke"})
	public void test4(String env){
		Random random = new Random();
		int num1 = random.nextInt(20)+1;
		int num2 = random.nextInt(10)+1;
		if(env.equals("AMBIENTE1")){
			System.out.println("Numbers for the operation: "+num1 +" and "+num2);
			System.out.println("Mult = "+ num1*num2);
		}else if(env.equals("AMBIENTE2")){
			System.out.println("Numbers for the operation: "+num1 +" and "+num2);
			System.out.println("Resta = "+ (num1-num2));
		}
	}

}
