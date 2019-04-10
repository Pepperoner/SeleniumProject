package com.project.selenium.util;

public class ApartmentsPageUtils {

    public static final String CITY_SEARCHBOX_OF_APARTMENTS_XPATH = "//input[@id='ss']";
    public static final String CALENDAR_BUTTON_XPATH = "sb-date-field__icon";
    public static final String CALENDAR_DROPBOX_XPATH = "//div[contains(@class,'bui-calendar__content')]";
    public static final String APS_CALENDAR_FORWARD_CONTROLLER_XPATH = "//div[contains(@class,'bui-calendar__control bui-calendar__control--next')]";
    public static final String APS_BOOKING_START_DATE_XPATH = "//div[contains(@class,'bui-calendar__content')]//div[2]//table[1]//tbody[1]//tr[2]//td[7]";
    public static final String APS_BOOKING_END_DATE_XPATH = "//div[contains(@class,'xpi__content__wrapper xpi__content__wrappergray')]//tbody//tr[7]//td[1]";
    public static final String SEARCH_APS_BUTTON_XPATH = "//div[contains(@class,'sb-searchbox-submit-col -submit-button')]//button[contains(@type,'submit')]";
    public static final String APS_SEPTEMBER_2019_CALENDAR_XPATH = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]";

    public static final String START_DATE_APARTMENT_VALIDATION_XPATH = "//div[contains(text(),'Sunday, September 1, 2019')]";
    public static final String END_DATE_APARTMENT_VALIDATION_XPATH = "//div[contains(text(),'Monday, September 30, 2019')]";

    public static final String LOCATION_OF_SEARCHED_APS = "/html[1]/body[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[5]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[2]";
    public static final int AMOUNT_OF_DIVS_IN_FRONTEND = 60;
}
