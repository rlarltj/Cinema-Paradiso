package com.prgrms.movieprj.controller;

import com.prgrms.movieprj.dto.request.ReservationForm;
import com.prgrms.movieprj.dto.response.ApiResponse;
import com.prgrms.movieprj.dto.response.ReservationDto;
import com.prgrms.movieprj.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reserves")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @DeleteMapping("/{reserveId}")
    public ApiResponse<Long> cancel(@PathVariable Long reserveId) {
        reservationService.cancel(reserveId);

        return ApiResponse.ok(reserveId);
    }

    @PostMapping
    public ApiResponse<ReservationDto> reserve(@Valid @RequestBody ReservationForm form) {
        ReservationDto reservationDto = reservationService.reserve(form);

        return ApiResponse.created(reservationDto);
    }

    @GetMapping
    public ApiResponse<List<ReservationDto>> showCustomerReservation(@RequestParam String email) {
        List<ReservationDto> reservationDtoList = reservationService.findByEmail(email);

        //TODO 커서기반 페이징 및 일급 컬렉션으로 변경
        return ApiResponse.ok(reservationDtoList);
    }
}
