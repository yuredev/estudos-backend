package tads.firstspringexercise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.firstspringexercise.models.Transaction;
import tads.firstspringexercise.repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public void add(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }
    public Transaction getOne(Long id) {
        return this.transactionRepository.getOne(id);
    }
    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
