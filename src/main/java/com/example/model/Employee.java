package com.example.model;

import com.example.validatior.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    @Size(min = 2, message = "First Name should have atleast 2 characters")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    @Size(min = 2, message = "Last Name should have atleast 2 characters")
    private String lastName;

    @NotBlank
    @Email
    @Column(name = "email_address")
    private String emailAddress;

    @NotBlank
    @Column(name = "passport_number")
    @Size(min = 2, message = "Passport should have atleast 2 characters")
    private String passportNumber;

    @NotNull
    @Column(name = "birth_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

}
