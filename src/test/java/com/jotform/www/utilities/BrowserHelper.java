package com.jotform.www.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserHelper {

    public static void waitForPageLoadComplete(WebDriver driver, int specifiedTimeout) {

        Wait<WebDriver> wait = new WebDriverWait(driver, specifiedTimeout);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeToWaitInSec) {

        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean isBlank(WebElement element) {

        if (element.getAttribute("value").isEmpty()) {
            return true;
        }
        return false;
    }

    public  static void jsClick(WebDriver driver,WebElement element){

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
