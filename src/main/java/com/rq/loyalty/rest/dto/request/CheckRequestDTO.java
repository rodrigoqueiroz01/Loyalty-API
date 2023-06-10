package com.rq.loyalty.rest.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckRequestDTO {

    private String customerId;
    private String storeId;
    private String ruleId;
    private Integer points;
    private Integer amount;

}
