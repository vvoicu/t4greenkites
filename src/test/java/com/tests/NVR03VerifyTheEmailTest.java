package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.EmailVerificationSteps;
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
public class NVR03VerifyTheEmailTest extends BaseTest {
	
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
	
	@Steps
	public EmailVerificationSteps email;

	public String year, month, day, futureYear, futureMonth, futureDay, vacationTypeName, specialVacationName;
	@Test
	public void verifyTheEmail(){
		homeSteps.isTheHomePage();
		homeSteps.clickOnSignInButton();
		userSteps.performLogin(userName, password);
		headerNavigationSteps.selectVacationMenuItem();
		leftMenuSteps.clickNewVacationRequest();
		newVacationSteps.selectStartDateField();
		newVacationSteps.clickOnTheDateFieldCaption();
		newVacationSteps.selectDate(year, month, day);
		newVacationSteps.selectEndDateField();
		newVacationSteps.clickOnTheDateFieldCaption();
		newVacationSteps.selectDate(futureYear, futureMonth, futureDay);
		newVacationSteps.selectVacationType(vacationTypeName);
		newVacationSteps.selectSpecialVacation(specialVacationName);
		newVacationSteps.clickOnSaveButton();
		email.checkEmailSubject(Constants.EMAILSUBJECT);
		

	}
}
