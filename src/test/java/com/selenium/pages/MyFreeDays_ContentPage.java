package com.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class MyFreeDays_ContentPage extends PageObject {

	@FindBy(css = "div .content.title")
	private WebElementFacade userNameInput;
	
	public void assertText(String textToVerify){
		  WebElement elementVacationText = getDriver().findElement(By.cssSelector("div .content-title"));
		  Assert.assertTrue(elementVacationText.getText().contentEquals(textToVerify));
		 }
}
