package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HeaderNavigationSteps;
import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LeftMenuSteps;
import com.selenium.steps.LoginSteps;
import com.selenium.steps.NewVacationRequestSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import tools.Constants;

@RunWith(SerenityRunner.class)
public class NVR01CreateTwoOverlappedRequestsTest extends BaseTest {

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

	public String year = "2016";
	public String month = "Nov";
	public String day = "9";

	public String futureYear = "2016";
	public String futureMonth = "Nov";
	public String futureDay = "11";
	
	public String dayTest2 = "10";

	public String futureDayTest2 = "11";
	
	@Test
	public void createTwoOverlappedRequests() {
		homeSteps.isTheHomePage();
		homeSteps.starts_searchForSignInButton();
		userSteps.performLogin(userName, password);
		headerNavigationSteps.selectMenuItem();
		leftMenuSteps.clickNewVacationRequest();
		newVacationSteps.selectStartDateField();
		newVacationSteps.clickYear();
		newVacationSteps.selectStartDate(year, month, day);
		newVacationSteps.selectEndDateField();
		newVacationSteps.clickYear();
		newVacationSteps.selectStartDate(futureYear, futureMonth, futureDay);
		newVacationSteps.clickOnSaveButton();
		headerNavigationSteps.selectMenuItem();
		leftMenuSteps.clickNewVacationRequest();
		newVacationSteps.selectStartDateField();
		newVacationSteps.clickYear();
		newVacationSteps.selectStartDate(year, month, dayTest2);
		newVacationSteps.selectEndDateField();
		newVacationSteps.clickYear();
		newVacationSteps.selectStartDate(futureYear, futureMonth, futureDayTest2);
		newVacationSteps.clickOnSaveButton();
		newVacationSteps.verifyTheErrorMessage("You already have a vacantion set up overlaping the selected time range");
	}
}
