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
public class Customer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    private String email;

    private String name;

    private String phoneNumber;

    @Builder.Default
    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservation = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "customer")
    private List<Review> reviews = new ArrayList<>();
}
