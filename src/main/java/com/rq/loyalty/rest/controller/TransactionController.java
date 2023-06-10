package com.rq.loyalty.rest.controller;

import com.rq.loyalty.entity.Transaction;
import com.rq.loyalty.rest.controller.interfaces.ITransactionController;
import com.rq.loyalty.rest.dto.request.CheckRequestDTO;
import com.rq.loyalty.rest.dto.request.PointRequestDTO;
import com.rq.loyalty.rest.dto.request.RedeemRequestDTO;
import com.rq.loyalty.rest.dto.response.CheckResponseDTO;
import com.rq.loyalty.rest.dto.response.PointResponseDTO;
import com.rq.loyalty.rest.dto.response.RedeemResponseDTO;
import com.rq.loyalty.service.TransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/v1/transaction")
public class TransactionController implements ITransactionController {

    private final TransactionService transactionService;

    @GetMapping(value = "/health")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customerId")
    public ResponseEntity<List<Transaction>> findAllByCustomer(@RequestParam String customerId) throws Exception {
        log.info("GET transaction?customerId=<id do customer>");
        return ResponseEntity.ok().body(transactionService.findAllByCustomer(customerId));
    }

    // TODO verifica a pontuação do customer CheckRequestDTO // Não concluído
    @GetMapping("/check")
    public ResponseEntity<CheckResponseDTO> checkPoints(CheckRequestDTO checkRequest) throws Exception {
        log.info("GET transaction/check");
         return ResponseEntity.ok(transactionService.checkPoints(checkRequest));
    }

    @PostMapping("/point")
    public ResponseEntity<PointResponseDTO> savePoint(@Valid @RequestBody PointRequestDTO pointRequest) throws Exception {
        log.info("POST transaction/point");
        return ResponseEntity.ok(transactionService.point(pointRequest));
    }

    @PostMapping("/redeem")
    public ResponseEntity<RedeemResponseDTO> saveRedeem(@Valid @RequestBody RedeemRequestDTO redeemRequest) throws Exception {
        log.info("POST transaction/redeem");
        return ResponseEntity.ok(transactionService.redeem(redeemRequest));
    }

}
