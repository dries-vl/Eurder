package com.driesvl.eurder.order.api.dto;

public record ItemGroupDTO(String item, double price, long amount, String shippingDate) {
}
