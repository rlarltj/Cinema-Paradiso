package com.prgrms.movieprj.controller;

import com.prgrms.movieprj.dto.response.ApiResponse;
import com.prgrms.movieprj.dto.response.MovieDto;
import com.prgrms.movieprj.dto.response.ReviewDto;
import com.prgrms.movieprj.service.MovieService;
import com.prgrms.movieprj.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ApiResponse<List<MovieDto>> findAll() {
        // TODO 커서 기반 페이징 및 일급 컬렉션으로 변경
        List<MovieDto> movieDtoList = movieService.findAll();
        return ApiResponse.ok(movieDtoList);
    }

    @GetMapping("/{id}")
    public ApiResponse<MovieDto> findOne(@PathVariable Long id) {
        MovieDto movieDto = movieService.findById(id);

        return ApiResponse.ok(movieDto);
    }
}
