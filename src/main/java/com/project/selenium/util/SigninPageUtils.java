package com.project.selenium.util;

public class SigninPageUtils {

    public static final String SIGNIN_BUTTON_XPATH = "/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]";
    public static final String SIGNIN_TAB_BUTTON_XPATH = "//div[contains(@class,'user_access_signup_menu_tab form-tabs user_access_section_trigger')]";

    public static final String LOGIN_FIELD_FOR_SIGNIN = "username";
    public static final String PASSWORD_FIELD_FOR_SIGNIN = "password";
    public static final String SUBMIT_SIGNIN_BUTTON_XPATH = "//form[contains(@class,'user_access_form js-user-access-form--signin" +
            " form-subsection')]//input[contains(@value,'Sign in')]";

    public static final String SET_PROFILE_FIRST_NAME_XPATH = "//input[@placeholder='First Name']";
    public static final String SET_PROFILE_LAST_NAME_XPATH = "//input[@id='wl252-lastname']";
    public static final String SET_PROFILE_NAME_CONTINUE_BUTTON_XPATH = "//form[@id='wl252-onboard-name']//button[@type='submit'][contains(text(),'Continue')]";
    public static final String SET_PROFILE_NAME_SKIP_BUTTON_XPATH = "//form[@id='wl252-onboard-stars']//a[@class='wl252-modal__skip'][contains(text(),'Skip')]";
    public static final String SET_PROFILE_NAME_OK_BUTTON_XPATH = "//a[@class='wl252-btn wl252-btn-done']";
    public static final String GO_TO_PROFILE_DROPBOX_XPATH = "//li[@id='current_account']//a[contains(@class,'popover_trigger')]";
    public static final String GO_TO_PROFILE_DASHBOARD_XPATH = "//a[contains(text(),'My Dashboard')]";
    public static final String GET_PROFILE_FULL_NAME_FROM_DASHBOARD_XPATH = "//div[@class='acc-profile-card__user-name']";
}
