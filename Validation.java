package FORM;

import java.util.ArrayList;
import java.util.List;
public class Validation {
    public List<String> validateRegistration(Student student) {
        ArrayList<String> err = new ArrayList<String>();
        if (student.getName().isEmpty()) {
            err.add("Name can not be empty");
        } else if (student.getName().length() < 4) {
            err.add("Name is too short");
        } else if (student.getName().length() > 50) {
            err.add("Name is too long");
        } else if (!isString(student.getName())) {
            err.add("Only characters allowed in name");
        }
        if (student.getMailId().isEmpty()) {
            err.add("MailId can not be empty");
        } else if (!isValidEmailAddress(student.getMailId())) {
            err.add("MailId is not valid");
        }
        if (student.getMobileNo().isEmpty()) {
            err.add("Mobile Number can not be empty");
        } else if (student.getMobileNo().length() != 10) {
            err.add("Mobile Number must be 10 digit long");
        } else if (!isDigit(student.getMobileNo())) {
            err.add("Mobile Numbers must have only digits");
        }
        if (student.getPassword().isEmpty()) {
            err.add("Password not be empty");
        } else if (student.getPassword().length() < 6) {
            err.add("Password is too short");
        } else if (student.getPassword().length() > 10) {
            err.add("Password is too long");
        } else if (!isStrongPassword(student.getPassword())) {
            err.add("Enter Strong Password");
        }
        if (student.getRePassword().isEmpty()) {
            err.add("Re Password can not be empty");
        } else if (student.getRePassword().length() < 6) {
            err.add("Re Password is too short");
        } else if (student.getRePassword().length() > 10) {
            err.add("Re Password is too long");
        }
        if (!student.getPassword().equals(student.getRePassword())) {
            err.add("Both passwords are not matching");
        }
        return err;
    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    //https://stackoverflow.com/a/15806080/876739
    public boolean isString(String name) {
        String ePattern = "^[\\p{L} '-]+$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(name);
        return m.matches();
    }
    //https://stackoverflow.com/a/3802238/876739
    public boolean isStrongPassword(String text) {
        String ePattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(text);
        return m.matches();
    }
    //https://stackoverflow.com/a/34253764/876739
    public boolean isDigit(String mobileNo) {
        boolean digits = mobileNo.chars().allMatch(Character::isDigit);
        return digits;
    }

}