package com.rq.loyalty.rest.dto.mapper;

import com.rq.loyalty.entity.Transaction;
import com.rq.loyalty.rest.dto.request.PointRequestDTO;
import com.rq.loyalty.rest.dto.response.PointResponseDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PointMapper {

    public static Transaction toModel(PointRequestDTO pointRequest) {
        return Transaction.builder()
                .customerId(pointRequest.getCustomerId())
                .storeId(pointRequest.getStoreId())
                .ruleId(pointRequest.getRuleId())
                .points(pointRequest.getPoints())
                .amount(pointRequest.getAmount())
                .orderId(pointRequest.getOrderId())
                .build();
    }

    public static PointResponseDTO toResponse(Transaction transaction) {
        return PointResponseDTO.builder()
                .transactionId(transaction.getTransactionId())
                .customerId(transaction.getCustomerId())
                .storeId(transaction.getStoreId())
                .ruleId(transaction.getRuleId())
                .points(transaction.getPoints())
                .amount(transaction.getAmount())
                .balancePoints(transaction.getPoints())
                .balanceAmount(transaction.getAmount())
                .orderId(transaction.getOrderId())
                .build();
    }

    public static List<PointResponseDTO> toResponseList(List<Transaction> transactionList) {
        if (Objects.isNull(transactionList) || transactionList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return transactionList.stream().map(PointMapper::toResponse).collect(Collectors.toList());
        }
    }

}
