package com.example.syndicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrower_info_change")
@Getter
@Setter
public class BorrowerInfoChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false)
    private Borrower borrower;

    @Column(name = "change_date_time", nullable = false)
    private LocalDateTime changeDateTime;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String changes;
}