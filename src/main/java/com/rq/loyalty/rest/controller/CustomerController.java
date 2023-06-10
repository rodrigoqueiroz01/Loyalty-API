package com.rq.loyalty.rest.controller;

import com.rq.loyalty.rest.controller.interfaces.ICustomerController;
import com.rq.loyalty.rest.dto.mapper.CustomerMapper;
import com.rq.loyalty.rest.dto.request.CustomerRequestDTO;
import com.rq.loyalty.rest.dto.response.CustomerResponseDTO;
import com.rq.loyalty.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/v1/customer")
public class CustomerController implements ICustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/health")
    public ResponseEntity healthCheck() {
        log.info("GET /v1/customer/health");
        return ResponseEntity.accepted().build();
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> save(@Valid @RequestBody CustomerRequestDTO customerRequest) {
        log.info("POST /v1/customer");
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerMapper.toResponse(customerService.save(CustomerMapper.toModel(customerRequest))));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> findAll(@RequestParam(name = "name", required = false) String name) {
        log.info("GET /v1/customer");
        return ResponseEntity.ok().body(CustomerMapper.toResponseList(customerService.findAll(name)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> findById(@PathVariable("id") String customerId) {
        log.info("GET /v1/customer/" + customerId);
        return ResponseEntity.ok().body(CustomerMapper.toResponse(customerService.findById(customerId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> update(@Valid @RequestBody CustomerRequestDTO customerRequest, @PathVariable("id") String customerId) {
        log.info("PUT /v1/customer/" + customerId);
        return ResponseEntity.ok().body(CustomerMapper.toResponse(customerService.update(CustomerMapper.toModel(customerRequest), customerId)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String customerId) {
        log.info("DELETE /v1/customer/" + customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(customerService.delete(customerId));
    }

}
