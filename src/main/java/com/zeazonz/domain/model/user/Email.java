package com.zeazonz.domain.model.user;

import com.zeazonz.exception.UserInvalidException;
import org.apache.commons.validator.routines.EmailValidator;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Email {

    @Column(name  = "email")
    private String email;

    public Email(){}

    Email(String email){
        EmailValidator emailValidator = EmailValidator.getInstance();
        if(!emailValidator.isValid(email)){
            throw new UserInvalidException("Invalid email...");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
