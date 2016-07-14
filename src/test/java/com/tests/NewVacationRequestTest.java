package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HeaderNavigationSteps;
import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LeftMenuSteps;
import com.selenium.steps.LoginSteps;
import com.selenium.steps.MyFreeDaysSteps;
import com.selenium.steps.NewVacationRequestSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import tools.Constants;

@RunWith(SerenityRunner.class)
public class NewVacationRequestTest extends BaseTest {

	@Steps
	public LoginSteps userSteps;

	@Steps
	public HomePageSteps homeSteps;

	@Steps
	public HeaderNavigationSteps headerNavigationSteps;

	@Steps
	public LeftMenuSteps leftMenuSteps;

	
	@Steps
	public NewVacationRequestSteps newVacationSteps;
	
	public String year="2017";
	public String month="Jan";
	public String day="27";

	@Test
	public void createAVacationRequest() {
		homeSteps.is_the_home_page();
		homeSteps.starts_searchForSignInButton();
		userSteps.performLogin(Constants.USERNAME, Constants.PASSWORD);
		headerNavigationSteps.selectMenuItem();
		leftMenuSteps.clickNewVacationRequest();
		newVacationSteps.selectStartDateField();
		newVacationSteps.clickYear();
		newVacationSteps.selectStartDate(year,month,day);
        newVacationSteps.waitSeconds();
        
	}
}
