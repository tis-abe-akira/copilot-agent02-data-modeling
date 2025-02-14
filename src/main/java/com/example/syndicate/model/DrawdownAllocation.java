package com.example.syndicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "drawdown_allocation")
@Getter
@Setter
public class DrawdownAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drawdown_id", nullable = false)
    private Drawdown drawdown;

    @ManyToOne
    @JoinColumn(name = "facility_participation_id", nullable = false)
    private FacilityParticipation facilityParticipation;

    @Column(nullable = false)
    private BigDecimal amount;
}