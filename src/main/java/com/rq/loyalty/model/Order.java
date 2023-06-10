package com.rq.loyalty.model;

import com.rq.loyalty.model.enums.LastEventType;
import com.rq.loyalty.model.enums.OrderTiming;
import com.rq.loyalty.model.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private String orderId;
    private OrderType type;
    private String displayId;
    private String sourceAppId;
    private LocalDateTime createdAt;
    private LastEventType lastEvent;
    private OrderTiming orderTiming;
    private LocalDateTime preparationStartDateTime;
    private OrderMerchant merchant;
    private List<OrderItem> items;
    private List<OrderOtherFee> otherFees;
    private List<OrderDiscount> discounts;
    private OrderTotal total;
    private OrderPayment payments;
    private OrderCustomer customer;
    private OrderSchedule schedule;
    private OrderDelivery delivery;
    private OrderTakeout takeout;
    private OrderIndoor indoor;
    private String extraInfo;

}
