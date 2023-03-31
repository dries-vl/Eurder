package com.driesvl.eurder.customer.api.dto;

public record CustomerDTO(String id, String email, NameDTO name, String phoneNumber, AddressDTO address) {
}
