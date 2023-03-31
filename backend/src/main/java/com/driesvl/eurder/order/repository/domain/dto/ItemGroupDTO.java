package com.driesvl.eurder.order.repository.domain.dto;

public record ItemGroupDTO(String item, double price, long amount, String shippingDate) {
}
