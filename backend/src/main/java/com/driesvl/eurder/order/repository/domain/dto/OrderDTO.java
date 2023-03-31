package com.driesvl.eurder.order.repository.domain.dto;

import java.util.List;

public record OrderDTO(String id, List<ItemGroupDTO> itemGroups, double totalPrice) {
}
