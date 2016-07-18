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
public class MyRequestCheckOneOrMoreItemsTest extends BaseTest{

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
	public void clickRandomElement(){
		home.isTheHomePage();
		home.starts_searchForSignInButton();
		userSteps.performLogin(Constants.USERNAME, Constants.PASSWORD);
		headerSteps.selectMenuItem();
		leftMenuSteps.clickMyRequests();
	//myRequestsSteps.clickOneOrMoreCheckBoxItem(Constants.VACATIONTYPE_HOLIDAY,Constants.VACATIONTYPE_VACATION, Constants.VACATIONTYPE_SPECIALVACATION, Constants.VACATIONTYPE_SICKLEAVE, Constants.VACATIONTYPE_MATERNITY);
		myRequestsSteps.clickApplyButton();
	}
}
