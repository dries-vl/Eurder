package com.driesvl.eurder.customer.repository.domain;

import com.driesvl.eurder.helper.repository.domain.User;

import java.util.Objects;

public class Customer {
    private final User user;
    private final Name name;
    private final String phoneNumber;
    private final Address address;

    public Customer(User user, Name name, String phoneNumber, Address address) {
        this.user = user;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public Name getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(user, customer.user) && Objects.equals(name, customer.name) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, name, phoneNumber, address);
    }
}
