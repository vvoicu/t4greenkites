package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LoginSteps;
import com.selenium.steps.LogoutSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import tools.FileOutputStreamTopMenuItem;

@RunWith(SerenityRunner.class)
public class LogoutTest extends BaseTest {

	@Steps
	public LoginSteps userSteps;

	@Steps
	public HomePageSteps homeSteps;
	
	@Steps
	public LogoutSteps logoutSteps;
	
	public FileOutputStreamTopMenuItem topMenuItem;
	
	public String userOption="Surt";
	
	@Test
	public void logout(){
		homeSteps.isTheHomePage();
		homeSteps.starts_searchForSignInButton();
		userSteps.performLogin(userName, password);
		logoutSteps.clickOnUserIdentifier(userOption);
		

	}
	
}
