package com.selenium.steps;

import com.selenium.pages.LeftMenuPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class LeftMenuSteps {
	
	LeftMenuPage LeftMenuPage;

	@Step
	public void is_the_home_page() {
		LeftMenuPage.open();
	}
	
	//Steps for List Items to click
	@Step
	public void clickNewVacationRequest(){
		LeftMenuPage.clickNewVacationRequest();
	}
	
	@Step
	public void clickMyRequests(){
		LeftMenuPage.clickMyRequests();
	}
	
	@Step
	public void clickMyFreeDays(){
		LeftMenuPage.clickMyFreeDays();
	}
	
	@Step
	public void clickFreeDaysHistory(){
		LeftMenuPage.clickFreeDaysHistory();
	}
	
	@Step
	public void clickTrack(){
		LeftMenuPage.clickTrack();
	}
	
	//All the above steps in a StepGroup
	@StepGroup
	public void clickLeftMenuListItems() {
		clickNewVacationRequest();
		clickMyRequests();
		clickMyFreeDays();
		clickFreeDaysHistory();
		clickTrack();
	}

	
}
