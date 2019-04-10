package com.project.selenium.config;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppConfig {

    protected static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        String driverPath = "E:\\Selenium 3\\chromedriver.exe";
        String driverName = "webdriver.chrome.driver";
        System.setProperty(driverName, driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void cleanUp(){
//        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void tearDown(){
//        driver.close();
    }
}
