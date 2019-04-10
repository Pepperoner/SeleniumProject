package com.project.selenium.tests;

import com.project.selenium.config.AppConfig;
import com.project.selenium.entity.BookingFlightsPage;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchFlightsTest extends AppConfig {

    @Test
    void searchFlights() {
        driver.get("https://www.booking.com/");
        BookingFlightsPage searchFlightsPage = new BookingFlightsPage(driver);

        assertTrue(searchFlightsPage.isChangeLanguageInitialized());
        searchFlightsPage.changeLanguageToEnglish();
        searchFlightsPage.clickToClosePopup();

        searchFlightsPage.clickToSearchFlightTab();

        String parent = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        for (String child_window : s1) {
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                //driver.close();
            }
        }

        searchFlightsPage.setFlightWays();

        searchFlightsPage.inputInitialFlightCity("Kiev");
        searchFlightsPage.inputFinalFlightCity("London");

        searchFlightsPage.clickOnCalendar();


        searchFlightsPage.findDateInFlightCalendar(2,5,"May 2019");
        searchFlightsPage.setInitialFlightDate();

        searchFlightsPage.clickToSearchFlightsButton();
    }
}
