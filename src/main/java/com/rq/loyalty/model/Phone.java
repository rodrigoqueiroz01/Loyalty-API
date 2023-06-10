package com.rq.loyalty.model;

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
public class Phone implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private String number;
    private String extension;

}
