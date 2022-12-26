package com.prgrms.movieprj.service;

import com.prgrms.movieprj.dto.request.CustomerRegisterForm;
import com.prgrms.movieprj.dto.response.CustomerDto;

public interface CustomerService {
    Long join(CustomerRegisterForm form);

    CustomerDto findByName(String name);

    CustomerDto findById(Long customerId);
}
