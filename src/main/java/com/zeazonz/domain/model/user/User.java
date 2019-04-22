package com.zeazonz.domain.model.user;

import com.google.common.base.Preconditions;
import com.zeazonz.exception.UserInvalidException;

import javax.persistence.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name="account_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name  = "name")
    private String name;

    @Embedded
    private Address address;

    @Embedded
    private Email email;

    /**
     * must contain at least 1 number and 1 lower & upper case letters , must have at least 6 characters
     * */
    @Column(name  = "password")
    private String password;

    public User() {
    }

    public User(String name, Address address, Email email, String password)  throws UserInvalidException{
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(address);
        Preconditions.checkNotNull(email);
        Preconditions.checkNotNull(password);

        if(!isValidPassword(password)){
            throw new UserInvalidException("Password must contain at least 1 digit, at least 1 lower & upper case letters , must have at least 6 characters");
        }

        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    private boolean isValidPassword(String password){
        Pattern pattern= Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,})");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
