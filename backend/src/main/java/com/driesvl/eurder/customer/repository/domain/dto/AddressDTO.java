package com.driesvl.eurder.customer.repository.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(@NotBlank(message = "Street is mandatory") String street,
                         @NotBlank(message = "Street number is mandatory") String streetNumber,
                         @NotBlank(message = "City is mandatory") String city) {

}
