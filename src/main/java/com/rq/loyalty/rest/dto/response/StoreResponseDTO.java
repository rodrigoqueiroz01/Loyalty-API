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
public class StoreResponseDTO {

    private String storeId;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String document;
    private String name;

}
