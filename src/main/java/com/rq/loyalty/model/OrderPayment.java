package com.rq.loyalty.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPayment implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private Double prepaid;
    private Double pending;
    private List<OrderMethod> methods;

}
