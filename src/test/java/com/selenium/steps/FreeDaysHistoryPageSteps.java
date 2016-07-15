package com.selenium.steps;

import com.selenium.pages.FreeDaysHistoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class FreeDaysHistoryPageSteps {
	FreeDaysHistoryPage freeDaysHistoryPage;

	@Step
	public void selectVactionTypeFilter(String textToVerify) {
		freeDaysHistoryPage.selectVactionTypeFilter(textToVerify);
	}
	
	@Step 
	public void selectCheckboxOperation(String textToVerify){
		freeDaysHistoryPage.checkboxOperation(textToVerify);
	}
	
	@Step
	public void clickApplyButton() {
		freeDaysHistoryPage.clickApplyButton();
	}
	
}
	
	
	

