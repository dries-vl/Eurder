package com.driesvl.eurder.order.api.dto;

import java.util.List;

public record OrderDTO(String id, List<ItemGroupDTO> itemGroups, double totalPrice) {
}
