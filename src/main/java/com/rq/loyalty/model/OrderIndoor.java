package com.rq.loyalty.model;

import com.rq.loyalty.model.enums.IndoorMode;
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
public class OrderIndoor implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private IndoorMode mode;
    private LocalDateTime indoorDateTime;
    private String place;

}
