package com.realdolmen.course.controller;

import com.realdolmen.ex.domain.Ticket;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ConversationScoped
public class Passenger implements Serializable{

    @Target({ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = EmailConstraintValidator.class)
    public @interface Email {
        String message() default "Faulty email address!";
        Class<?>[] groups() default {};
        Class<? extends Payload> [] payload() default {};
    }

    private String ssn;

    @Size(min = 2, max = 75)
    private String firstName;
    @Size(min = 2, max = 20)
    private String lastName;

    @Email
    private String email;

    @Past
    private Date dateOfBirth;

    private Ticket ticket = new Ticket();

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
