package com.selenium.steps;

import com.selenium.pages.MyRequestPage;

import net.thucydides.core.annotations.Step;

public class MyRequestSteps {
	
	MyRequestPage myRequestsPage;

	@Step
	public void clickCheckBoxItemVacationType(String checkVacationType){
		myRequestsPage.checkVacationType(checkVacationType);
	}
	
	@Step
	public void clickCheckBoxItemDaysNumber(String checkDaysNumber){
		myRequestsPage.checkDaysNumber(checkDaysNumber);
	}
	
	@Step
	public void clickCheckBoxItemVacationStatus(String checkvacationStatus){
		myRequestsPage.checkVacationStatus(checkvacationStatus);
	}
	
	@Step
	public void clickApplyButton() {
		myRequestsPage.clickApplyButton();
	}

	@Step
	public void findWebElement(String vacationType) {
		myRequestsPage.searchTypeItem(vacationType);
	}

	@Step
	public void findStatus(String status){
		myRequestsPage.searchStatus(status);}
	
	@Step
	public void clickOneOrMoreCheckBoxItem(String... vacationTypeNames){
		myRequestsPage.checkAllItemsVacationType(vacationTypeNames);
	}
	
	
}
