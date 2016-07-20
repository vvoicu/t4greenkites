package com.selenium.steps;

import net.thucydides.core.annotations.Step;
import tools.EmailVerification;

public class EmailVerificationSteps {

	public EmailVerification email;

	@Step
	public void checkEmailSubject(String emailSubject) {
		email.check(emailSubject);
	}

}
