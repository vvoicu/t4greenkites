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

	// Object Vacation Type
	@FindBy(css = "div[class='aui-column-content aui-column-content-first column-three-content ']")

	private WebElementFacade vacationType;

	// Object Days Number
	@FindBy(css = ".column-center-content:not([class*='last'])")
	private WebElementFacade daysNumber;

	// Object Vacation Status
	@FindBy(css = "div[class='aui-column-content  aui-column-content-last column-three-content column-center-content ']")
	private WebElementFacade vacationStatus;

	// Object Table
	@FindBy(css = "table.taglib-search-iterator")
	private WebElementFacade tableMyRequest;

	public void clickApplyButton() {
		applyButton.click();
	}

	// Method for click on ONE checkBox Item from Vacation Type, Days Number and Vacation Status
	public void checkVacationType(String vacationTypeName) {
		Boolean found = false;
		List<WebElement> typeList = vacationType.findElements(By.cssSelector("label.aui-choice-label"));
		for (WebElement listItem : typeList) {
			if (listItem.getText().toLowerCase().contentEquals(vacationTypeName.toLowerCase())) {
				if (!listItem.isSelected())
					listItem.click();
				found = true;
			}
		}
		Assert.assertTrue("The 'Vacation Type' Element:" + vacationTypeName + " was not found", found);
	}

	public void checkDaysNumber(String daysNumberName) {
		Boolean found = false;
		List<WebElement> typeList = daysNumber.findElements(By.cssSelector(".aui-choice-label"));
		for (WebElement listItem : typeList) {
			if (listItem.getText().toLowerCase().contentEquals(daysNumberName.toLowerCase())) {
				if (!listItem.isSelected())
					listItem.click();
				found = true;
			}
		}
		Assert.assertTrue("The 'Days Number' Element:" + daysNumberName + "was not found", found);
	}

	public void checkVacationStatus(String vacationStatusName) {
		Boolean found = false;
		List<WebElement> typeList = vacationStatus.findElements(By.cssSelector("span[class*='field-content'] label"));
		for (WebElement listItem : typeList) {
			if (listItem.getText().toLowerCase().contentEquals(vacationStatusName.toLowerCase())) {
				if (!listItem.isSelected())
					listItem.click();
				found = true;
			}
		}
		Assert.assertTrue("The 'Vacation Status' Element: " + vacationStatusName + " was not found", found);
	}

	// Methods for ONE OR MORE checkBox Items from Vacation Type, Days Number and Vacation Status
	public void checkAllItemsVacationType(String... vacationTypeNames) {
		for (String name : vacationTypeNames) {
			Boolean found = false;
			List<WebElement> typeList = vacationType.findElements(By.cssSelector("span[class*='field-content'] label"));
			for (WebElement listItem : typeList) {
				if (listItem.getText().toLowerCase().contentEquals(name.toLowerCase())) {
					if (!listItem.isSelected())
						listItem.click();
					found = true;
				}
			}
			Assert.assertTrue("The 'Vacation Type'" + name + " was not found", found);

		}
	}

	// Methods for verifying "TYPE" Element from Table
	public void searchTypeItem(String vacationType) {
		Boolean found = true;
		List<WebElement> typeList = tableMyRequest.findElements(By.cssSelector("align-left col-4 col-my.request.column.header.type valign-middle"));
		for (WebElement list : typeList) {
			if (!list.getText().toLowerCase().contentEquals(vacationType)) {
				found = false;
			}
		}
		Assert.assertTrue("The 'Type' from table" + vacationType + "was not found", found);
	}

	// Methods for verifying "STATUS" Element from Table
	public void searchStatus(String vacationType) {
		Boolean found = true;
		List<WebElement> typeList = tableMyRequest.findElements(By.cssSelector("align-left col-6 col-my.request.column.header.status last valign-middle"));
		for (WebElement list : typeList) {
			if (!list.getText().toLowerCase().contentEquals(vacationType)) {
				found = false;
			}
		}
		Assert.assertTrue("The 'Type' from table" + vacationType + "was not found", found);
	}

//	public void grabSelectedDaysFilter(){
//		WebElement daysColumnContainer = getDriver().findElement(By.cssSelector(".column-center-content:not([class*='last'])"));
//		List<WebElement> itemsList = daysColumnContainer.findElements(By.cssSelector(".aui-field"));
//		
//			String[] splitter;
//			for (WebElement webElement : itemsList) {
//				splitter = webElement.getText().split("-");
//				for (String string : splitter) {
//					System.out.println("item: " + string.trim());
//	      			} 	}   }	

//	// Methods for spliting elements DAYS Number
	String dateFilter;
	int intFirstDate, intLastDate;
	
	public int getFirstNumber(String dateFilter){
		 String[] dateSplitter = dateFilter.split(" - ");
		 String stringDate = dateSplitter[0];
		 int intFirstDate = Integer.parseInt(stringDate);
		return intFirstDate ;
	 }
	
	 public int getLastNumber(String dateFilter){
		 String[] dateSplitter = dateFilter.split(" - ");
		 String stringDate = dateSplitter[1];
		 int intLastDate = Integer.parseInt(stringDate);
		return intLastDate ;
	 }

	
	 public void compareNumbers(){
		 Boolean found = false;
			List<WebElement> typeList = tableMyRequest.findElements(By.cssSelector("align-left col-3 col-my.request.column.header.day.number valign-middle"));
			for (WebElement list : typeList) {
			int webElementNumber=Integer.parseInt(list.getText());
				if(webElementNumber>intFirstDate&&webElementNumber<intLastDate){
					found=true;
				}
			Assert.assertFalse("The 'DaysNumber' from table was not found", found);		
			}
	 }
}
