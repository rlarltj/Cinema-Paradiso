package com.prgrms.movieprj.service;

import com.prgrms.movieprj.dto.response.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> findAll();

    MovieDto findById(Long id);
}
