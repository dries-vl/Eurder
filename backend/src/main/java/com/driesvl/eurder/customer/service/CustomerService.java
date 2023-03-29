package com.driesvl.eurder.customer.service;

import com.driesvl.eurder.customer.repository.CustomerMapper;
import com.driesvl.eurder.customer.repository.CustomerRepository;
import com.driesvl.eurder.customer.repository.domain.Customer;
import com.driesvl.eurder.customer.repository.domain.DTO.CreateCustomerDTO;
import com.driesvl.eurder.customer.repository.domain.DTO.CustomerDTO;
import com.driesvl.eurder.exceptions.types.UserAlreadyExistsException;
import com.driesvl.eurder.helper.repository.UserRepository;
import com.driesvl.eurder.helper.repository.domain.Role;
import com.driesvl.eurder.helper.repository.domain.User;
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
    public String addCustomer(CreateCustomerDTO createCustomerDTO) {
        User user = new User(createCustomerDTO.email(), createCustomerDTO.password(), Role.CUSTOMER);
        Customer customer = this.customerMapper.fromCreateDTOAndUser(createCustomerDTO, user);
        addUserIfItDoesNotExistYet(customer.getUser());
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

    private void addUserIfItDoesNotExistYet(User user) {
        try {
            this.userRepository.addUser(user);
        }
        catch (UserAlreadyExistsException e) {
            // TODO: THIS IS REALLY BAD, DO I REALLY NEED EXCEPTIONS WHEN SOMETHING ALREADY EXISTS?
        }
    }
}
