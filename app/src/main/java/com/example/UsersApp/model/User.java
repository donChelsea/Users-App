package com.example.UsersApp.model;


public class User {

    private String name;
    private String phoneNumber;
    private String email;
    private Address address;

    public User() {
    }

    public User(String name, String phoneNumber, String email, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address.getStreet() +
                ", " + address.getSuite() +
                ", " + address.getCity() +
                ", " + address.getZipcode();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
