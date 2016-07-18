package com.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.junit.After;

import org.junit.Before;
import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Managed;
import tools.Constants;

public class BaseTest {


	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	public String url;
	public String userName;
	public String password;

	@Before
	public void dataSetup() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;

		input = new FileInputStream(Constants.CONFIG_PATH);

		// load a properties file
		prop.load(input);

		url = prop.getProperty("url");
		userName = prop.getProperty("userName");
		password = prop.getProperty("password");

	}

	@After
	public void verifyIfUserIsLoggedIn() throws IOException {
		Properties prop2 = new Properties();
		OutputStream output = null;

		output = new FileOutputStream(getClass().getSimpleName() + ".properties");

		prop2.setProperty("topMenuItemName: ", "Vacation");

		prop2.store(output, null);

	}

}

