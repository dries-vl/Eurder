package com.driesvl.eurder.customer.repository.domain.DTO;

public record CreateCustomerDTO(String email, String password, String firstName, String lastName, String phoneNumber, AddressDTO address) {
}
