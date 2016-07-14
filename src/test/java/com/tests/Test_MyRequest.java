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
public class Test_MyRequest extends BaseTest{

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
		home.is_the_home_page();
		home.starts_searchForSignInButton();
		userSteps.performLogin(Constants.USERNAME, Constants.PASSWORD);
		headerSteps.selectMenuItem();
		leftMenuSteps.click_secondElement();
		myRequestsSteps.click_CheckBoxItem("Holiday");
		myRequestsSteps.click_ApplyButton();
		myRequestsSteps.find_WebElement("Holiday");
	}
	
}
