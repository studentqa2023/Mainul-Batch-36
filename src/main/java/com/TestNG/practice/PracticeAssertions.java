package com.TestNG.practice;


import org.testng.annotations.Test;

import junit.framework.Assert;

public class PracticeAssertions {
	int a = 5;
	int b = 3;
	
	@Test(priority=0)
	public void getSum() {
		System.out.println(a+b);
		Assert.assertEquals(a+b, 10);
		
	}

	@Test(priority=1)
	public void getMultily() {
		System.out.println(a*b);
	}
}
