package com.selenium.steps;

import com.selenium.pages.FreeDaysHistoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class FreeDaysHistoryPageSteps {
	FreeDaysHistoryPage freeDaysHistoryPage;

	@Step
	public void selectVactionTypeFilter(String testToVerify) {
		freeDaysHistoryPage.selectVactionTypeFilter(testToVerify);
	}
	
	@Step 
	public void selectCheckboxOperation(String textToVerify){
		freeDaysHistoryPage.checkboxOperation(textToVerify);
	}
	
	@Step
	public void clickApplyButton() {
		freeDaysHistoryPage.clickApplyButton();
	}
	
	@Step
	public void tableColumnText(String text) {
		freeDaysHistoryPage.checkListFromTable(text);
	}
	
	@StepGroup()
	public void filterResults(String type, String operation, String column ){
		selectVactionTypeFilter(type);
		selectCheckboxOperation(operation);
		clickApplyButton();
		tableColumnText(column);
		
	}

}
	
	
	


