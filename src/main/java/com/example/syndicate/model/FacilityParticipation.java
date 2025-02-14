package com.example.syndicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "facility_participation")
@Getter
@Setter
public class FacilityParticipation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;

    @ManyToOne
    @JoinColumn(name = "investor_id", nullable = false)
    private Investor investor;

    @Column(name = "share_percentage", nullable = false)
    private BigDecimal sharePercentage;

    @OneToMany(mappedBy = "facilityParticipation")
    private List<DrawdownAllocation> drawdownAllocations;

    @OneToMany(mappedBy = "facilityParticipation")
    private List<FacilityTrade> facilityTrades;
}