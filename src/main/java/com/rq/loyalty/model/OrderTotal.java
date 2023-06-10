package com.rq.loyalty.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderTotal implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private Price itemsPrice;
    private Price otherFees;
    private Price discount;
    private Price orderAmount;

}
