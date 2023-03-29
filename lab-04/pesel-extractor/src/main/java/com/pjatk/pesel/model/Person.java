package com.pjatk.pesel.model;

import java.time.LocalDate;

public class Person {
    private String peselNumber;
    private String name;
    private String surname;
    private String gender;
    private LocalDate dateOfBirth;

    public Person(String pesel) {
        if(PeselValidator.isValid(pesel)){
            this.peselNumber = pesel;
            this.gender = PeselValidator.Gender(pesel);
            this.dateOfBirth = PeselValidator.DateOfBirth(pesel);
        }
    }

    public void setName(String jan) {
        this.name = jan;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String kowalski) {
        this.surname = kowalski;
    }

    public String getSurname() {
        return surname;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
