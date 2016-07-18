package com.tests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.HomePageSteps;
import com.selenium.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {

	@Steps
	public LoginSteps userSteps;

	@Steps
	public HomePageSteps homeSteps;

	@Test
	public void loginSimpleUser() {
		homeSteps.isTheHomePage();
		homeSteps.starts_searchForSignInButton();
		userSteps.performLogin(userName, password);
		userSteps.verifyIfUserIsLoggedIn("VACATION");
	}
	
	@After
	public void writeMenuItem() throws IOException{
		List<String> listMenuName=userSteps.getMenuItem();
		
		Properties itemProp=new Properties();
		OutputStream output=null;
		String finalString = "";
		
		output=new FileOutputStream("menuItem.properties");
		for(int i=0;i<listMenuName.size();i++){
			finalString +=listMenuName.get(i) + ",";
		}
		

		itemProp.setProperty("topMenuItemName", finalString);

		itemProp.store(output, null);
	}
}
