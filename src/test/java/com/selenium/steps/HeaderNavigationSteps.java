package com.selenium.steps;



import com.selenium.pages.HeaderNavigationMenuPage;

import net.thucydides.core.annotations.Step;

public class HeaderNavigationSteps {

public HeaderNavigationMenuPage header;
	
	@Step
	public void selectVacationMenuItem(){
		header.selectMenuItem();
		
	}
}
