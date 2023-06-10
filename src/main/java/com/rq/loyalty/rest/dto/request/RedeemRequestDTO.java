package com.rq.loyalty.rest.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedeemRequestDTO {

    private String customerId;
    private String storeId;
    private String ruleId;
    private String orderId;  // order em que será dado o benefício
    private Integer points;
    private Integer amount;
    private String productId;
    private String productName;

}
