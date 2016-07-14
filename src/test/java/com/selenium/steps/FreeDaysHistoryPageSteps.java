package com.selenium.steps;

import com.selenium.pages.FreeDaysHistoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class FreeDaysHistoryPageSteps {
	FreeDaysHistoryPage FreeDaysHistoryPage;
	
	@Step
	public void clickTheAnniversaryCheckbox () {
		FreeDaysHistoryPage.clickOnAnniversary();
	}
	
	@Step
	public void clickTheOneToFiveCheckBox () {
		FreeDaysHistoryPage.clickOnOneToFiveCheckbox();
	}
	
	@Step
	public void clickApplyButton() {
		FreeDaysHistoryPage.clickApplyButton();
	}
	
	@StepGroup
	public void clickOnTypeAndDaysNumberCheckbox () {
		clickTheAnniversaryCheckbox();
		clickTheOneToFiveCheckBox();
		clickApplyButton();
	}
}
