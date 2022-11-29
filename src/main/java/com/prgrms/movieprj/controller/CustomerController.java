package com.prgrms.movieprj.controller;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.dto.request.CustomerRegisterForm;
import com.prgrms.movieprj.dto.response.ReviewDto;
import com.prgrms.movieprj.service.CustomerService;
import com.prgrms.movieprj.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final ReviewService reviewService;

    @GetMapping("/{customerId}/review")
    public ResponseEntity<List<ReviewDto>> showCustomerReviews(@PathVariable int customerId) {
        List<ReviewDto> reviews = reviewService.findByCustomer(customerId);

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> register(@RequestBody CustomerRegisterForm registerForm) {
        Customer customer = customerService.join(registerForm);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
