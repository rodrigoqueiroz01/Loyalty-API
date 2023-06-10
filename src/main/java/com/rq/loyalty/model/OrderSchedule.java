package com.rq.loyalty.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSchedule implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private LocalDateTime scheduledDateTimeStart;
    private LocalDateTime scheduledDateTimeEnd;

}
