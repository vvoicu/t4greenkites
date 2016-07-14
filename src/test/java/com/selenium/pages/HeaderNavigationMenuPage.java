package com.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class HeaderNavigationMenuPage extends PageObject{

	@FindBy(css = ".main-menu li:nth-child(9) a>span")
	private WebElementFacade vacationmenuitem;
	
	public void selectMenuItem() {
		vacationmenuitem.click();
	}
}
