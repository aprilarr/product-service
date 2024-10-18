package com.apri.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

}
