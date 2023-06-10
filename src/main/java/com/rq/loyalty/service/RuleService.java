package com.rq.loyalty.service;

import com.rq.loyalty.exception.EntityNotFoundException;
import com.rq.loyalty.entity.Rule;
import com.rq.loyalty.repository.RuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RuleService {

    private final RuleRepository ruleRepository;

    public Rule save(Rule rule) {
        rule.setCreatedAt(LocalDateTime.now());
        return ruleRepository.save(rule);
    }

    public List<Rule> findAll() {
        return ruleRepository.findAll();
    }

    public Rule findById(String ruleId) {
        return ruleRepository.findById(ruleId).orElseThrow(() -> new EntityNotFoundException("No record found in the system."));
    }

    public Rule update(Rule rule, String ruleId) {
        findById(ruleId);
        rule.setRuleId(ruleId);
        return ruleRepository.save(rule);
    }

    public String delete(String ruleId) {
        var rule = findById(ruleId);
        ruleRepository.deleteById(ruleId);
        return rule.getRuleId();
    }

}
