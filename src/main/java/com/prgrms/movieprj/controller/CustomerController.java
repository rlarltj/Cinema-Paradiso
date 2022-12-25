package com.prgrms.movieprj.controller;

import com.prgrms.movieprj.dto.request.CustomerRegisterForm;
import com.prgrms.movieprj.dto.response.ApiResponse;
import com.prgrms.movieprj.dto.response.CustomerDto;
import com.prgrms.movieprj.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ApiResponse<Long> register(@Valid @RequestBody CustomerRegisterForm registerForm) {
        Long savedCustomerId = customerService.join(registerForm);
        return ApiResponse.created(savedCustomerId);
    }

    @GetMapping("/{id}")
    public ApiResponse<CustomerDto> findOne(@PathVariable Long id) {
        CustomerDto customerDto = customerService.findById(id);
        return ApiResponse.ok(customerDto);
    }

    @GetMapping
    public ApiResponse<CustomerDto> findByName(@RequestParam String name) {
        CustomerDto customerDto = customerService.findByName(name);
        return ApiResponse.ok(customerDto);
    }
}
