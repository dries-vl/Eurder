package com.driesvl.eurder.customer.api;

import com.driesvl.eurder.customer.repository.domain.dto.CustomerDTO;
import com.driesvl.eurder.customer.service.CustomerService;
import com.driesvl.eurder.helper.repository.domain.Feature;
import com.driesvl.eurder.helper.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "customer")
public class CustomerController {
    private final CustomerService customerService;
    private final AuthorizationService authorizationService;
    @Autowired
    public CustomerController(CustomerService customerService, AuthorizationService authorizationService) {
        this.customerService = customerService;
        this.authorizationService = authorizationService;
    }

    @GetMapping(path = "", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CustomerDTO> getsAllCustomers(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String encodedAuthorization) {
        authorizationService.validateAuthorization(encodedAuthorization, Feature.GET_ALL_CUSTOMERS);
        return this.customerService.getAllCustomers();
    }
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerDTO getsACustomerById(@PathVariable String id, @RequestHeader(value = HttpHeaders.AUTHORIZATION) String encodedAuthorization) {
        authorizationService.validateAuthorization(encodedAuthorization, Feature.GET_ALL_CUSTOMERS);
        return this.customerService.getCustomerById(id);
    }
}
