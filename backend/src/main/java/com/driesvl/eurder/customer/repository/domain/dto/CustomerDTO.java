package com.driesvl.eurder.customer.repository.domain.dto;

public record CustomerDTO(String id, String email, NameDTO name, String phoneNumber, AddressDTO address) {
}
