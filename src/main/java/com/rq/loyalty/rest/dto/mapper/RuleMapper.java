package com.rq.loyalty.rest.dto.mapper;

import com.rq.loyalty.entity.Rule;
import com.rq.loyalty.rest.dto.request.RuleRequestDTO;
import com.rq.loyalty.rest.dto.response.RuleResponseDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RuleMapper {

    public static Rule toModel(RuleRequestDTO ruleRequest) {
        return Rule.builder()
                .name(ruleRequest.getName())
                .conversion(ruleRequest.getConversion())
                .daysToExpire(ruleRequest.getDaysToExpire())
                .redeemLimit(ruleRequest.getRedeemLimit())
                .productId(ruleRequest.getProductId())
                .productName(ruleRequest.getProductName())
                .build();
    }

    public static RuleResponseDTO toResponse(Rule rule) {
        return RuleResponseDTO.builder()
                .ruleId(rule.getRuleId())
                .createdAt(rule.getCreatedAt())
                .name(rule.getName())
                .conversion(rule.getConversion())
                .daysToExpire(rule.getDaysToExpire())
                .redeemLimit(rule.getRedeemLimit())
                .productId(rule.getProductId())
                .productName(rule.getProductName())
                .build();
    }

    public static List<RuleResponseDTO> toResponseList(List<Rule> ruleList) {
        if (Objects.isNull(ruleList) || ruleList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return ruleList.stream().map(RuleMapper::toResponse).collect(Collectors.toList());
        }
    }

}
