package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MyPropretyFile extends BaseTestFile {

	@Test
	public void readMyRequestsPropretyTest() {

		System.out.println("password:" + password);
		System.out.println("userName:" + userName);
		
		
	}

}