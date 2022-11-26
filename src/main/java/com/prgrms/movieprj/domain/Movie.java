package com.prgrms.movieprj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Movie extends BaseEntity{
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String director;

    private int price;

    private int running;

    private LocalDateTime timeTable;

    @OneToMany(mappedBy = "movie")
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
}
