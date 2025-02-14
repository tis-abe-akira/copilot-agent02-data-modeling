package com.example.syndicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "borrower")
@Getter
@Setter
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "credit_rating", nullable = false)
    private String creditRating;

    @OneToMany(mappedBy = "borrower")
    private List<Drawdown> drawdowns;
}