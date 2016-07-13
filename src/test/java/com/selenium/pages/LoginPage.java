package com.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class LoginPage extends PageObject {

	@FindBy(css = "input[name*='login']")
	private WebElementFacade userNameInput;

	@FindBy(css = "input[name*='password']")
	private WebElementFacade userPasswordInput;

	@FindBy(css = "input[class*='button-input-submit']")
	private WebElementFacade loginButton;

	public void enter_username(String name) {
		userNameInput.type(name);
	}

	public void enter_password(String password) {
		userPasswordInput.type(password);
	}

	public void loginButton() {
		loginButton.click();
	}

	public void assertText(String textToVerify){
		  WebElement elementVacationText = getDriver().findElement(By.cssSelector(".main-menu li:nth-child(9) a>span"));
		  Assert.assertTrue(elementVacationText.getText().contentEquals(textToVerify));
		 }
}
