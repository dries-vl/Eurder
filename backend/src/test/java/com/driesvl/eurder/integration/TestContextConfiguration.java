package com.driesvl.eurder.integration;

import com.driesvl.eurder.authorization.repository.UserDB;
import com.driesvl.eurder.authorization.repository.UserRepository;
import com.driesvl.eurder.customer.repository.CustomerDB;
import com.driesvl.eurder.customer.service.CustomerMapper;
import com.driesvl.eurder.customer.repository.CustomerRepository;
import com.driesvl.eurder.customer.service.CustomerService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestContextConfiguration {
    @Bean
    public static CustomerDB customerDB() {
        return new CustomerDB();
    }
    @Bean
    public static UserDB userDB() {
        return new UserDB();
    }
    @Bean
    public static CustomerMapper customerMapper() {
        return new CustomerMapper();
    }
    @Bean
    public static UserRepository userRepository() {
        return new UserRepository(userDB());
    }
    @Bean
    public static CustomerRepository customerRepository() {
        return new CustomerRepository(customerDB());
    }
    @Bean
    public static CustomerService customerService() {
        return new CustomerService(customerRepository(), userRepository(), customerMapper());
    }
}
