package com.selenium.steps;

import com.selenium.pages.MyRequestPage;

import net.thucydides.core.annotations.Step;

public class MyRequestSteps {
	
	MyRequestPage myRequestsPage;

	@Step
	public void clickCheckBoxItem(String checkVacationType){
		myRequestsPage.checkVacationType(checkVacationType);
	}
	
	@Step
	public void clickApplyButton() {
		myRequestsPage.clickApplyButton();
	}

	@Step
	public void findWebElement(String vacationType) {
		myRequestsPage.searchListItem(vacationType);
	}

	@Step
	public void clickOneOrMoreCheckBoxItem(String... vacationTypeNames){
		myRequestsPage.checkAllItemsVacationType(vacationTypeNames);
	}
	
	
}
