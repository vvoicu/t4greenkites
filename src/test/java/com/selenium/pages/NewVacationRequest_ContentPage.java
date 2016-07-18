package com.selenium.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class NewVacationRequest_ContentPage extends PageObject {

	@FindBy(css = "input[id*='startDate']")
	private WebElementFacade startDateElement;
	
	@FindBy(css = "input[id*='endDate']")
	private WebElementFacade endDateElement;

	@FindBy(css = "div.Zebra_DatePicker[style*='block']")
	private WebElementFacade datePicker;
	
	@FindBy(css="input[value='Desa']")
	private WebElementFacade saveButton;
	
	@FindBy (css="#createVacation .portlet-msg-error")
	private WebElementFacade errorMessage;
	
	@FindBy(css="div.vacationType ")
	private WebElementFacade vacationTypeCheckbox;
	
	@FindBy(css="select[name='specialReason']")
	private WebElementFacade specialVacationDropdown;
	
	public void clickOnDropDown(){
		specialVacationDropdown.click();
	}
	
	public void selectSpecialVacation(String specialVacationName){
		waitABit(1000);
		if(specialVacationDropdown.isDisplayed()){
			specialVacationDropdown.selectByVisibleText(specialVacationName);
			
		}
	}
	
	public void selectVacationType(String checkboxName){
		List<WebElement> listType=vacationTypeCheckbox.findElements(By.cssSelector("label"));
		for(WebElement list:listType){
		  if(list.getText().contentEquals(checkboxName)){
			  list.click();
		  }
		}
	}

	public void clickOnSaveButton(){
		saveButton.click();
	}
	public void selectStartDate() {
		startDateElement.click();
	}
	
	public void selectEndDate() {
		endDateElement.click();
	}

	public void clickYear() {
		WebElement yearElement = datePicker.findElement(By.cssSelector("td.dp_caption"));
		yearElement.click();
	}

	/**
	 * Verify if currentYear is the year that you, as a user, want, if not,
	 * while cycles will find the currentYear
	 * 
	 * @param year
	 */
	public void selectYear(String year) {
		boolean verifyYear = false;
		WebElement currentYear = datePicker.findElement(By.cssSelector(".dp_caption"));
		if (currentYear.getText().contentEquals(year)) {
			verifyYear = true;
			System.out.println(Integer.parseInt(currentYear.getText()));
		}
		if(Integer.parseInt(year)<Integer.parseInt(currentYear.getText())){
			Assert.assertTrue("Year not found", verifyYear);
			
		}
		while (!(verifyYear)) {
				WebElement nextYearButton = datePicker.findElement(By.cssSelector(".dp_next"));
				nextYearButton.click();
				WebElement selectedYear = datePicker.findElement(By.cssSelector(".dp_caption"));
				if (selectedYear.getText().contentEquals(year)) {
					verifyYear = true;
				}

			}

	}

	public void selectMonth(String month) {
		boolean verifyMonth = false;
		WebElement selectMonth = datePicker.findElement(By.cssSelector(".dp_monthpicker"));
		List<WebElement> typeList = selectMonth.findElements(By.cssSelector("td:not(.dp_disabled)"));// select
																										// only
																										// the
																										// active
																										// month
		for (WebElement list : typeList) {
			System.out.println("Current active months " + list.getText());
			if (list.getText().contentEquals(month)) {
				verifyMonth = true;
				list.click();
				break;
			}

		}
		if (!(verifyMonth)) {
			Assert.assertTrue("Month not found", verifyMonth);
		}
	}

	public void selectDay(String day) {
		boolean verifyDay = false;
		WebElement selectDay = datePicker.findElement(By.cssSelector(".dp_daypicker"));
		List<WebElement> typeDaysList = selectDay.findElements(By.cssSelector(
				"tr td:not(.dp_not_in_month):not(.dp_weekend_disabled)"));
		
		
		for (WebElement daylist : typeDaysList) {
			System.out.println("days list: "+daylist.getText());	
			if (daylist.getText().contentEquals(day)) {
				System.out.println("if day: "+daylist.getText());
				verifyDay = true;
				daylist.click();
				break;
			}
		}
		if (!(verifyDay)) {
			Assert.assertTrue("Day not found", verifyDay);
		}
	}
	
	public void verifyTheErrorMessage(String textToVerify){
		  Assert.assertTrue(errorMessage.getText().contentEquals(textToVerify));
		
	}

	public void waitTenSeconds() {
		waitABit(10000);
	}
}
