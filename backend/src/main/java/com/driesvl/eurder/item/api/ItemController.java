package com.driesvl.eurder.item.api;

import com.driesvl.eurder.authorization.repository.domain.Feature;
import com.driesvl.eurder.authorization.service.AuthorizationService;
import com.driesvl.eurder.item.repository.domain.dto.CreateItemDTO;
import com.driesvl.eurder.item.repository.domain.dto.ItemDTO;
import com.driesvl.eurder.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "item")
public class ItemController {
    private final ItemService itemService;
    private final AuthorizationService authorizationService;

    @Autowired
    public ItemController(ItemService itemService, AuthorizationService authorizationService) {
        this.itemService = itemService;
        this.authorizationService = authorizationService;
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public String addItem(@RequestBody CreateItemDTO item, @RequestHeader(value = HttpHeaders.AUTHORIZATION) String encodedAuthorization) {
        authorizationService.validateAuthorization(encodedAuthorization, Feature.ADD_ITEM);
        return this.itemService.addItem(item);
    }

    @GetMapping(path = "", produces = "application/json")
    public List<ItemDTO> getItems(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String encodedAuthorization) {
        authorizationService.validateAuthorization(encodedAuthorization, Feature.GET_ALL_ITEMS_BY_URGENCY);
        return this.itemService.getAllItems();
    }

}
