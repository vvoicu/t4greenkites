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


@RunWith(SerenityRunner.class)
public class MyRequestCheckDaysNumberTest extends BaseTest{

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
		userSteps.performLogin(userName,password);
		headerSteps.selectMenuItem();
		leftMenuSteps.clickMyRequests();
		myRequestsSteps.clickCheckBoxItemDaysNumber("1 - 5");
		myRequestsSteps.clickApplyButton();
		myRequestsSteps.getDaysNumberFirstNumber("1 - 5");
		myRequestsSteps.getDaysNumberLastNumber("1 - 5");
		myRequestsSteps.getDaysNumbercompareNumbers();
		

	}
}
