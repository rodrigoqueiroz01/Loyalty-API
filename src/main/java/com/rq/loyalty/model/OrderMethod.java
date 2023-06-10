package com.rq.loyalty.model;

import com.rq.loyalty.model.enums.MethodType;
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
public class OrderMethod implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private Double value;
    private String currency;
    private Type type;
    private MethodType method;
    private String methodInfo;
    private Double changeFor;

    public enum Type {
        PREPAID,
        PENDING;
    }

}
