package com.example.syndicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "facility_trade")
@Getter
@Setter
public class FacilityTrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facility_participation_id", nullable = false)
    private FacilityParticipation facilityParticipation;

    @ManyToOne
    @JoinColumn(name = "from_investor_id", nullable = false)
    private Investor fromInvestor;

    @ManyToOne
    @JoinColumn(name = "to_investor_id", nullable = false)
    private Investor toInvestor;

    @Column(name = "trade_date_time", nullable = false)
    private LocalDateTime tradeDateTime;
}