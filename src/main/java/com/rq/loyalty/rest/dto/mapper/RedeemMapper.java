package com.rq.loyalty.rest.dto.mapper;

import com.rq.loyalty.entity.Transaction;
import com.rq.loyalty.rest.dto.request.RedeemRequestDTO;
import com.rq.loyalty.rest.dto.response.RedeemResponseDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RedeemMapper {

    public static Transaction toModel(RedeemRequestDTO redeemRequest) {
        return Transaction.builder()
                .customerId(redeemRequest.getCustomerId())
                .storeId(redeemRequest.getStoreId())
                .ruleId(redeemRequest.getRuleId())
                .points(redeemRequest.getPoints())
                .amount(redeemRequest.getAmount())
                .orderId(redeemRequest.getOrderId())
                .build();
    }

    public static RedeemResponseDTO toResponse(Transaction transaction) {
        return RedeemResponseDTO.builder()
                .transactionId(String.valueOf(transaction.getTransactionId()))
                .customerId(transaction.getCustomerId())
                .storeId(transaction.getStoreId())
                .ruleId(transaction.getRuleId())
                .orderId(transaction.getOrderId())
                .points(transaction.getPoints())
                .amount(transaction.getAmount())
                .productId(transaction.getProductId())
                .productName(transaction.getProductName())
                .build();
    }

    public static List<RedeemResponseDTO> toResponseList(List<Transaction> transactionList) {
        if (Objects.isNull(transactionList) || transactionList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return transactionList.stream().map(RedeemMapper::toResponse).collect(Collectors.toList());
        }
    }

}
