package tads.firstspringexercise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.firstspringexercise.models.Transaction;
import tads.firstspringexercise.repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    TransactionRepository transactionRepository;

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
