package com.driesvl.eurder.item.repository.domain;

import java.util.Objects;
import java.util.UUID;

public class Item {
    private final UUID id;
    private final String name;
    private final String description;
    private final double price;
    private final long amount;

    public Item(String name, String description, double price, long amount) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && Objects.equals(name, item.name) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}
