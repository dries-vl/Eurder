package com.driesvl.eurder.item.repository;

import com.driesvl.eurder.item.repository.domain.Item;
import com.driesvl.eurder.item.repository.domain.dto.CreateItemDTO;
import com.driesvl.eurder.item.repository.domain.dto.ItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemMapper {
    public Item fromCreateDTO(CreateItemDTO createItemDTO) {
        return new Item(createItemDTO.name(), createItemDTO.description(), createItemDTO.price(), createItemDTO.amount());
    }

    private ItemDTO toDTO(Item item) {
        return new ItemDTO(item.getId().toString(), item.getName(), item.getDescription(), item.getPrice(), item.getAmount());
    }

    public List<ItemDTO> toDTO(List<Item> allItems) {
        return allItems.stream().map(this::toDTO).toList();
    }
}
