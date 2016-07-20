package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HeaderNavigationSteps;
import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LeftMenuSteps;
import com.selenium.steps.LoginSteps;
import com.selenium.steps.MyRequestSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import tools.Constants;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value=Constants.CSV_FILES_PATH + "MyRequestFilterRequests.csv", separator = Constants.CSV_SEPARATOR)

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
	
	public String vacationType;
	
	@Test
	public void clickRandomElement(){
		home.isTheHomePage();
		home.starts_searchForSignInButton();
		userSteps.performLogin(userName,password);
		headerSteps.selectMenuItem();
		leftMenuSteps.clickMyRequests();
		myRequestsSteps.clickOneOrMoreCheckBoxItem(vacationType);
		myRequestsSteps.clickApplyButton();
	}
}
