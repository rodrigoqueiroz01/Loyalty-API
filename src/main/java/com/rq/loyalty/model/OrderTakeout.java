package com.rq.loyalty.model;

import com.rq.loyalty.model.enums.TakeoutMode;
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
public class OrderTakeout implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private TakeoutMode mode;
    private LocalDateTime takeoutDateTime;

}
