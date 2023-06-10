package com.rq.loyalty.service;

import com.rq.loyalty.entity.Customer;
import com.rq.loyalty.entity.Transaction;
import com.rq.loyalty.repository.TransactionRepository;
import com.rq.loyalty.rest.dto.mapper.CheckMapper;
import com.rq.loyalty.rest.dto.mapper.PointMapper;
import com.rq.loyalty.rest.dto.mapper.RedeemMapper;
import com.rq.loyalty.rest.dto.request.CheckRequestDTO;
import com.rq.loyalty.rest.dto.request.PointRequestDTO;
import com.rq.loyalty.rest.dto.request.RedeemRequestDTO;
import com.rq.loyalty.rest.dto.response.CheckResponseDTO;
import com.rq.loyalty.rest.dto.response.PointResponseDTO;
import com.rq.loyalty.rest.dto.response.RedeemResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> findAllByCustomer(String customerId) throws Exception {
        var customer = new Customer();
        customer.setCustomerId(customerId);
        return transactionRepository.findAllByCustomerId(customer.getCustomerId());
    }

    public CheckResponseDTO checkPoints(CheckRequestDTO checkRequest) throws Exception {
        if (transactionRepository.findByPoints(checkRequest.getPoints()) > 0) {
            return CheckMapper.toResponse(CheckMapper.toModel(checkRequest));
        } else {
            throw new RuntimeException("Insufficient balance to redeem.");
        }
    }

    public PointResponseDTO point(PointRequestDTO pointRequest) throws Exception {
        var transaction = new Transaction();
        transaction.setTransactionId(String.valueOf(UUID.randomUUID()));

        return PointMapper.toResponse(save(PointMapper.toModel(pointRequest)));
    }

    public RedeemResponseDTO redeem(RedeemRequestDTO redeemRequest) throws Exception {
        if (transactionRepository.findByPoints(redeemRequest.getPoints()) > 0) {
            var transaction = save(RedeemMapper.toModel(redeemRequest));
            return RedeemMapper.toResponse(transaction);
        } else {
            throw new RuntimeException("Unable to redeem! Insufficient balance.");
        }
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

}
