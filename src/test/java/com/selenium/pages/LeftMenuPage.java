package com.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://172.22.4.88:9090")
public class LeftMenuPage extends PageObject {

	//Objects Left Menu
	@FindBy(css = "div.carousel-slider.span3:first-child ul li:nth-child(2)")
	private WebElementFacade newVacationRequest;
	
	@FindBy(css = "div.carousel-slider.span3:first-child ul li:nth-child(3)")
	private WebElementFacade myRequests;

	@FindBy(css = "div.carousel-slider.span3 ul li:nth-child(4)")
	private WebElementFacade myFreeDays;
	
	@FindBy(css = "div.carousel-slider.span3 ul li:nth-child(5)")
	private WebElementFacade myFreeDaysHistory;
	
	@FindBy(css = "div.carousel-slider.span3:nth-child(2) ul li:nth-child(3)")
	private WebElementFacade track;
	
	//Methods for Objects
	public void clickNewVacationRequest() {
		newVacationRequest.click();
	}
	public void clickMyRequests() {
		myRequests.click();
	}
	public void clickMyFreeDays() {
		myFreeDays.click();
	}
	public void clickFreeDaysHistory() {
		myFreeDaysHistory.click();
	}
	public void clickTrack() {
		track.click();
	}
	
}
