package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test_Login {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	public String name = "cornelia.bodea";
	public String password = "test";

	@Steps
	public LoginSteps userSteps;

	@Steps
	public HomePageSteps home;

	@Test
	public void loginSimpleUser() {
		home.is_the_home_page();
		home.starts_searchForSignInButton();
		userSteps.performLogin(name, password);
		userSteps.verifyIfUserIsLoggedIn("VACATION");
	}
}
