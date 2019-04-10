package com.project.selenium.tests;

import com.project.selenium.config.AppConfig;
import com.project.selenium.entity.BookingApartmentsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchApartmentsByCityTest extends AppConfig {

    @Test
    void searchAppsByCountry() {
        driver.get("https://www.booking.com/");
        BookingApartmentsPage bookingApartmentsPage = new BookingApartmentsPage(driver);

        assertTrue(bookingApartmentsPage.isChangeLanguageInitialized());
        bookingApartmentsPage.changeLanguageToEnglish();

        assertTrue(bookingApartmentsPage.isInputFieldInitialized());
        bookingApartmentsPage.inputCityNameForSearch("New York");

        bookingApartmentsPage.clickOnCalendar();

        assertTrue(bookingApartmentsPage.isCalendarInitialized());
        bookingApartmentsPage.findDateInApsCalendar("September 2019");
        bookingApartmentsPage.setStart_Date();
        bookingApartmentsPage.setEnd_Date();

        bookingApartmentsPage.submit();

        assertTrue(bookingApartmentsPage.isLocationInitialized());

        bookingApartmentsPage.validateCityLocation("New York");

        assertTrue(bookingApartmentsPage.validateSearchByStartDate("September 1, 2019"));
        assertTrue(bookingApartmentsPage.validateSearchByEndDate("September 30, 2019"));

        System.out.println("Finish");
    }
}
