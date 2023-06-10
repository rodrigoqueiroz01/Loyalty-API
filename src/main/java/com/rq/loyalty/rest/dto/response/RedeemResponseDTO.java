package com.rq.loyalty.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RedeemResponseDTO {

    private String transactionId;
    private String customerId;
    private String storeId;
    private String ruleId;
    private String orderId;
    private Integer points;
    private Integer amount;
    private String productId;
    private String productName;

}
