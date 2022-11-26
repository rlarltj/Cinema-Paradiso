package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.dto.CustomerRegisterForm;
import com.prgrms.movieprj.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer join(CustomerRegisterForm form) {
        Customer customer = Customer.builder()
                .name(form.getName())
                .email(form.getEmail())
                .phoneNumber(form.getPhoneNumber())
                .build();

        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

}
