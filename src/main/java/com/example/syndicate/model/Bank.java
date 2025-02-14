package com.example.syndicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bank")
@Getter
@Setter
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_lead_bank", nullable = false)
    private boolean isLeadBank;

    @OneToMany(mappedBy = "bank")
    private List<Facility> facilities;
}