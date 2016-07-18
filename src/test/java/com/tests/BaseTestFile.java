
package com.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;

public class BaseTestFile {

	private Properties prop = new Properties();
	private FileInputStream input;

	protected String userName, userPassword, endDate, daysNumber, type, lastUpdatedBy, pending;

	@Before
	public void dataSetup() throws IOException {
		input = new FileInputStream("src/test/resources/config.properties");
		prop.load(input);

		userName = prop.getProperty("userName");
		userPassword = prop.getProperty("userPassword");

	}
}
