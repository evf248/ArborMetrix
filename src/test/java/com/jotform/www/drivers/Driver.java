package com.jotform.www.drivers;

import com.jotform.www.utilities.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;
    private static String browser = System.getProperty("browser");

    private Driver(){}

    public static WebDriver getDriver() {

        boolean headless = Boolean.parseBoolean(PropertiesReader.getProperty("headless"));

        if (driver == null) {

            String s = PropertiesReader.getProperty("browser").toLowerCase();

            if ("chrome".equals(s)) {
                driver = ChromeWebDriver.createChromeDriver(headless);
            } else if ("firefox".equals(s)) {

            } else {
                driver = ChromeWebDriver.createChromeDriver(headless);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver == null) return;
        try {
            driver.close();
            driver.quit();
            driver = null;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
