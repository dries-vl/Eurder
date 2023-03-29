package com.driesvl.eurder.item.repository;

import com.driesvl.eurder.item.repository.domain.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ItemDB {
    private static final Item ITEM_1 = new Item("Guan-Dao", "The weapon used by the Three-Kingdoms hero Guan Yu", 15.99, 1);
    private static final Item ITEM_2 = new Item("Kong-Ming Lantern", "A lantern shielded from the elements, invented by the legendary Zhuge Liang aka Kong-Ming", 4.95, 3);
    private static final UUID ITEM_1_ID = ITEM_1.getId();
    private static final UUID ITEM_2_ID = ITEM_2.getId();
    private final HashMap<UUID, Item> items = new HashMap<>(Map.of(
            ITEM_1_ID, ITEM_1,
            ITEM_2_ID, ITEM_2
    ));

    public Map<UUID, Item> getItemDB() {
        return items;
    }
}
