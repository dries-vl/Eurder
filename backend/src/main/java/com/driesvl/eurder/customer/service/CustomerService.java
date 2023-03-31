package com.driesvl.eurder.customer.service;

import com.driesvl.eurder.customer.repository.CustomerMapper;
import com.driesvl.eurder.customer.repository.CustomerRepository;
import com.driesvl.eurder.customer.repository.domain.Customer;
import com.driesvl.eurder.customer.repository.domain.dto.CreateCustomerDTO;
import com.driesvl.eurder.customer.repository.domain.dto.CustomerDTO;
import com.driesvl.eurder.exceptions.types.AlreadyExistsException;
import com.driesvl.eurder.authorization.repository.UserRepository;
import com.driesvl.eurder.authorization.repository.domain.Role;
import com.driesvl.eurder.authorization.repository.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, UserRepository userRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.customerMapper = customerMapper;
    }

    // TODO: NEEDS SERIOUS REFACTORING: CHECK IF USER EXISTS FIRST, ONLY THEN CREATE A NEW ONE
    // TODO: THE SERVICE IS DOING THE MAPPERS WORK FOR USER
    // TODO: NULLS EVERYWHERE CRASH THE APP -> NEED VALIDATION OF FIELDS FIRST!!!
    public String addCustomer(CreateCustomerDTO createCustomerDTO) {
        User user = new User(createCustomerDTO.email(), createCustomerDTO.password(), Role.CUSTOMER);
        user = addUserOrReturnOldUser(user);
        Customer customer = this.customerMapper.fromCreateDTOAndUser(createCustomerDTO, user);
        this.customerRepository.addCustomer(customer);
        return customer.getUser().getId().toString();
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerMapper.toDTO(customerRepository.getAllCustomers());
    }

    public CustomerDTO getCustomerById(String id) {
        User user = userRepository.getUserById(UUID.fromString(id));
        return customerMapper.toDTO(customerRepository.getCustomer(user));
    }

    private User addUserOrReturnOldUser(User user) {
        try {
            this.userRepository.addUser(user);
        }
        catch (AlreadyExistsException e) {
            // TODO: THIS IS REALLY BAD, DO I REALLY NEED EXCEPTIONS WHEN SOMETHING ALREADY EXISTS?
            Logger logger = LoggerFactory.getLogger(CustomerService.class);
            logger.warn("SWALLOWING THIS EXCEPTION");
        }
        return this.userRepository.getUser(user.getEmail())
                .orElse(user);
    }
}
