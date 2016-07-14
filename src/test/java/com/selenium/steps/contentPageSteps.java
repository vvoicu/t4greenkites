package com.selenium.steps;



import com.selenium.pages.contentPage;

import net.thucydides.core.annotations.Step;

public class contentPageSteps {

	contentPage newVacantionRequest;

	@Step
	public void searchForSaveButoon(){
		newVacantionRequest.clickOnSaveButton();
	}
		
}
