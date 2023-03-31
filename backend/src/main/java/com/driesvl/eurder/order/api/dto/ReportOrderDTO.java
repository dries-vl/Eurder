package com.driesvl.eurder.order.api.dto;

import java.util.List;

public record ReportOrderDTO(String id, List<ReportItemGroupDTO> itemGroups, double totalPrice) {
}
