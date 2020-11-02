package com.jotform.www.pages;

import com.jotform.www.drivers.Driver;
import com.jotform.www.utilities.MockData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseRegFormPage {

    WebDriver driver;
    public static final Logger LOGGER = LogManager.getLogger(CourseRegFormPage.class);
    private static MockData mockData = new MockData();

    public CourseRegFormPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#formPreviewArea")
    public WebElement formPreviewArea;

    @FindBy(css = "#header_1")
    public WebElement studentRegFormHeader;

    @FindBy(css = "#first_4")
    public WebElement firstName;

    @FindBy(css = "#middle_4")
    public WebElement middleName;

    @FindBy(css = "#last_4")
    public WebElement lastName;

    @FindBy(css = "#input_6")
    public WebElement email;

    @FindBy(css = "#input_46")
    public WebElement coursesDropdown;

    @FindBy(css = "#input_20")
    public WebElement submitButton;

    @FindBy(css = "h1[data-container=\"thank-you\"]")
    public WebElement thankYouMessage;

}
