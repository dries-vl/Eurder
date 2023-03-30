package com.driesvl.eurder.order.repository.domain.dto;

import java.time.LocalDate;

public record ItemGroupDTO(String item, double price, long amount, LocalDate shippingDate) {
}
