package com.selenium.steps;

import com.selenium.pages.FreeDaysHistoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class FreeDaysHistoryPageSteps {
	FreeDaysHistoryPage freeDaysHistoryPage;

	@Step
	public void selectCheckboxType(String textToVerify) {
		freeDaysHistoryPage.checkboxType(textToVerify);
	}
	
	@Step 
	public void selectCheckboxOperation(String textToVerify){
		freeDaysHistoryPage.checkboxOperation(textToVerify);
	}
	
	@Step
	public void searchForApplyButton() {
		freeDaysHistoryPage.applyButton();
	}
	
//	/div.aui-column.aui-w75.aui-column-last span.aui-button-content input.aui-button-input
}
	
	
	

