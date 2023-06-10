package com.rq.loyalty.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleResponseDTO {

    private String ruleId;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String name;
    private Double conversion;
    private Integer daysToExpire;
    private Integer redeemLimit;
    private String productId;
    private String productName;

}
