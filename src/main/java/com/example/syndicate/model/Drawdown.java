package com.example.syndicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "drawdown")
@Getter
@Setter
public class Drawdown {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false)
    private Borrower borrower;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "drawdown_date_time", nullable = false)
    private LocalDateTime drawdownDateTime;

    @OneToMany(mappedBy = "drawdown")
    private List<DrawdownAllocation> allocations;

    @OneToMany(mappedBy = "drawdown")
    private List<InterestPayment> interestPayments;

    @OneToMany(mappedBy = "drawdown")
    private List<PrincipalPayment> principalPayments;
}