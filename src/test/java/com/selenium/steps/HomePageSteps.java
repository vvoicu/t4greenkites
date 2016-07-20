package com.selenium.steps;

import com.selenium.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class HomePageSteps {

	HomePage homePage;

	@Step
	public void clickOnSignInButton() {
		homePage.signin();
	}

	@Step
	public void isTheHomePage() {
		homePage.open();
	}
}
