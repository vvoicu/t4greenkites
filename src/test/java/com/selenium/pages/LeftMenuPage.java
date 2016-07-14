package com.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://172.22.4.88:9090")
public class LeftMenuPage extends PageObject {

	//Objects Left Menu
	@FindBy(css = "div.carousel-slider.span3:first-child ul li:nth-child(2)")
	private WebElementFacade NewVacationRequest;
	
	@FindBy(css = "div.carousel-slider.span3:first-child ul li:nth-child(3)")
	private WebElementFacade MyRequests;

	@FindBy(css = "div.carousel-slider.span3 ul li:nth-child(4)")
	private WebElementFacade MyFreeDays;
	
	@FindBy(css = "div.carousel-slider.span3 ul li:nth-child(5)")
	private WebElementFacade MyFreeDaysHistory;
	
	@FindBy(css = "div.carousel-slider.span3:nth-child(2) ul li:nth-child(3)")
	private WebElementFacade Track;
	
	//Methods for Objects
	public void clickNewVacationRequest() {
		NewVacationRequest.click();
	}
	public void clickMyRequests() {
		MyRequests.click();
	}
	public void clickMyFreeDays() {
		MyFreeDays.click();
	}
	public void clickFreeDaysHistory() {
		MyFreeDaysHistory.click();
	}
	public void clickTrack() {
		Track.click();
	}
	
}
