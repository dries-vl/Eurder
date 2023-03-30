package com.driesvl.eurder.order.repository.domain;

import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final UUID customerId;
    private final List<ItemGroup> itemGroups;

    public Order(UUID customerId, List<ItemGroup> itemGroups) {
        this.id = UUID.randomUUID();
        this.itemGroups = itemGroups;
        this.customerId = customerId;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getId() {
        return id;
    }
}
