package com.driesvl.eurder.order.repository;

import com.driesvl.eurder.exceptions.types.IdAlreadyTakenException;
import com.driesvl.eurder.order.repository.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

@Repository
public class OrderRepository {
    private final OrderDB orderDB;

    public OrderRepository(OrderDB orderDB) {
        this.orderDB = orderDB;
    }

    public void addOrder(Order order) {
        throwIfIdAlreadyTaken(order.getId());
        getOrderDB().put(order.getId(), order);
    }

    private Map<UUID, Order> getOrderDB() {
        return orderDB.getOrderDB();
    }

    private void throwIfIdAlreadyTaken(UUID uuid) {
        if (getOrderDB().containsKey(uuid)) {
            throw new IdAlreadyTakenException(this.getClass().getSimpleName(), "Id already taken");
        }
    }
}
