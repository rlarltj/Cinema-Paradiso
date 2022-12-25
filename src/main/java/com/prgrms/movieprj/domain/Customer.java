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
    private Long id;

    @NotBlank(message = "{exception.customer.email.null}")
    @Column(name = "customer_email", unique = true)
    private String email;

    @NotBlank(message = "{exception.customer.name.null}")
    @Column(name = "customer_name", unique = true)
    private String name;


    @NotBlank(message = "{exception.customer.phoneNumber.null}")
    @Length(min = 11, max = 15, message = "{exception.customer.phoneNumber.length}")
    @Column(name = "customer_phone")
    private String phoneNumber;

    @Builder.Default
    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservation = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "customer")
    private List<Review> reviews = new ArrayList<>();
}
