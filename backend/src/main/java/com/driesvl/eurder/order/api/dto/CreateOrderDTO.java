package com.driesvl.eurder.order.api.dto;

import java.util.Map;
import java.util.UUID;

public record CreateOrderDTO(Map<UUID, Integer> items) {
}
