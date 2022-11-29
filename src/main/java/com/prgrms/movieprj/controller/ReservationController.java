package com.prgrms.movieprj.controller;

import com.prgrms.movieprj.dto.request.ReservationForm;
import com.prgrms.movieprj.dto.response.ReservationDto;
import com.prgrms.movieprj.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserve")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @DeleteMapping("/{reserveId}")
    public ResponseEntity<Void> cancel(@PathVariable int reserveId) {
        reservationService.cancel(reserveId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationDto> reserve(@RequestBody ReservationForm form) {
        ReservationDto reservationDto = reservationService.reserve(form);

        return new ResponseEntity<>(reservationDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> showCustomerReservation(@RequestParam String email) {
        List<ReservationDto> reservationDtoList = reservationService.findByEmail(email);

        return new ResponseEntity<>(reservationDtoList, HttpStatus.OK);
    }
}
