package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.dto.request.CustomerRegisterForm;

import java.util.Optional;

public interface CustomerService {
    Customer join(CustomerRegisterForm form);

    Optional<Customer> findByName(String name);
}
