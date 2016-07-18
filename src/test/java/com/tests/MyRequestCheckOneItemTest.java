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
	
	public String vacationType; 
	public String daysNumber;
	public String vacationStatus;
	
	@Test
	public void findElement(){
//		home.isTheHomePage();
//		home.starts_searchForSignInButton();
//		userSteps.performLogin(Constants.USERNAME, Constants.PASSWORD);
//		headerSteps.selectMenuItem();
		leftMenuSteps.clickMyRequests();
		myRequestsSteps.clickCheckBoxItemVacationType(vacationType);
		myRequestsSteps.clickApplyButton();
	    myRequestsSteps.findWebElement(vacationType);
	
		myRequestsSteps.clickCheckBoxItemDaysNumber(daysNumber);
		myRequestsSteps.clickApplyButton();
//	//	myRequestsSteps.findWebElement(Constants.DAYSNUMBER_1_5);
//		
		myRequestsSteps.clickCheckBoxItemVacationStatus(vacationStatus);
		myRequestsSteps.clickApplyButton();
		myRequestsSteps.findStatus(vacationStatus);
	}
}
