package com.rq.loyalty.rest.dto.mapper;

import com.rq.loyalty.entity.Transaction;
import com.rq.loyalty.rest.dto.request.CheckRequestDTO;
import com.rq.loyalty.rest.dto.response.CheckResponseDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CheckMapper {

    public static Transaction toModel(CheckRequestDTO checkRequest) {
        return Transaction.builder()
                .customerId(checkRequest.getCustomerId())
                .storeId(checkRequest.getStoreId())
                .ruleId(checkRequest.getRuleId())
                .points(checkRequest.getPoints())
                .amount(checkRequest.getAmount())
                .build();
    }

    public static CheckResponseDTO toResponse(Transaction transaction) {
        return CheckResponseDTO.builder()
                .customerId(transaction.getCustomerId())
                .storeId(transaction.getStoreId())
                .ruleId(transaction.getRuleId())
                .points(transaction.getPoints())
                .amount(transaction.getAmount())
//                .nextExpirationDate(transaction.getExpiration()) // ver como funciona esse...
//                .nextExpirationPoints(transaction.getPoints())
//                .pointsToExpireIn30(transaction.getPoints())
                .build();
    }

    public static List<CheckResponseDTO> toResponseList(List<Transaction> transactionList) {
        if (Objects.isNull(transactionList) || transactionList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return transactionList.stream().map(CheckMapper::toResponse).collect(Collectors.toList());
        }
    }

}
