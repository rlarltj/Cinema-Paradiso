package com.prgrms.movieprj.repository;

import com.prgrms.movieprj.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);

    Optional<Customer> findByEmail(String email);
}
