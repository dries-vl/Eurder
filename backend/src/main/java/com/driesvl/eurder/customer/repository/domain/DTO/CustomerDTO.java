package com.driesvl.eurder.customer.repository.domain.DTO;

public record CustomerDTO(String id, String email, NameDTO name, String phoneNumber, AddressDTO address) {
}
