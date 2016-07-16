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
	
	//Object Vacation Type
	@FindBy(css="div[class='aui-column-content aui-column-content-first column-three-content ']")
	
	private WebElementFacade vacationType;
	
	//Object Days Number
	@FindBy(css="div[class='aui-column-content   column-three-content column-center-content ']")
	private WebElementFacade daysNumber;
		
	//Object Vacation Status
	@FindBy(css="div[class='aui-column-content  aui-column-content-last column-three-content column-center-content ']")
	private WebElementFacade vacationStatus; 
	
//			div[class*='aui-column-content.not(aui-column-content-first )']
//			div[class*='.not(aui-column-content-first )']
	
	
	//Object Table
	@FindBy(css = "table.taglib-search-iterator")
	private WebElementFacade tableMyRequest;

	
	
	public void clickApplyButton() {
		applyButton.click();
	}
	
	//Method for click on ONE checkBox Item from Vacation Type, Days Number and Vacation Status  
	public void checkVacationType(String vacationTypeName){
		Boolean found=false;
		List<WebElement> typeList = vacationType.findElements(By.cssSelector("label.aui-choice-label"));
		for(WebElement listItem:typeList){
			if(listItem.getText().toLowerCase().contentEquals(vacationTypeName.toLowerCase())){
				if(!listItem.isSelected())
				listItem.click();
				found=true;
			}
		}
		Assert.assertTrue("The 'Vacation Type' Element:"+ vacationTypeName +" was not found", found);
	}
	
	public void checkDaysNumber(String daysNumberName){
		Boolean found=false;
		List<WebElement> typeList =daysNumber.findElements(By.cssSelector("span[class*='field-content'] label"));
		for(WebElement listItem:typeList){
			if(listItem.getText().toLowerCase().contentEquals(daysNumberName.toLowerCase())){
				if(!listItem.isSelected())
					listItem.click();
				found=true;
			}
		}
		Assert.assertTrue("The 'Days Number' Element:"+daysNumberName+"was not found", found);
	}
	
	public void checkVacationStatus(String vacationStatusName){
		Boolean found=false;
		List<WebElement> typeList= vacationStatus.findElements(By.cssSelector("span[class*='field-content'] label"));
		for(WebElement listItem:typeList){
			if(listItem.getText().toLowerCase().contentEquals(vacationStatusName.toLowerCase())){
				if(!listItem.isSelected())
						listItem.click();
				found=true;
			}
		}
	Assert.assertTrue("The 'Vacation Status' Element: "+vacationStatusName+" was not found", found);		
	}
	
	
	//Methods for ONE OR MORE checkBox Items from Vacation Type, Days Number and Vacation Status
	public void checkAllItemsVacationType(String... vacationTypeNames){
		for (String name : vacationTypeNames){
			Boolean found=false;
			List<WebElement> typeList = vacationType.findElements(By.cssSelector("span[class*='field-content'] label"));
			for(WebElement listItem:typeList){
				if(listItem.getText().toLowerCase().contentEquals(name.toLowerCase())){
					if(!listItem.isSelected())
					listItem.click();
					found=true;
				}
			}
			Assert.assertTrue("The 'Vacation Type'"+ name +" was not found", found);

		}
	}
		
	//Methods for "TYPE" Element from Table
	public void searchTypeItem(String vacationType){
		Boolean found=true;
		List<WebElement> typeList = tableMyRequest.findElements(By.cssSelector("td[class='align-left col-4 col-my.request.column.header.type  valign-middle']"));
		for(WebElement list:typeList ){
			if(!list.getText().toLowerCase().contentEquals(vacationType)){
				found=false;
			}
		}
		Assert.assertTrue("The 'Type' from table"+ vacationType+ "was not found", found);
	}
	
	//Methods for "TYPE" Element from Table
		public void searchStatus(String vacationType){
			Boolean found=true;
			List<WebElement> typeList = tableMyRequest.findElements(By.cssSelector("td.col-6"));
			for(WebElement list:typeList ){
				if(!list.getText().toLowerCase().contentEquals(vacationType)){
					found=false;
				}
			}
			Assert.assertTrue("The 'Type' from table"+ vacationType+ "was not found", found);
		}
}
