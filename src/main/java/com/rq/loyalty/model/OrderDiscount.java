package com.rq.loyalty.model;

import com.rq.loyalty.model.enums.TargetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDiscount implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private Price amount;
    private TargetType target;
    private String targetId;
    private List<SponsorshipValue> sponsorshipValues;

}

