package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HeaderNavigationSteps;
import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LeftMenuSteps;
import com.selenium.steps.LoginSteps;
import com.selenium.steps.MyRequestSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import tools.Constants;

@RunWith(SerenityRunner.class)
public class MyRequestCheckOneItemTest extends BaseTest{

	@Steps
	public MyRequestSteps myRequestsSteps;
	
	@Steps
	public LoginSteps userSteps;
	
	@Steps
	public HomePageSteps home;
	
	@Steps
	public HeaderNavigationSteps headerSteps;
	
	@Steps
	public LeftMenuSteps leftMenuSteps;
	
	@Test
	public void findElement(){
		home.isTheHomePage();
		home.starts_searchForSignInButton();
		userSteps.performLogin(Constants.USERNAME, Constants.PASSWORD);
		headerSteps.selectMenuItem();
		leftMenuSteps.clickMyRequests();
		myRequestsSteps.clickCheckBoxItem(Constants.VACATIONTYPE_HOLIDAY);
		myRequestsSteps.clickApplyButton();
		myRequestsSteps.findWebElement(Constants.VACATIONTYPE_HOLIDAY);
	}
}
