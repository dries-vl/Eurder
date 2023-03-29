package com.driesvl.eurder.item.service;

import com.driesvl.eurder.item.repository.ItemMapper;
import com.driesvl.eurder.item.repository.ItemRepository;
import com.driesvl.eurder.item.repository.domain.Item;
import com.driesvl.eurder.item.repository.domain.dto.CreateItemDTO;
import com.driesvl.eurder.item.repository.domain.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public String addItem(CreateItemDTO createItemDTO) {
        Item item = itemMapper.fromCreateDTO(createItemDTO);
        this.itemRepository.addItem(item);
        return item.getId().toString();
    }

    public List<ItemDTO> getAllItems() {
        return itemMapper.toDTO(itemRepository.getAllItems());
    }
}
