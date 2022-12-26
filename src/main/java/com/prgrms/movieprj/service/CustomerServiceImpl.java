package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.dto.request.CustomerRegisterForm;
import com.prgrms.movieprj.dto.response.CustomerDto;
import com.prgrms.movieprj.repository.CustomerRepository;
import com.prgrms.movieprj.util.EntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final EntityConverter converter;

    @Override
    @Transactional
    public Long join(CustomerRegisterForm form) {
        Customer customer = converter.dtoToCustomer(form);
        customerRepository.save(customer);

        return customer.getId();
    }

    @Override
    public CustomerDto findByName(String name) {
        Customer findOne = customerRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원 이름입니다."));

        return converter.customerToDto(findOne);
    }

    @Override
    public CustomerDto findById(Long customerId) {
        Customer findOne = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        return converter.customerToDto(findOne);
    }
}
