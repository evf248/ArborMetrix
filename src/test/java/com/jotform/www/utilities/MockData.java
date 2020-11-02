package com.jotform.www.utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class MockData {
    private FakeValuesService fakeValuesService =
            new FakeValuesService(new Locale("en-US"), new RandomService());
    private static String firstName;
    private static String middleName;
    private static String lastName;
    private static String email;
    private static String dob;

    public String generateFirstName() {
        firstName = fakeValuesService.bothify(new Faker().name().firstName());
        return firstName;
    }

    public String generateMiddleName() {
        middleName = fakeValuesService.bothify(new Faker().name().firstName());
        return middleName;
    }

    public String generateLastName() {
        lastName = fakeValuesService.bothify(new Faker().name().lastName());
        return lastName;
    }

    public String generateDob() {

        LocalDate from = LocalDate.of(1930, 1, 1);
        LocalDate to = LocalDate.of(2000, 1, 1);
        long days = from.until(to, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        LocalDate randomDate = from.plusDays(randomDays);

        dob = randomDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return dob;
    }

    public String generateEmail() {
        email = fakeValuesService.bothify(new Faker().name().firstName() + "####@gmail.com");
        return email;
    }
}
