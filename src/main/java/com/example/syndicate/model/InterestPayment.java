package com.example.syndicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "interest_payment")
@Getter
@Setter
public class InterestPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drawdown_id", nullable = false)
    private Drawdown drawdown;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "payment_date_time", nullable = false)
    private LocalDateTime paymentDateTime;
}