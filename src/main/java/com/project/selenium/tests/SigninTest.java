package com.project.selenium.tests;

import com.project.selenium.config.AppConfig;
import com.project.selenium.entity.BookingSignInPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SigninTest extends AppConfig {

    @Test
    void signIn() {
        driver.get("https://www.booking.com/");
        BookingSignInPage signInPage = new BookingSignInPage(driver);

        assertTrue(signInPage.isChangeLanguageInitialized());
        signInPage.changeLanguageToEnglish();

        signInPage.closePopupButton();
        signInPage.clickOnSignInButton();

        assertTrue(signInPage.isSignInInitialized());
        signInPage.enterEmail("testpepperoner@gmail.com");
        signInPage.enterPassword("pepperoner1412");
        signInPage.submitSignIn();

        signInPage.setNameIfProfileIsJustCreated("Boris","Lahutin");

        signInPage.clickOnProfile();
        signInPage.clickOnProfileDashboard();

        assertTrue(signInPage.getProfileFullName("Boris Lahutin"));
    }
}
