package com.driesvl.eurder.order.repository.domain;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private final UUID itemId;
    private final double priceAtTimeOfPurchase;
    private final int amount;
    private final LocalDate shippingDate;

    public ItemGroup(UUID itemId, double priceAtTimeOfPurchase, int amount, LocalDate shippingDate) {
        this.itemId = itemId;
        this.priceAtTimeOfPurchase = priceAtTimeOfPurchase;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public UUID getItemId() {
        return itemId;
    }

    public double getPriceAtTimeOfPurchase() {
        return priceAtTimeOfPurchase;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
