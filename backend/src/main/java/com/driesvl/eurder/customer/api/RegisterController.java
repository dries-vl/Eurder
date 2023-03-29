package com.driesvl.eurder.customer.api;

import com.driesvl.eurder.customer.repository.domain.dto.CreateCustomerDTO;
import com.driesvl.eurder.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "register")
public class RegisterController {
    private final CustomerService customerService;
    @Autowired
    public RegisterController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String registerUser(@RequestBody CreateCustomerDTO createCustomerDTO) {
        return customerService.addCustomer(createCustomerDTO);
    }
}
