package com.driesvl.eurder.order.repository;

import com.driesvl.eurder.order.repository.domain.Order;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class OrderDB {
    private final HashMap<UUID, Order> orders = new HashMap<>(Collections.emptyMap());

    public Map<UUID, Order> getOrderDB() {
        return orders;
    }
}
