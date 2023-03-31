package com.driesvl.eurder.customer.repository;

import com.driesvl.eurder.customer.repository.domain.Customer;
import com.driesvl.eurder.authorization.repository.domain.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerDB {
    private final HashMap<User, Customer> customers = new HashMap<>(Collections.emptyMap());

    public Map<User, Customer> getCustomerDB() {
        return customers;
    }
}
