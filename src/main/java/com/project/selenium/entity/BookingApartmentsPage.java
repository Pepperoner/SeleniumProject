package com.project.selenium.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

import static com.project.selenium.util.CommonUtils.*;
import static com.project.selenium.util.ApartmentsPageUtils.*;

public class BookingApartmentsPage extends PageObject {

    @FindBy(xpath = CHANGE_LANGUAGE_BUTTON_XPATH)
    private WebElement changeLanguage;

    @FindBy(xpath = SET_ENGLISH_LANGUAGE_BUTTON_XPATH)
    private WebElement setEnglishLanguage;

    @FindBy(xpath = CITY_SEARCHBOX_OF_APARTMENTS_XPATH)
    private WebElement city;

    @FindBy(className = CALENDAR_BUTTON_XPATH)
    private WebElement calendar;

    @FindBy(xpath = CALENDAR_DROPBOX_XPATH)
    private WebElement calendarXpath;

    @FindBy(xpath = APS_CALENDAR_FORWARD_CONTROLLER_XPATH)
    private WebElement forwardControllerOfCalendar;

    @FindBy(xpath = APS_BOOKING_START_DATE_XPATH)
    private WebElement start_Date;

    @FindBy(xpath = APS_BOOKING_END_DATE_XPATH)
    private WebElement end_Date;

    @FindBy(xpath = SEARCH_APS_BUTTON_XPATH)
    private WebElement searchAppsButton;

    @FindBy(xpath = LOCATION_OF_SEARCHED_APS)
    private WebElement location;

    @FindBy(xpath = START_DATE_APARTMENT_VALIDATION_XPATH)
    private WebElement startDateValidation;

    @FindBy(xpath = END_DATE_APARTMENT_VALIDATION_XPATH)
    private WebElement endDateValidation;

    public BookingApartmentsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isChangeLanguageInitialized(){
        return changeLanguage.isDisplayed();
    }

    public boolean isInputFieldInitialized(){
        return city.isDisplayed();
    }

    public boolean isCalendarInitialized(){
        return calendarXpath.isDisplayed();
    }

    public boolean isLocationInitialized(){
        return location.isDisplayed();
    }

    public void changeLanguageToEnglish(){
        changeLanguage.click();
        setEnglishLanguage.click();
    }

    public void findDateInApsCalendar(String monthName) {
        try{
            String month= driver.findElement(By.xpath(APS_SEPTEMBER_2019_CALENDAR_XPATH)).getText();
            if(!month.equalsIgnoreCase(monthName)){
                do{
                    addOneMonthToCalendar();
                }while(!driver.findElement(By.xpath(APS_SEPTEMBER_2019_CALENDAR_XPATH)).getText().trim().equalsIgnoreCase(monthName));
            }
        } catch (NoSuchElementException exception){
            System.out.println("No Such Element Exception in findDateInApsCalendar method");
        }
    }

    public void inputCityNameForSearch(String city){
        this.city.sendKeys(city);
    }

    public void clickOnCalendar(){
        calendar.click();
    }

    private void addOneMonthToCalendar(){
        forwardControllerOfCalendar.click();
    }

    public void setStart_Date(){
        start_Date.click();
    }

    public void setEnd_Date(){
        end_Date.click();
    }

    public void submit(){
        searchAppsButton.click();
    }

    private List<WebElement> getListOfLocations(){
        try{
            List<WebElement> webElements = new ArrayList<>();
            for (int i = 1; i <= AMOUNT_OF_DIVS_IN_FRONTEND; i++) {
                 List<WebElement> webElementList = driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[3]" +
                         "/div[1]/div[1]/div[5]/div[3]/div[1]/div[1]/div[" + i + "]/div[2]/div[1]/div[1]/div[1]/a[2]"));
                 webElements.addAll(webElementList);
            }
            return webElements;
        } catch (NoSuchElementException exception){
            System.out.println("No Such Element Exception in getListOfLocations");
        }
        return new ArrayList<>();
    }

    public void validateCityLocation(String cityName){
        List<WebElement> list = getListOfLocations();
        int count = 0;
        for (WebElement webElement : list) {
            if (webElement.getText().contains(cityName)){
                count += 1;
            }
        }
        System.out.println("Amount of apartments in '"+cityName+"' is "+count+" out of "+list.size());
    }

    public boolean validateSearchByStartDate(String startDate){
        return startDateValidation.getText().contains(startDate);
    }

    public boolean validateSearchByEndDate(String endDate){
        return endDateValidation.getText().contains(endDate);
    }
}
