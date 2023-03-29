package com.driesvl.eurder.customer.repository;

import com.driesvl.eurder.customer.repository.domain.Address;
import com.driesvl.eurder.customer.repository.domain.Customer;
import com.driesvl.eurder.customer.repository.domain.dto.*;
import com.driesvl.eurder.customer.repository.domain.Name;
import com.driesvl.eurder.helper.repository.domain.Role;
import com.driesvl.eurder.helper.repository.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class CustomerMapperTest {

    private static final CustomerMapper customerMapper = new CustomerMapper();
    private static final String CUSTOMER_1_STREET = "Gertstraat";
    private static final String CUSTOMER_1_STREET_NR = "15b";
    private static final String CUSTOMER_1_CITY = "Antwerpen";
    private static final String CUSTOMER_1_PHONE_NUMBER = "0474861245";
    private static final String CUSTOMER_1_FIRST_NAME = "Gert";
    private static final String CUSTOMER_1_LAST_NAME = "Verhulst";
    private static final String CUSTOMER_1_EMAIL = "gertje@gmail.com";
    private static final String CUSTOMER_1_PASSWORD = "pwd";
    private static final CreateCustomerDTO CREATE_CUSTOMER_1 = new CreateCustomerDTO(
            CUSTOMER_1_EMAIL, CUSTOMER_1_PASSWORD,
            CUSTOMER_1_FIRST_NAME, CUSTOMER_1_LAST_NAME, CUSTOMER_1_PHONE_NUMBER,
            new AddressDTO(CUSTOMER_1_STREET, CUSTOMER_1_STREET_NR, CUSTOMER_1_CITY));

    private static final User CUSTOMER_1_USER = new User(CUSTOMER_1_EMAIL, CUSTOMER_1_PASSWORD, Role.CUSTOMER);
    private static final Customer CUSTOMER_1 = new Customer(
            CUSTOMER_1_USER,
            new Name(CUSTOMER_1_FIRST_NAME, CUSTOMER_1_LAST_NAME),
            CUSTOMER_1_PHONE_NUMBER,
            new Address(CUSTOMER_1_STREET, CUSTOMER_1_STREET_NR, CUSTOMER_1_CITY));
    private static final UUID CUSTOMER_1_ID = CUSTOMER_1_USER.getId();
    private static final CustomerDTO CUSTOMER_1_DTO = new CustomerDTO(
            CUSTOMER_1_ID.toString(),
            CUSTOMER_1_EMAIL,
            new NameDTO(CUSTOMER_1_FIRST_NAME, CUSTOMER_1_LAST_NAME),
            CUSTOMER_1_PHONE_NUMBER,
            new AddressDTO(CUSTOMER_1_STREET, CUSTOMER_1_STREET_NR, CUSTOMER_1_CITY));

    @Test
    @DisplayName("Test for toDTO")
    void toDTOTest() {
        CustomerDTO actual = customerMapper.toDTO(CUSTOMER_1);
        Assertions.assertEquals(CUSTOMER_1_DTO, actual);
    }

    @Test
    @DisplayName("Test for fromCreateDTO")
    void fromCreateDTOTest() {
        Customer actual = customerMapper.fromCreateDTOAndUser(CREATE_CUSTOMER_1, CUSTOMER_1_USER);
        Assertions.assertEquals(CUSTOMER_1, actual);
    }
}