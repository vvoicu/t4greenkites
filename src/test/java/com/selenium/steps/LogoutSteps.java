package com.selenium.steps;

import com.selenium.pages.LogoutPage;

import net.thucydides.core.annotations.Step;

public class LogoutSteps {

	public LogoutPage logout;

	@Step
	public void clickOnUserIdentifier(String userOption) {
		logout.clickOnUserIdentifier(userOption);
	}
}
