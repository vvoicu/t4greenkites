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

	@FindBy(css = "div.Zebra_DatePicker[style*='block']")
	private WebElementFacade datePicker;

	public void selectStartDate() {
		startDateElement.click();
	}

	public void clickYear() {
		WebElement yearElement = datePicker.findElement(By.cssSelector("td.dp_caption"));
		yearElement.click();
	}

	
	/**
	 * Verify if currentYear is the year that you, as a user, want, if not, while cycles will find the currentYear
	 * @param year
	 */
	public void selectYear(String year) {
		boolean verifyYear = false;
		WebElement currentYear = datePicker.findElement(By.cssSelector(".dp_caption"));
		if (currentYear.getText().contentEquals(year)) {
			verifyYear = true;
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
		WebElement selectMonth = datePicker.findElement(By.cssSelector(".dp_monthpicker"));
		List<WebElement> typeList = selectMonth.findElements(By.cssSelector("td:not(.dp_disabled)"));//select only the active month
		for (WebElement list : typeList) {
			System.out.println("Current active months " + list.getText());
			if (list.getText().contentEquals(month)) {
				list.click();
				break;
			}
		}
	}

	public void selectDay(String day) {
		WebElement selectDay = datePicker.findElement(By.cssSelector(".dp_daypicker"));
		List<WebElement> typeDaysList = selectDay.findElements(By.cssSelector(
				".dp_daypicker td:not(.dp_not_in_month)+td:not(.dp_disabled)+td:not(dp_weekend_disabled)")); //select only the active days
		for (WebElement daylist : typeDaysList) {
			if (daylist.getText().contentEquals(day)) {
				daylist.click();
			}
		}
	}
	
	public void waitTenSeconds(){
		waitABit(10000);
	}
}
