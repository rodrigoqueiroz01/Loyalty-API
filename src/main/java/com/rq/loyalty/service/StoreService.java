package com.rq.loyalty.service;

import com.rq.loyalty.exception.DataAlreadyRegisteredException;
import com.rq.loyalty.exception.EntityNotFoundException;
import com.rq.loyalty.entity.Store;
import com.rq.loyalty.repository.StoreRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public Store save(Store store) {
        if (Objects.nonNull(storeRepository.findByDocument(store.getDocument())) ||
                Objects.nonNull(storeRepository.findByName(store.getName()))) {
            throw new DataAlreadyRegisteredException("This data is already registered in the system.");
        }

        store.setCreatedAt(LocalDateTime.now());
        return storeRepository.save(store);
    }

    public List<Store> findAll(String name) {
        return storeRepository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        });
    }

    public Store findById(String storeId) {
        return storeRepository.findById(storeId).orElseThrow(() -> new EntityNotFoundException("No record found in the system."));
    }

    public Store update(Store store, String storeId) {
        findById(storeId);
        store.setStoreId(storeId);
        return storeRepository.save(store);
    }

    public String delete(String storeId) {
        var store = findById(storeId);
        storeRepository.deleteById(storeId);
        return store.getStoreId();
    }

}
