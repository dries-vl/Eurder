package com.driesvl.eurder.customer.repository.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public final class CreateCustomerDTO {
    @NotBlank(message = "Email is mandatory")
    private final String email;
    @NotBlank(message = "Password is mandatory")
    private final String password;
    @NotBlank(message = "Firstname is mandatory")
    private final String firstName;
    @NotBlank(message = "Lastname is mandatory")
    private final String lastName;
    @NotBlank(message = "Phone number is mandatory")
    private final String phoneNumber;
    @NotNull(message = "Address is mandatory")
    @Valid
    private final AddressDTO address;

    public CreateCustomerDTO(String email, String password, String firstName, String lastName, String phoneNumber, AddressDTO address) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public AddressDTO address() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CreateCustomerDTO) obj;
        return Objects.equals(this.email, that.email) &&
                Objects.equals(this.password, that.password) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.phoneNumber, that.phoneNumber) &&
                Objects.equals(this.address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, firstName, lastName, phoneNumber, address);
    }

    @Override
    public String toString() {
        return "CreateCustomerDTO[" +
                "email=" + email + ", " +
                "password=" + password + ", " +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "phoneNumber=" + phoneNumber + ", " +
                "address=" + address + ']';
    }

}
