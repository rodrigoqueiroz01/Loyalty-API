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
@Table(name = "balance-data", schema = "public")
public class Balance implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    private String customerId;

    @Column(name = "store_id", nullable = false)
    private String storeId;

    @Column(name = "rule_id", nullable = false)
    private String ruleId;

    @Column(nullable = false)
    private Integer points; // saldo em pontos

    @Column(nullable = false)
    private Integer amount; // saldo em reais

    @Column(name = "next_expiration_date")
    private LocalDateTime nextExpirationDate;  // data hora dos próximos pontos a expirar

    @Column(name = "next_expiration_points", nullable = false)
    private Integer nextExpirationPoints; // próximos pontos a expirar

    @Column(name = "points_to_expire_in_30", nullable = false)
    private Integer pointsToExpireIn30; // quantidade de pontos a expirar dentro de 30 dias

}
