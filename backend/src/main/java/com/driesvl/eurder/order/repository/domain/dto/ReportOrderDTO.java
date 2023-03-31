package com.driesvl.eurder.order.repository.domain.dto;

import java.util.List;

public record ReportOrderDTO(String id, List<ReportItemGroupDTO> itemGroups, double totalPrice) {
}
