package com.selenium.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;


public class contentPage extends PageObject {

	@FindBy(css = "input[value='Desa']")
	private WebElement clickOnSaveButton;

	public void clickOnSaveButton() {
		clickOnSaveButton.click();
	}

}
