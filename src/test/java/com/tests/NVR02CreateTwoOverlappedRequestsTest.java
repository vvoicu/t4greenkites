package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HeaderNavigationSteps;
import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LeftMenuSteps;
import com.selenium.steps.LoginSteps;
import com.selenium.steps.NewVacationRequestSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import tools.Constants;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "NewVacationRequestTest.csv", separator = Constants.CSV_SEPARATOR)
public class NVR02CreateTwoOverlappedRequestsTest extends BaseTest {

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

	public String year, month, day, futureYear, futureMonth, futureDay, vacationTypeName, specialVacationName;
	
	@Test
	public void createTwoOverlappedRequests() {
		homeSteps.isTheHomePage();
		homeSteps.clickOnSignInButton();
		userSteps.performLogin(userName, password);
		headerNavigationSteps.selectVacationMenuItem();
		leftMenuSteps.clickNewVacationRequest();
		newVacationSteps.selectStartDate(year, month, day);
		newVacationSteps.selectEndDate(futureYear, futureMonth, futureDay);
		newVacationSteps.clickOnSaveButton();
		headerNavigationSteps.selectVacationMenuItem();
		leftMenuSteps.clickNewVacationRequest();
		newVacationSteps.selectStartDate(year, month, day);
		newVacationSteps.selectEndDate(futureYear, futureMonth, futureDay);
		newVacationSteps.clickOnSaveButton();
		newVacationSteps.verifyTheErrorMessage("You already have a vacantion set up overlaping the selected time range");
	}
}
