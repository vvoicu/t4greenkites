package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HeaderNavigationSteps;
import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import tools.Constants;


@RunWith(SerenityRunner.class)
public class HeaderNavigationTest extends BaseTest{

	
	@Steps
	public LoginSteps userSteps;
	
	@Steps
	public HomePageSteps homeSteps;
	
	@Steps
	public HeaderNavigationSteps headerNavigationSteps;

	
	
	@Test
	public void performHeaderNavigation(){
		homeSteps.is_the_home_page();
		homeSteps.starts_searchForSignInButton();
		userSteps.performLogin(Constants.USERNAME, Constants.PASSWORD);
		headerNavigationSteps.selectMenuItem();
	}
}
