package com.driesvl.eurder.item.repository;

import com.driesvl.eurder.item.repository.domain.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ItemDB {
    private static final UUID ITEM_1_ID = UUID.fromString("d7b17e43-e76f-4d63-9b05-3f4268b16a33");
    private static final UUID ITEM_2_ID = UUID.fromString("40a380d4-0b54-4442-ac20-bce13ed83844");
    private static final Item ITEM_1 = Item.createItemWithExistingId(
            ITEM_1_ID,
            "Guan-Dao",
            "The weapon used by the Three-Kingdoms hero Guan Yu",
            15.99,
            1);
    private static final Item ITEM_2 = Item.createItemWithExistingId(
            ITEM_2_ID,
            "Kong-Ming Lantern",
            "A lantern shielded from the elements, invented by the legendary Zhuge Liang aka Kong-Ming",
            4.95,
            3);
    private final HashMap<UUID, Item> items = new HashMap<>(Map.of(
            ITEM_1_ID, ITEM_1,
            ITEM_2_ID, ITEM_2
    ));

    public Map<UUID, Item> getItemDB() {
        return items;
    }
}
