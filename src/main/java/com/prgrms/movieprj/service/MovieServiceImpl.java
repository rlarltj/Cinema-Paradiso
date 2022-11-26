package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Movie;
import com.prgrms.movieprj.dto.MovieDto;
import com.prgrms.movieprj.repository.MovieRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {
    private final MovieRespository movieRespository;

    @Override
    public List<MovieDto> findAll() {
        List<Movie> movies = movieRespository.findAll();

        return movies.stream()
                .map(movie -> entityToDto(movie))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto findById(int id) {

        Optional<Movie> findOne = movieRespository.findById(id);

        Movie movie = findOne.orElseThrow(() -> new RuntimeException());

        return entityToDto(movie);
    }
}
