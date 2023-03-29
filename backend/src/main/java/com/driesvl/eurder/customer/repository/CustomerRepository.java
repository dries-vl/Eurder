package com.driesvl.eurder.customer.repository;

import com.driesvl.eurder.customer.repository.domain.Customer;
import com.driesvl.eurder.exceptions.types.IdAlreadyTakenException;
import com.driesvl.eurder.exceptions.types.InvalidUserIdException;
import com.driesvl.eurder.helper.repository.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository {
    private final CustomerDB customerDB;

    @Autowired
    public CustomerRepository(CustomerDB customerDB) {
        this.customerDB = customerDB;
    }

    public void addCustomer(Customer customer) {
        throwIfUserAlreadyExists(customer.getUser());
        getCustomerDB().put(customer.getUser(), customer);
    }

    public Customer getCustomer(User user) {
        throwIfCustomerNotFound(user);
        return getCustomerDB().get(user);
    }

    public List<Customer> getAllCustomers() {
        return getCustomerDB().values().stream().toList();
    }

    private void throwIfCustomerNotFound(User user) throws IdAlreadyTakenException {
        if (!getCustomerDB().containsKey(user)) {
            throw new InvalidUserIdException(this.getClass().getSimpleName(), "Customer not found");
        }
    }
    private void throwIfUserAlreadyExists(User user) throws IdAlreadyTakenException {
        if (getCustomerDB().containsKey(user)) {
            throw new IdAlreadyTakenException(this.getClass().getSimpleName(), "User already used for another customer account");
        }
    }

    private Map<User, Customer> getCustomerDB() {
        return this.customerDB.getCustomerDB();
    }
}
