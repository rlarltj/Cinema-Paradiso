package com.prgrms.movieprj.service;

import com.prgrms.movieprj.domain.Movie;
import com.prgrms.movieprj.dto.MovieDto;
import com.prgrms.movieprj.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<MovieDto> findAll() {
        List<Object[]> result = movieRepository.findMovieWithReviewCnt();

        List<MovieDto> dtoList = result.stream()
                .map(obj -> {
                    Movie movie = (Movie) obj[0];
                    MovieDto movieDto = entityToDto(movie);
                    movieDto.setReviewNum((Long) obj[1]);
                    return movieDto;
                }).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public MovieDto findById(int id) {

        Optional<Movie> findOne = movieRepository.findById(id);

        Movie movie = findOne.orElseThrow(() -> new RuntimeException());

        return entityToDto(movie);
    }
}
