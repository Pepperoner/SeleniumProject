package com.project.selenium.entity;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.project.selenium.util.CommonUtils.*;
import static com.project.selenium.util.FlightsPageUtils.*;

public class BookingFlightsPage extends PageObject {

    private WebDriverWait wait = new WebDriverWait(driver, 15);

    @FindBy(xpath = CHANGE_LANGUAGE_BUTTON_XPATH)
    private WebElement changeLanguage;

    @FindBy(xpath = SET_ENGLISH_LANGUAGE_BUTTON_XPATH)
    private WebElement setEnglishLanguage;

    @FindBy(xpath = CLOSE_POPUP_BUTTON_XPATH)
    private WebElement closePopup;

    @FindBy(xpath = GO_TO_FLIGHTS_SEARCH_TAB_XPATH)
    private WebElement goToFlightsSearchTab;

    @FindBy(xpath = SET_FLIGHT_TO_ONE_WAY_XPATH)
    private WebElement oneWayFlight;

    @FindBy(xpath = SET_FLIGHT_FROM_CITY_XPATH)
    private WebElement initialFlightPoint;

    @FindBy(xpath = SET_FLIGHT_TO_CITY_XPATH)
    private WebElement finalFlightPoint;

    @FindBy(xpath = CLICK_ON_CALENDAR_XPATH)
    private WebElement clickOnCalendar;

    @FindBy(xpath = FLIGHT_CALENDAR_FORWARD_CONTROLLER_XPATH)
    private WebElement forwardCalendarController;

    @FindBy(xpath = FLIGHT_DATE_BOOKING_XPATH)
    private WebElement flightDate;

    @FindBy(xpath = CLICK_TO_SEARCH_FLIGHTS_XPATH)
    private WebElement clickToSearchFlights;

    public BookingFlightsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isChangeLanguageInitialized(){
        return changeLanguage.isDisplayed();
    }

    public void changeLanguageToEnglish(){
        changeLanguage.click();
        setEnglishLanguage.click();
    }

    public void clickToClosePopup(){
        closePopup.click();
    }

    public void clickToSearchFlightTab(){
        goToFlightsSearchTab.click();
    }

    public void setFlightWays(){
        oneWayFlight.click();
    }

    public void inputInitialFlightCity(String initialCity){
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SET_FLIGHT_FROM_CITY_XPATH)));
        searchButton.click();
        this.initialFlightPoint.sendKeys(initialCity);
    }

    public void inputFinalFlightCity(String finalCity){
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SET_FLIGHT_TO_CITY_XPATH)));
        searchButton.click();
        this.finalFlightPoint.sendKeys(finalCity);
    }

    public void clickOnCalendar(){
        clickOnCalendar.click();
    }

    public void addOneMonthToCalendar(){
        forwardCalendarController.click();
    }

    public void findDateInFlightCalendar(int currentMonth, int flightMonth, String monthName){
        try{
            for (int i = 0; i <= flightMonth-currentMonth; i++){
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FLIGHT_CALENDAR_FORWARD_CONTROLLER_XPATH))).click();
            }
            System.out.println(monthName);

            /*
            String month = driver.findElement(By.xpath("//div[contains(@class,'month')]/div[1]")).getText();
            System.out.println(month);
            if(!month.equalsIgnoreCase(monthName)){
                do{
                    //addOneMonthToCalendar();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FLIGHT_CALENDAR_FORWARD_CONTROLLER_XPATH))).click();

                    // //*[@id="c9Fa2-201908"]/div/div[1]
                }while(!driver.findElement(By.xpath("//div[contains(@id,'201908')]/div/div[1]")).getText().trim().equalsIgnoreCase(monthName));
            }
            */
        } catch (NoSuchElementException exception){
            System.out.println("No Such Element Exception in findDateInFlightCalendar method");
        } catch (StaleElementReferenceException e){
            System.out.println("Stale Element Reference Exception in findDateInFlightCalendar method");
        }
    }

    public void setInitialFlightDate(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FLIGHT_DATE_BOOKING_XPATH))).click();
        //flightDate.click();
    }

    public void clickToSearchFlightsButton(){
        clickToSearchFlights.click();
    }
}
