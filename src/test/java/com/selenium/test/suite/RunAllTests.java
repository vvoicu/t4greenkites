package com.selenium.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tests.Test_HeaderNavigation;
import com.tests.Test_Login;

@RunWith(Suite.class)
@SuiteClasses({
	Test_Login.class,
	Test_HeaderNavigation.class,
	
})
public class RunAllTests {

}
