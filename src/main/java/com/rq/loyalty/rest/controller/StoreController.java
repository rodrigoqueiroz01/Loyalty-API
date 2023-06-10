package com.rq.loyalty.rest.controller;

import com.rq.loyalty.rest.controller.interfaces.IStoreController;
import com.rq.loyalty.rest.dto.mapper.StoreMapper;
import com.rq.loyalty.rest.dto.request.StoreRequestDTO;
import com.rq.loyalty.rest.dto.response.StoreResponseDTO;
import com.rq.loyalty.service.StoreService;
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
@RequestMapping("/v1/store")
public class StoreController implements IStoreController {

    private final StoreService storeService;

    @GetMapping(value = "/health")
    public ResponseEntity healthCheck() {
        return ResponseEntity.accepted().build();
    }

    @PostMapping
    public ResponseEntity<StoreResponseDTO> save(@Valid @RequestBody StoreRequestDTO storeRequest) {
        log.info("POST /v1/store");
        return ResponseEntity.status(HttpStatus.CREATED).body(StoreMapper.toResponse(storeService.save(StoreMapper.toModel(storeRequest))));
    }

    @GetMapping
    public ResponseEntity<List<StoreResponseDTO>> findAll(@RequestParam(name = "name", required = false) String name) {
        log.info("GET /v1/store");
        return ResponseEntity.ok().body(StoreMapper.toResponseList(storeService.findAll(name)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponseDTO> findById(@PathVariable("id") String storeId) {
        log.info("GET /v1/store/" + storeId);
        return ResponseEntity.ok().body(StoreMapper.toResponse(storeService.findById(storeId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreResponseDTO> update(@Valid @RequestBody StoreRequestDTO storeRequest, @PathVariable("id") String storeId) {
        log.info("PUT /v1/store/" + storeId);
        return ResponseEntity.ok().body(StoreMapper.toResponse(storeService.update(StoreMapper.toModel(storeRequest), storeId)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String storeId) {
        log.info("DELETE /v1/store/" + storeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(storeService.delete(storeId));
    }

}
