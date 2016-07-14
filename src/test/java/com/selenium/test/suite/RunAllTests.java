package com.selenium.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tests.Test_ContentPage;
import com.tests.Test_HeaderNavigation;
import com.tests.Test_LeftMenuClick;
import com.tests.Test_Login;

@RunWith(Suite.class)
@SuiteClasses({
	Test_Login.class,
	Test_HeaderNavigation.class,
	Test_LeftMenuClick.class,
	Test_ContentPage.class,
	
})
public class RunAllTests {

}
