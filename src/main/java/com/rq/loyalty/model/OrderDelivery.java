package com.rq.loyalty.model;

import com.rq.loyalty.model.enums.DeliveredBy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDelivery implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private DeliveredBy deliveredBy;
    private DeliveryAddress deliveryAddress;
    private LocalDateTime estimatedDeliveryDateTime;
    private LocalDateTime deliveryDateTime;

}
