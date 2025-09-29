package service;

import model.Transaction;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Service pour la logique métier des transactions bancaires.
 */
public class TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();

    public void ajouterTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.getCompteSource().ajouterTransaction(transaction);
        transaction.getCompteDestination().ifPresent(c -> c.ajouterTransaction(transaction));
    }

    public void modifierTransaction(Transaction transaction) {
        transactions.removeIf(t -> t.getIdTransaction().equals(transaction.getIdTransaction()));
        ajouterTransaction(transaction);
    }

    public void supprimerTransaction(String idTransaction) {
        transactions.removeIf(t -> t.getIdTransaction().equals(idTransaction));
    }

    public Optional<Transaction> rechercherTransaction(String idTransaction) {
        return transactions.stream()
                .filter(t -> t.getIdTransaction().equals(idTransaction))
                .findFirst();
    }

    public List<Transaction> filtrerTransactions(Predicate<Transaction> predicate) {
        return transactions.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}