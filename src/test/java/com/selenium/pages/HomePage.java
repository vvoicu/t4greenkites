package com.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://172.22.4.88:9090")
public class HomePage extends PageObject {

	@FindBy(css = "a[id='sign-in']")
	private WebElementFacade signinButton;

	public void signin() {
		signinButton.click();
	}
}
