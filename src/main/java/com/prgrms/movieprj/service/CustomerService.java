package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Customer;
import com.prgrms.movieprj.domain.Reservation;
import com.prgrms.movieprj.dto.CustomerDto;
import com.prgrms.movieprj.dto.CustomerRegisterForm;
import com.prgrms.movieprj.dto.ReservationDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer join(CustomerRegisterForm form);

    Optional<Customer> findByName(String name);
//
//    default CustomerDto entityToDto(Customer customer){
//        return CustomerDto.builder()
//                .email(customer.getEmail())
//                .name(customer.getName())
//                .phoneNumber(customer.getPhoneNumber())
//                .reservationList(null).build();
//    }
//
//    default Customer dtoToEntity(CustomerDto dto) {
//
//        Customer customer = Customer.builder()
//                .email(dto.getEmail())
//                .name(dto.getName())
//                .phoneNumber(dto.getPhoneNumber())
//                .build();
//
//        List<ReservationDto> reservationDtoList = dto.getReservationDtoList();
//        Reservation.builder()
//                .customer(customer)
//                .movie()
//    }

}
