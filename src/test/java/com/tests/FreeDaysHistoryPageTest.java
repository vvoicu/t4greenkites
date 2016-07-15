package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.FreeDaysHistoryPageSteps;
import com.selenium.steps.HeaderNavigationSteps;
import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LeftMenuSteps;
import com.selenium.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import tools.Constants;

@RunWith(SerenityRunner.class)
public class FreeDaysHistoryPageTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public LoginSteps userSteps;

	@Steps
	public HomePageSteps home;

	@Steps
	public HeaderNavigationSteps headerSteps;

	@Steps
	public LeftMenuSteps leftMenuSteps;

	@Steps
	public FreeDaysHistoryPageSteps freeDaysHistory;
	
	
	@Test
	public void checkFreeDaysHistory () {
		home.isTheHomePage();
		home.starts_searchForSignInButton();
		userSteps.performLogin(Constants.USERNAME, Constants.PASSWORD);
		headerSteps.selectMenuItem();
		leftMenuSteps.clickFreeDaysHistory();
		freeDaysHistory.selectVactionTypeFilter("Vacation days");
		freeDaysHistory.selectCheckboxOperation("Removed Days");
		freeDaysHistory.clickApplyButton();
		freeDaysHistory.tableColumnText("Vacation Days");
		
	}

}
