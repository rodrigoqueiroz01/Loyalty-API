package com.rq.loyalty.service;

import com.rq.loyalty.exception.DataAlreadyRegisteredException;
import com.rq.loyalty.exception.EntityNotFoundException;
import com.rq.loyalty.entity.Customer;
import com.rq.loyalty.repository.CustomerRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        if (Objects.nonNull(customerRepository.findByDocument(customer.getDocument())) ||
                Objects.nonNull(customerRepository.findByName(customer.getName()))) {
            throw new DataAlreadyRegisteredException("This data is already registered in the system.");
        }

        customer.setCreatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    public List<Customer> findAll(String name) {
        return customerRepository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        });
    }

    public Customer findById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No record found in the system."));
    }

    public Customer update(Customer customer, String id) {
        findById(id);
        customer.setCustomerId(id);
        return customerRepository.save(customer);
    }

    public String delete(String id) {
        var customer = findById(id);
        customerRepository.deleteById(id);
        return customer.getCustomerId();
    }

}
