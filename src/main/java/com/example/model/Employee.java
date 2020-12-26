package com.example.model;

import com.example.validatior.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name", nullable = false)
    @Size(min = 2, message = "First Name should have atleast 2 characters")
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false)
    @Size(min = 2, message = "Last Name should have atleast 2 characters")
    private String lastName;

    @NotBlank
    @Email
    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @NotBlank
    @Column(name = "passport_number", nullable = false)
    @Size(min = 2, message = "Passport should have atleast 2 characters")
    private String passportNumber;

    @NotNull
    @Column(name = "birth_day", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
