
package com.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;

public class BaseTestFile {

	private Properties prop = new Properties();
	private FileInputStream input;

	protected String userName, password;

	@Before
	public void dataSetup() throws IOException {
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);

		userName = prop.getProperty("userName");
		password = prop.getProperty("password");

	}		

	@After
	public void dataWrite() throws IOException {
		Properties prop = new Properties();
		FileOutputStream output = null;
		output=new FileOutputStream("src/test/resources/config1.properties");
		 prop.setProperty("userName", "userName");
		 prop.setProperty("userPassword", "password");
		

		  prop.store(output, "OutputFile, sau orice aici !!");
		}	
}