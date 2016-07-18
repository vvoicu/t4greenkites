package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HeaderNavigationSteps;
import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LeftMenuSteps;
import com.selenium.steps.LoginSteps;
import com.selenium.steps.NewVacationRequestSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import tools.Constants;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "NewVacationRequestTest.csv", separator = Constants.CSV_SEPARATOR)
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

	public String year, month, day, futureYear, futureMonth, futureDay, vacationTypeName, specialVacationName;

	@Test
	public void createAVacationRequest() {
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
		newVacationSteps.selectVacationType(vacationTypeName);
		newVacationSteps.clickOnDropDown();
		newVacationSteps.selectSpecialVacation(specialVacationName);
		newVacationSteps.clickOnSaveButton();
		newVacationSteps.waitSeconds();

	}
}
