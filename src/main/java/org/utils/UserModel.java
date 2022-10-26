package org.utils;


public class UserModel {
    private final String gender;
    private final String fName;
    private final String lName;
    private final String eMail;
    private final String password;

    public UserModel(String gender, String fName, String lName, String eMail, String password) {
        this.gender = gender;
        this.fName = fName;
        this.lName = lName;
        this.eMail = eMail;
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }
}
