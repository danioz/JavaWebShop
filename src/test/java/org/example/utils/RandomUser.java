package org.example.utils;

import com.github.javafaker.Faker;
import org.utils.UserModel;

public class RandomUser {

    public static UserModel generateRandomUser() {
        Faker faker = new Faker();

        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String eMail = faker.internet().emailAddress();
        String password = faker.internet().password();

        return new UserModel("M", fName, lName, eMail, password);

    }
}
