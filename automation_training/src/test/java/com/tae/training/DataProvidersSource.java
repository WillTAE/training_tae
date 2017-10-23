package com.tae.training;


import org.testng.annotations.DataProvider;

public class DataProvidersSource {
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
}
