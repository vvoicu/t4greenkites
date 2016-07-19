package com.selenium.steps;

import com.selenium.pages.NewVacationRequest_ContentPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class NewVacationRequestSteps {

	public NewVacationRequest_ContentPage vacationRequestPage;
	
	@Step
	public void selectStartDateField(){
		vacationRequestPage.selectStartDate();
	}
	@Step
	public void selectEndDateField(){
		vacationRequestPage.selectEndDate();
	}
	@Step
	public void clickYear(){
		vacationRequestPage.clickYear();
	}
	
	@Step
	public void selectRequestedYear(String year){
		vacationRequestPage.selectYear(year);
	}
	
	@Step
	public void selectRequestedMonth(String month){
		vacationRequestPage.selectMonth(month);
	}
	
	@Step
	public void selectRequestedDay(String day){
		vacationRequestPage.selectDay(day);
	}
	
	@Step
	public void waitSeconds(){
		vacationRequestPage.waitTenSeconds();
	}
	
	@StepGroup
	public void selectStartDate(String year, String month, String day){
		selectRequestedYear(year);
		selectRequestedMonth(month);
		selectRequestedDay(day);
		
	}
	
	@Step
	public void clickOnSaveButton(){
		vacationRequestPage.clickOnSaveButton();
	}
	
	@Step
	public void verifyTheErrorMessage(String textToVerify){
		vacationRequestPage.verifyTheErrorMessage(textToVerify);
	}
	
	@Step
	public void selectVacationType(String vacationTypeName){
		vacationRequestPage.selectVacationType(vacationTypeName);
	}
	
	@Step 
	public void selectSpecialVacation(String specialVacationName){
		vacationRequestPage.selectSpecialVacation(specialVacationName);
	}
	
	@Step
	public void clickOnDropDown(){
		vacationRequestPage.clickOnDropDown();
	}
	
}
