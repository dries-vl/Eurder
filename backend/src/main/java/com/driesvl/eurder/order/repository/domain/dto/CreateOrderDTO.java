package com.driesvl.eurder.order.repository.domain.dto;

import java.util.Map;
import java.util.UUID;

public record CreateOrderDTO(UUID customerId, Map<UUID, Integer> items) {
}
