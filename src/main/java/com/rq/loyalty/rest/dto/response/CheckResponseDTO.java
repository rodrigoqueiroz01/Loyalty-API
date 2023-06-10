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
public class CheckResponseDTO {

    private String customerId;
    private String storeId;
    private String ruleId;
    private Integer points; // saldo em pontos
    private Integer amount; // saldo em reais
    private LocalDateTime nextExpirationDate;  // data hora dos próximos pontos a expirar
    private Integer nextExpirationPoints; // próximos pontos a expirar
    private Integer pointsToExpireIn30; // quantidade de pontos a expirar dentro de 30 dias

}
