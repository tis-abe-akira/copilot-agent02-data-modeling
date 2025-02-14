package com.example.syndicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "investor_info_change")
@Getter
@Setter
public class InvestorInfoChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "investor_id", nullable = false)
    private Investor investor;

    @Column(name = "change_date_time", nullable = false)
    private LocalDateTime changeDateTime;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String changes;
}