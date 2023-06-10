package com.rq.loyalty.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RuleRequestDTO {

    @NotBlank(message = "Name field is mandatory.")
    private String name;

    @NotNull(message = "Conversion field is mandatory.")
    private Double conversion;

    @NotNull(message = "Days to expire field is mandatory.")
    private Integer daysToExpire;

    private Integer redeemLimit;
    private String productId;
    private String productName;

}
