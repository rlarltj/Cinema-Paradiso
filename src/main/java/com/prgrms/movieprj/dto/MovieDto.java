package com.prgrms.movieprj.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class MovieDto {
    private int id;

    private String name;

    private String director;

    private int price;

    private int running;

    private LocalDateTime timeTable;

    private Long reviewNum;
    private List<ReviewDto> reviews;
}
