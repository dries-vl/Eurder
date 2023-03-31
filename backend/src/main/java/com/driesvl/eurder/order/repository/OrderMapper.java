package com.driesvl.eurder.order.repository;

import com.driesvl.eurder.order.repository.domain.ItemGroup;
import com.driesvl.eurder.order.repository.domain.Order;
import com.driesvl.eurder.order.repository.domain.dto.ItemGroupDTO;
import com.driesvl.eurder.order.repository.domain.dto.ReportItemGroupDTO;
import com.driesvl.eurder.order.repository.domain.dto.ReportOrderDTO;
import com.driesvl.eurder.order.repository.domain.dto.OrderDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private ItemGroupDTO toResultDTO(ItemGroup itemGroup) {
        return new ItemGroupDTO(
                itemGroup.getItemName(),
                itemGroup.getPriceAtTimeOfPurchase(),
                itemGroup.getAmount(),
                itemGroup.getShippingDate().toString());
    }
    private ReportItemGroupDTO toReportDTO(ItemGroup itemGroup) {
        return new ReportItemGroupDTO(
                itemGroup.getItemName(),
                itemGroup.getPriceAtTimeOfPurchase(),
                itemGroup.getAmount());
    }

    public OrderDTO toResultDTO(Order order, double totalPrice) {
        return new OrderDTO(
                order.getId().toString(),
                order.getItemGroups().stream().map(this::toResultDTO).toList(),
                totalPrice);
    }

    public ReportOrderDTO toDTO(Order order, double totalPrice) {
        return new ReportOrderDTO(
                order.getId().toString(),
                order.getItemGroups().stream().map(this::toReportDTO).toList(),
                totalPrice);
    }
}
