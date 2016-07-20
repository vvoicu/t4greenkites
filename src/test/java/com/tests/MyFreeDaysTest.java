package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HeaderNavigationSteps;
import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LeftMenuSteps;
import com.selenium.steps.LoginSteps;
import com.selenium.steps.MyFreeDaysSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import tools.Constants;

@RunWith(SerenityRunner.class)
public class MyFreeDaysTest extends BaseTest {

	@Steps
	public LoginSteps userSteps;

	@Steps
	public HomePageSteps homeSteps;

	@Steps
	public HeaderNavigationSteps headerNavigationSteps;

	@Steps
	public LeftMenuSteps leftMenuSteps;

	@Steps
	public MyFreeDaysSteps myFreeDays;
	
	public String textToVerify="My Free Days";

	@Test
	public void verifyTheUserFreeDays() {
		homeSteps.isTheHomePage();
		homeSteps.clickOnSignInButton();
		userSteps.performLogin(Constants.USERNAME, Constants.PASSWORD);
		headerNavigationSteps.selectVacationMenuItem();
		leftMenuSteps.clickMyFreeDays();
		myFreeDays.verifyTheUserFreeDays(textToVerify);
	}
}
