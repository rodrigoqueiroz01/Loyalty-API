package com.rq.loyalty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rule-data", schema = "public")
public class Rule implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    private String ruleId;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double conversion; // fator de conversão R$ -> pontos // default = 1

    @Column(name = "days_to_expire", nullable = false)
    private Integer daysToExpire; // dias de validade de cada pontuação

    @Column(name = "redeem_limit")
    private Integer redeemLimit;  // pontos máximos por resgate

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

}
