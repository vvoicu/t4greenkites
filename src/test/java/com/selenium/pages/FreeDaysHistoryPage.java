package com.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class FreeDaysHistoryPage extends PageObject {

	@FindBy(css = "div.filter-content-history div.aui-column-first")
	private WebElementFacade filterType;

	@FindBy(css = "input.aui-button-input")
	private WebElementFacade clickApplyButton;

	@FindBy(css = ".aui-column.column-three.aui-column-last")
	private WebElementFacade filterOperation;
	
	@FindBy(css="div.lfr-search-container")
	private WebElementFacade table;

	public void selectVactionTypeFilter(String checkboxName) {
		List<WebElement> typeList = filterType.findElements(By.cssSelector("label"));
		for (WebElement listItem : typeList) {
			if (listItem.getText().toLowerCase().contentEquals(checkboxName.toLowerCase())) {
				listItem.click();
			}

		}
	}

	public void checkboxOperation(String checkboxOperationName) {
		List<WebElement> typeListOperation = filterOperation.findElements(By.cssSelector("label"));
		for (WebElement listItem : typeListOperation) {
			if (listItem.getText().toLowerCase().contentEquals(checkboxOperationName.toLowerCase())) {
				listItem.click();
			}
		}
	}

	public void clickApplyButton() {
		clickApplyButton.click();
	}
	
	public void checkListFromTable(String columnTable) {
		Boolean found=true;
		List<WebElement> tableList = table.findElements(By.cssSelector("td.col-2"));
		for(WebElement list:tableList ){
			if(list.getText().toLowerCase().contentEquals(columnTable.toLowerCase())){
				found=false;
			}
		}
			
	}
}