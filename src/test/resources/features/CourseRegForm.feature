@studentRegForm
Feature: Student Registration Form
  As a student
  I want to be able to register for a course
  So that it will be added to my course list

  Scenario:
    Given user is on the Student Registration Form
    When user inputs firstName, middleName, lastName, email
    And select course "Math 101"
    And clicks submit button
    Then "Thank you" message should be displayed
    And user should be redirected to the updated Student Registration Form


