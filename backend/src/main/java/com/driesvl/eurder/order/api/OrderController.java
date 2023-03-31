package com.driesvl.eurder.order.api;

import com.driesvl.eurder.authorization.repository.domain.Feature;
import com.driesvl.eurder.authorization.service.AuthorizationService;
import com.driesvl.eurder.order.api.dto.CreateOrderDTO;
import com.driesvl.eurder.order.api.dto.OrderDTO;
import com.driesvl.eurder.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "order")
public class OrderController {
    private final AuthorizationService authorizationService;
    private final OrderService orderService;

    @Autowired
    public OrderController(AuthorizationService authorizationService, OrderService orderService) {
        this.authorizationService = authorizationService;
        this.orderService = orderService;
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public OrderDTO addOrder(@RequestBody CreateOrderDTO order, @RequestHeader(value = HttpHeaders.AUTHORIZATION) String encodedAuthorization) {
        UUID userId = authorizationService.validateAuthorization(encodedAuthorization, Feature.PLACE_ORDER);
        return this.orderService.addOrder(userId, order);
    }
}
