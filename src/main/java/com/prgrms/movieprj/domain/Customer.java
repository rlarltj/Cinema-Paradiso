package com.prgrms.movieprj.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @NotBlank(message = "{exception.customer.email.null}")
    private String email;

    @NotBlank(message = "{exception.customer.name.null}")
    private String name;

    @NotBlank(message = "{exception.customer.phoneNumber.null}")
    @Length(min = 11, max = 15, message = "{exception.customer.phoneNumber.length}")
    private String phoneNumber;

    @Builder.Default
    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservation = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "customer")
    private List<Review> reviews = new ArrayList<>();
}
