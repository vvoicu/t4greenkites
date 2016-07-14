package com.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class FreeDaysHistoryPage extends PageObject {

	@FindBy(css = "input[id*='EVOZONCheckbox']")
	private WebElementFacade clickOnAnniversaryCheckbox;

	public void clickOnAnniversary() {
		clickOnAnniversaryCheckbox.click();
	}

	@FindBy(css = "input[id*='FIFTHCheckbox']")
	private WebElementFacade clickOnOneToFiveCheckbox;

	public void clickOnOneToFiveCheckbox() {
		clickOnOneToFiveCheckbox.click();
	}
	
	@FindBy(css="input[id*='applyButton']")
	private WebElementFacade clickApplyButton;
	
	public void clickApplyButton() {
		clickApplyButton.click();
	}
}