package com.rq.loyalty.rest.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointRequestDTO {

    private String customerId;
    private String storeId;
    private String ruleId;
    private Integer points;
    private Integer amount;
    private String orderId;  // order que originou a pontuação

}
