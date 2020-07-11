package tads.firstspringexercise.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity (name = "Transaction")
public class Transaction {
    // transação financeira
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Double value;
    String title;
    String type;
}
