package com.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class LogoutPage extends PageObject {
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	//js.
	//WebElement element =getDriver().findElement(By.cssSelector(".aui-menu-content"));
	
	 

	@FindBy(css = "ul .user-avatar")
	private WebElementFacade userIdentifier;
	
	public void clickOnUserIdentifier(String userOption){
	
			
		
	}
	
}
