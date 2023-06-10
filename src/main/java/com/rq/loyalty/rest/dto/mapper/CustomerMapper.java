package com.rq.loyalty.rest.dto.mapper;

import com.rq.loyalty.entity.Customer;
import com.rq.loyalty.rest.dto.request.CustomerRequestDTO;
import com.rq.loyalty.rest.dto.response.CustomerResponseDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public static Customer toModel(CustomerRequestDTO customerRequest) {
        return Customer.builder()
                .document(customerRequest.getDocument())
                .name(customerRequest.getName())
                .build();
    }

    public static CustomerResponseDTO toResponse(Customer customer) {
        return CustomerResponseDTO.builder()
                .customerId(customer.getCustomerId())
                .createdAt(customer.getCreatedAt())
                .document(customer.getDocument())
                .name(customer.getName())
                .build();
    }

    public static List<CustomerResponseDTO> toResponseList(List<Customer> customerList) {
        if (Objects.isNull(customerList) || customerList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return customerList.stream().map(CustomerMapper::toResponse).collect(Collectors.toList());
        }
    }

}
