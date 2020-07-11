package tads.firstspringexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.firstspringexercise.models.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByTitle(String title);
    List<Transaction> findByType(String type);
}
