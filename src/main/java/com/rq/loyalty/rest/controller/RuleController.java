package com.rq.loyalty.rest.controller;

import com.rq.loyalty.rest.controller.interfaces.IRuleController;
import com.rq.loyalty.rest.dto.mapper.RuleMapper;
import com.rq.loyalty.rest.dto.request.RuleRequestDTO;
import com.rq.loyalty.rest.dto.response.RuleResponseDTO;
import com.rq.loyalty.service.RuleService;
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
@RequestMapping("/v1/rule")
public class RuleController implements IRuleController {

    private final RuleService ruleService;

    @GetMapping("/health")
    public ResponseEntity healthCheck() {
        log.info("GET /v1/rule/health");
        return ResponseEntity.accepted().build();
    }

    @PostMapping
    public ResponseEntity<RuleResponseDTO> save(@Valid @RequestBody RuleRequestDTO ruleRequest) {
        log.info("POST /v1/rule");
        return ResponseEntity.status(HttpStatus.CREATED).body(RuleMapper.toResponse(ruleService.save(RuleMapper.toModel(ruleRequest))));
    }

    @GetMapping
    public ResponseEntity<List<RuleResponseDTO>> findAll() {
        log.info("GET /v1/rule");
        return ResponseEntity.ok().body(RuleMapper.toResponseList(ruleService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RuleResponseDTO> findById(@PathVariable("id") String ruleId) {
        log.info("GET /v1/rule/" + ruleId);
        return ResponseEntity.ok().body(RuleMapper.toResponse(ruleService.findById(ruleId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RuleResponseDTO> update(@Valid @RequestBody RuleRequestDTO ruleRequest, @PathVariable("id") String ruleId) {
        log.info("PUT /v1/rule/" + ruleId);
        return ResponseEntity.ok().body(RuleMapper.toResponse(ruleService.update(RuleMapper.toModel(ruleRequest), ruleId)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String ruleId) {
        log.info("DELETE /v1/rule/" + ruleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ruleService.delete(ruleId));
    }

}
