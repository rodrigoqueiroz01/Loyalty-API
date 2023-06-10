package com.rq.loyalty.repository;

import com.rq.loyalty.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, String>, JpaSpecificationExecutor {

    Store findByDocument(String document);
    Store findByName(String name);

}
