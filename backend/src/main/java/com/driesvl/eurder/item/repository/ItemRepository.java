package com.driesvl.eurder.item.repository;

import com.driesvl.eurder.exceptions.types.AlreadyExistsException;
import com.driesvl.eurder.exceptions.types.IdAlreadyTakenException;
import com.driesvl.eurder.exceptions.types.InvalidUserIdException;
import com.driesvl.eurder.item.repository.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ItemRepository {
    private final ItemDB itemDB;

    @Autowired
    public ItemRepository(ItemDB itemDB) {
        this.itemDB = itemDB;
    }

    public void addItem(Item item) {
        throwIfIdAlreadyTaken(item.getId());
        throwIfItemAlreadyExists(item);
        getItemDB().put(item.getId(), item);
    }

    public Item getItem(UUID id) {
        throwIfNonExistingId(id);
        return getItemDB().get(id);
    }

    public List<Item> getAllItems() {
        return getItemDB().values().stream().toList();
    }

    private Map<UUID, Item> getItemDB() {
        return this.itemDB.getItemDB();
    }

    private void throwIfNonExistingId(UUID id) {
        if (!getItemDB().containsKey(id)) {
            throw new InvalidUserIdException(this.getClass().getSimpleName(), "Id does not exist");
        }
    }

    private void throwIfIdAlreadyTaken(UUID uuid) {
        if (getItemDB().containsKey(uuid)) {
            throw new IdAlreadyTakenException(this.getClass().getSimpleName(), "Id already taken");
        }
    }

    private void throwIfItemAlreadyExists(Item item) {
        if (identicalItemExists(item)) {
            throw new AlreadyExistsException(this.getClass().getSimpleName(), "Identical item already exists");
        }
    }

    private boolean identicalItemExists(Item item) {
        return getItemDB().values()
                .stream()
                .anyMatch(streamItem -> streamItem.equals(item));
    }
}
