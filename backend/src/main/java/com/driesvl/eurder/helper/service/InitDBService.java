package com.driesvl.eurder.helper.service;

import com.driesvl.eurder.customer.repository.domain.DTO.AddressDTO;
import com.driesvl.eurder.customer.repository.domain.DTO.CreateCustomerDTO;
import com.driesvl.eurder.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitDBService {
    private static final CreateCustomerDTO CUSTOMER_1 = new CreateCustomerDTO(
            "gertje@gmail.com", "pwd",
            "Gert", "Verhulst",
            "048927521",
            new AddressDTO("Gertstraat", "15b", "Antwerpen")
    );
    private static final CreateCustomerDTO CUSTOMER_2 = new CreateCustomerDTO(
            "octo@gmail.com", "pwd",
            "Octaaf", "De Bolle",
            "046987511",
            new AddressDTO("Gertstraat", "78a", "Antwerpen")
    );
    private final CustomerService customerService;

    @Autowired
    public InitDBService(CustomerService customerService) {
        this.customerService = customerService;
        initDB();
    }

    private void initDB() {
        customerService.addCustomer(CUSTOMER_1);
        customerService.addCustomer(CUSTOMER_2);
    }
}
