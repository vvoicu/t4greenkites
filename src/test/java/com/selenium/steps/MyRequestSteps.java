package com.selenium.steps;

import com.selenium.pages.MyRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class MyRequestSteps {
	
	MyRequestPage myRequestsPage;

	@Step
	public void click_CheckBoxItem(String checkBoxVacationType){
		myRequestsPage.click_on_checkBox_Item_VacationType(checkBoxVacationType);
	}
	
	@Step
	public void click_ApplyButton() {
		myRequestsPage.clickApplyButton();
	}


	@StepGroup
	public void find_WebElement(String vacationType) {
		myRequestsPage.find_ListItem(vacationType);
		myRequestsPage.verifyTableType(vacationType);
	}

}
