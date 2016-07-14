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
	
	//Object from Vacation Type
	@FindBy(css="div[class*='aui-column-content-first column-three-content ']")
	private WebElementFacade VacationType;
	
	////Object ApplyButton
	@FindBy(css = "input[id*='applyButton']")
	private WebElementFacade ApplyButton;
	
	//Object "Holiday Element"
	@FindBy(css = "table.taglib-search-iterator")
	private WebElementFacade tableMyRequest;

	//Method for click on checkBox Items from Vacation Type
	public void click_on_checkBox_Item_VacationType(String vacationTypeName){
		Boolean found=false;
		List<WebElement> typeList = VacationType.findElements(By.cssSelector("span[class*='field-content'] label"));
		for(WebElement listItem:typeList){
			if(listItem.getText().toLowerCase().contentEquals(vacationTypeName.toLowerCase())){
				if(!listItem.isSelected())
				listItem.click();
				found=true;
			}
		}
		Assert.assertTrue("The 'Vacation Type' "+ vacationTypeName +" was not found", found);
	}
	
	//Method for Apply Button 
	public void clickApplyButton() {
		ApplyButton.click();
	}
	
	//Methods for "Holiday" Element from Table
	public Boolean find_ListItem(String vacationType){
		Boolean found=true;
		List<WebElement> typeList = tableMyRequest.findElements(By.cssSelector("td.col-4"));
		for(WebElement list:typeList ){
			if(!list.getText().contentEquals(vacationType)){
				found=false;
			}
		}
		return found;
	}
	
	public void verifyTableType(String vacationType){
		Assert.assertTrue("The 'Type' Elements from table weren't found", find_ListItem(vacationType));
	}
	
}
