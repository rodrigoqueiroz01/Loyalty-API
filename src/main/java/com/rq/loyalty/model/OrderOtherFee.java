package com.rq.loyalty.model;

import com.rq.loyalty.model.enums.OrderOtherFeeType;
import com.rq.loyalty.model.enums.ReicevedByType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderOtherFee implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private String name;
    private OrderOtherFeeType type;
    private ReicevedByType reicevedBy;
    private String receiverDocument;
    private Price price;
    private String observation;

}
