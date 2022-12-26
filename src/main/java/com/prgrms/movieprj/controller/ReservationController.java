package com.prgrms.movieprj.controller;

import com.prgrms.movieprj.dto.request.ReservationForm;
import com.prgrms.movieprj.dto.response.ApiResponse;
import com.prgrms.movieprj.dto.response.ReservationDto;
import com.prgrms.movieprj.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reserves")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @DeleteMapping("/{reservationId}")
    public ApiResponse<Long> cancel(@PathVariable Long reservationId) {
        reservationService.cancel(reservationId);

        return ApiResponse.ok(reservationId);
    }

    @PostMapping
    public ApiResponse<Long> reserve(@Valid @RequestBody ReservationForm form) {
        Long reservationId = reservationService.reserve(form);

        return ApiResponse.created(reservationId);
    }

    @GetMapping("/{reservationId}")
    public ApiResponse<ReservationDto> findOne(@PathVariable Long reservationId) {
        ReservationDto reservationDto = reservationService.findById(reservationId);

        return ApiResponse.ok(reservationDto);
    }

    @GetMapping
    public ApiResponse<List<ReservationDto>> showCustomerReservation(@RequestParam String email) {
        List<ReservationDto> reservationDtoList = reservationService.findByEmail(email);

        //TODO 커서기반 페이징 및 일급 컬렉션으로 변경
        return ApiResponse.ok(reservationDtoList);
    }
}
