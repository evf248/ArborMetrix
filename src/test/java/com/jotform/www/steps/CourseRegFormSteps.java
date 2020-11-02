package com.jotform.www.steps;

import com.jotform.www.drivers.Driver;
import com.jotform.www.pages.CourseRegFormPage;
import com.jotform.www.utilities.BrowserHelper;
import com.jotform.www.utilities.MockData;
import com.jotform.www.utilities.PropertiesReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class CourseRegFormSteps {

    private static MockData mockData = new MockData();
    private static CourseRegFormPage courseRegFormPage = new CourseRegFormPage();

    @Given("^user is on the Student Registration Form$")
    public void user_on_the_Student_Registration_Form() throws Throwable {
        Driver.getDriver().get(PropertiesReader.getProperty("studentRegFormUrl"));
        Driver.getDriver().switchTo().frame(courseRegFormPage.formPreviewArea);
    }

    @When("^user inputs firstName, middleName, lastName, email$")
    public void user_inputs_firstName_middleName_lastName_email() throws Throwable {
        assertTrue("First Name input field isn't displayed", courseRegFormPage.firstName.isDisplayed());
        courseRegFormPage.firstName.sendKeys(mockData.generateFirstName());
        assertTrue("Middle Name input field isn't displayed", courseRegFormPage.middleName.isDisplayed());
        courseRegFormPage.middleName.sendKeys(mockData.generateMiddleName());
        assertTrue("Last Name input field isn't displayed", courseRegFormPage.lastName.isDisplayed());
        courseRegFormPage.lastName.sendKeys(mockData.generateLastName());

        assertTrue("Email isn't displayed", courseRegFormPage.email.isDisplayed());
        courseRegFormPage.email.sendKeys(mockData.generateEmail());
    }

    @When("^select course \"([^\"]*)\"$")
    public void select_course(String course) {
        Select select = new Select(courseRegFormPage.coursesDropdown);
        select.selectByValue(course);
    }

    @When("^clicks submit button$")
    public void clicks_submit_button() {
        courseRegFormPage.submitButton.click();
    }

    @Then("^\"([^\"]*)\" message should be displayed$")
    public void message_should_be_displayed(String message) {

        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(courseRegFormPage.formPreviewArea);

        assertTrue("Thank you message is not displayed", courseRegFormPage.thankYouMessage.isDisplayed());
    }

    @Then("^user should be redirected to the updated Student Registration Form$")
    public void user_should_be_redirected_to_the_updated_Student_Registration_Form() {

        BrowserHelper.waitForVisibility(Driver.getDriver(), courseRegFormPage.studentRegFormHeader, 5);
        assertTrue("User is not on Student Registration Form", courseRegFormPage.studentRegFormHeader.isDisplayed());
    }
}
