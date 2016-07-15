package com.selenium.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tests.Test_ContentPage;
import com.tests.HeaderNavigationTest;
import com.tests.LeftMenuClickItemsTest;
import com.tests.LoginTest;

@RunWith(Suite.class)
@SuiteClasses({
	LoginTest.class,
	HeaderNavigationTest.class,
	LeftMenuClickItemsTest.class,
	Test_ContentPage.class,
	
})
public class RunAllTests {

}
