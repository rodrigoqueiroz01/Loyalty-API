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
@Table(name = "customer-data", schema = "public")
public class Customer implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    private String customerId;

    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, length = 11, unique = true)
    private String document;

    @Column(nullable = false, unique = true)
    private String name;

}
