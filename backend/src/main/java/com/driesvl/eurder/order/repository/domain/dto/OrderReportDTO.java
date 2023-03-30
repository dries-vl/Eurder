package com.driesvl.eurder.order.repository.domain.dto;

import java.util.List;

public record OrderReportDTO(List<ItemGroupDTO> itemGroups) {
}
