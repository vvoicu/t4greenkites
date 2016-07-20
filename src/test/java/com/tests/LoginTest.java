package com.tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import tools.FileOutputStreamTopMenuItem;

@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {

	@Steps
	public LoginSteps userSteps;

	@Steps
	public HomePageSteps homeSteps;
	
	public FileOutputStreamTopMenuItem topMenuItem;

	@Test
	public void loginSimpleUser() {
		homeSteps.isTheHomePage();
		homeSteps.clickOnSignInButton();
		userSteps.performLogin(userName, password);
		userSteps.verifyIfUserIsLoggedIn("VACATION");
	}
	
	@After
	public void writeMenuItem() throws IOException{
		topMenuItem.writeMenuItem();
	}
}
