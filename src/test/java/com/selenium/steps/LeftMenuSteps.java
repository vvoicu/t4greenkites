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
	public void click_firstElement(){
		LeftMenuPage.clickNewVacationRequest();
	}
	
	@Step
	public void click_secondElement(){
		LeftMenuPage.clickMyRequests();
	}
	
	@Step
	public void click_thirdElement(){
		LeftMenuPage.clickMyFreeDays();
	}
	
	@Step
	public void click_fourthElement(){
		LeftMenuPage.clickFreeDaysHistory();
	}
	
	@Step
	public void click_fifthElement(){
		LeftMenuPage.clickTrack();
	}
	
	//All the above steps in a StepGroup
	@StepGroup
	public void click_leftMenu_listItems() {
		click_firstElement();
		click_secondElement();
		click_thirdElement();
		click_fourthElement();
		click_fifthElement();
	}

	
}
