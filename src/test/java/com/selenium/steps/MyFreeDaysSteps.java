package com.selenium.steps;

import com.selenium.pages.MyFreeDays_ContentPage;

import net.thucydides.core.annotations.Step;

public class MyFreeDaysSteps {

	MyFreeDays_ContentPage freedays;
	
	@Step
	public void verifyTheUserFreeDays(String textToVerify){
		freedays.assertText(textToVerify);
	}
}
