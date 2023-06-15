package com.rq.loyalty.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

    private String customerId;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String CPF;
    private String name;

}
