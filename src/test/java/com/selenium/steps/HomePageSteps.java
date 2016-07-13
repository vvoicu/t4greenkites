package com.selenium.steps;

import com.selenium.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class HomePageSteps {

	HomePage homePage;

	@Step
	public void starts_searchForSignInButton() {
		homePage.signin();
	}

	@Step
	public void is_the_home_page() {
		homePage.open();
	}
}
