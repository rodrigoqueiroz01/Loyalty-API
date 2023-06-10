package com.rq.loyalty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction-data", schema = "public")
public class Transaction implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seqId;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column
    private Integer type; // 0 - resgate | 1 - pontuação (acúmulo)

    @Column(name = "rule_id", nullable = false)
    private String ruleId;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "store_id", nullable = false)
    private String storeId;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false)
    private Integer amount;

    private LocalDateTime expiration;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

}
