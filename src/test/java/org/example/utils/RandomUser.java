package org.example.utils;

import com.github.javafaker.Faker;
import org.utils.UserModel;

public class RandomUser {

    public static UserModel generateRandomUser() {
        Faker faker = new Faker();

        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String eMail = fName + "." + lName + "@gmail.test";
        String password = faker.code().gtin8();

        return new UserModel("M", fName, lName, eMail, password);

    }
}
