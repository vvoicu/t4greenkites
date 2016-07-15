package com.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class FreeDaysHistoryPage extends PageObject {

	// identify 1-st block and create "list" for checking list items
	// Object "Type" elements block
	@FindBy(css = "div.filter-content-history div.aui-column-first")
	private WebElementFacade filterType;

	public void checkboxType(String checkboxName) {
		List<WebElement> typeList = filterType.findElements(By.cssSelector("label"));
		for (WebElement listItem : typeList) {
			if (listItem.getText().toLowerCase().contentEquals(checkboxName.toLowerCase())) {
				listItem.click();
			}

		}
	}

	// indentify 3-rd block and create method for checking list items

	// Object: "Operation" elements block
	@FindBy(css = ".aui-column.column-three.aui-column-last")
	private WebElementFacade filterOperation;

	public void checkboxOperation(String checkboxOperationName) {
		List<WebElement> typeListOperation = filterOperation.findElements(By.cssSelector("label"));
		for (WebElement listItem : typeListOperation) {
			if (listItem.getText().toLowerCase().contentEquals(checkboxOperationName.toLowerCase())) {
				listItem.click();
			}
		}
	}

	// click on Apply
	@FindBy(css = "input.aui-button-input")
	private WebElementFacade clickApplyButton;
	
	public void applyButton() {
		clickApplyButton.click();
	}
	
	
	
}