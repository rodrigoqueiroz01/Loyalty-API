package com.rq.loyalty.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointResponseDTO {

    private String transactionId;
    private String customerId;
    private String storeId;
    private String ruleId;
    private Integer points;  // pontos acumulados nessa pontuação
    private Integer amount;
    private Integer balancePoints;  // pontos que o cliente tem após essa pontuação
    private Integer balanceAmount;
    private String orderId;  // order que originou a pontuação

}
