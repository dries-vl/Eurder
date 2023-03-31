package com.driesvl.eurder.item.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public final class CreateItemDTO {
    @NotBlank(message = "Name is mandatory")
    private final String name;
    @NotBlank(message = "Description is mandatory")
    private final String description;
    @NotNull(message = "Price is mandatory")
    private final double price;
    @NotNull(message = "Amount is mandatory")
    private final long amount;

    public CreateItemDTO(String name, String description, double price, long amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public double price() {
        return price;
    }

    public long amount() {
        return amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CreateItemDTO) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Double.doubleToLongBits(this.price) == Double.doubleToLongBits(that.price) &&
                this.amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, amount);
    }

    @Override
    public String toString() {
        return "CreateItemDTO[" +
                "name=" + name + ", " +
                "description=" + description + ", " +
                "price=" + price + ", " +
                "amount=" + amount + ']';
    }

}
