package org.makaia.fileRecordValidator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CsvFileRecord implements VerifiableFileRecord {

    private String index;
    private String userId;
    private String firstName;
    private String lastName;
    private String sex;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String jobTitle;

    public CsvFileRecord(String index, String userId, String firstName, String
            lastName, String sex, String email, String phone, String dateOfBirth,
                         String jobTitle)
    {
        this.index = index;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.jobTitle = jobTitle;
    }

    public String getIndex() {
        return index;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public boolean isValidEmail(){
        String regx = "^[A-Za-z]+[A-Za-z0-9+_.-]*@[A-Za-z]+(\\.[A-Za-z0-9]+)*" +
                "(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regx);
        return pattern.matcher(this.email).matches();
    }

    public boolean isValidJobTitle(){
        ArrayList<String> validateJobs = new ArrayList<>(
                Arrays.asList("haematologist", "phytotherapist","building " +
                        "surveyor", "insurance account manager", "educational" +
                        " psychologist"));
        for(String validateJob: validateJobs){
            if(this.jobTitle.toLowerCase().contains(validateJob)){
                return true;
            }
        }
        return false;
    }

    public boolean isValidDateOfBirth(){
        LocalDate lineDate = LocalDate.parse(this.dateOfBirth);
        LocalDate minDate = LocalDate.of(1980,01,01);
        int comparison = lineDate.compareTo(minDate);
        return comparison > 0;
    }

    public boolean isAValidFileRecord() {
        return isValidEmail() && isValidDateOfBirth()
                && isValidJobTitle();
    }
}