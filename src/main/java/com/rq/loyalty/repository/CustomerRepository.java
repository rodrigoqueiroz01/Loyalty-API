package com.rq.loyalty.repository;

import com.rq.loyalty.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor {

    Customer findByDocument(String document);
    Customer findByName(String name);

}
