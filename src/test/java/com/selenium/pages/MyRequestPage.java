package com.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://172.22.4.88:9090")
public class MyRequestPage extends PageObject {

	//Objects Left Menu
	@FindBy(css = "input[id*='HOLIDAYCheckbox']")
	private WebElementFacade HolidayCheckBoxElement;
	
	@FindBy(css = "input[id*='applyButton']")
	private WebElementFacade ApplyButton;
	
		
	//Methods for Objects
	public void clickHolidayCheckBoxItem() {
		HolidayCheckBoxElement.click();
	}
	
	public void clickApplyButton() {
		ApplyButton.click();
	}
	
}
