package com.rq.loyalty.repository;

import com.rq.loyalty.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Integer findByPoints(Integer points);

    List<Transaction> findAllByCustomerId(String customerId);

}
