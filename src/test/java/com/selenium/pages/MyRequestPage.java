package com.selenium.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://172.22.4.88:9090")
public class MyRequestPage extends PageObject {
	
	@FindBy(css = "input[id*='applyButton']")
	private WebElementFacade applyButton;
	
	//Object from Vacation Type
	@FindBy(css="div[class*='aui-column-content-first column-three-content ']")
	private WebElementFacade vacationType;
		
	//Object "Holiday Element"
	@FindBy(css = "table.taglib-search-iterator")
	private WebElementFacade tableMyRequest;

	public void clickApplyButton() {
		applyButton.click();
	}
	
	//Method for click on checkBox Items from Vacation Type
	public void checkVacationType(String vacationTypeName){
		Boolean found=false;
		List<WebElement> typeList = vacationType.findElements(By.cssSelector("span[class*='field-content'] label"));
		for(WebElement listItem:typeList){
			if(listItem.getText().toLowerCase().contentEquals(vacationTypeName.toLowerCase())){
				if(!listItem.isSelected())
				listItem.click();
				found=true;
			}
		}
		Assert.assertTrue("The 'Vacation Type' "+ vacationTypeName +" was not found", found);
	}
	
	//Methods for "Holiday" Element from Table
	public void searchListItem(String vacationType){
		Boolean found=true;
		List<WebElement> typeList = tableMyRequest.findElements(By.cssSelector("td.col-4"));
		for(WebElement list:typeList ){
			if(!list.getText().contentEquals(vacationType)){
				found=false;
			}
		}
		Assert.assertTrue("The 'Type' from table"+ vacationType+ "was not found", found);
	}
}
