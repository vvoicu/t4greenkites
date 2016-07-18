package com.selenium.steps;

import java.util.List;

import com.selenium.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class LoginSteps {

	LoginPage evoportalLoginPage;

	@Step
	public void enters(String username) {
		evoportalLoginPage.enter_username(username);
	}

	@Step
	public void enters_password(String password) {
		evoportalLoginPage.enter_password(password);
	}

	@Step
	public void searchForLoginButton() {
		evoportalLoginPage.loginButton();
	}

	@Step
	public void inputUserName(String term) {
		enters(term);

	}

	@Step
	public void inputUserPassword(String term) {
		enters_password(term);

	}

	@Step
	public void verifyIfUserIsLoggedIn(String vacationElementText) {
		evoportalLoginPage.assertText(vacationElementText);
	}
	
	@Step
	public List<String> getMenuItem(){
		return evoportalLoginPage.getMenuItem();
	}

	@StepGroup
	public void performLogin(String username, String password) {

		inputUserName(username);
		inputUserPassword(password);
		searchForLoginButton();
	}
}
